package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.CustomerOrder;
import com.example.depropdemo.Model.DTO.CustomerDTO;
import com.example.depropdemo.Model.DTO.OrderDetailDTO;
import com.example.depropdemo.Model.DTO.OrderRequestDTO;
import com.example.depropdemo.Model.Products;
import com.example.depropdemo.Service.CustomerOrderService;
import com.example.depropdemo.Service.CustomerService;
import com.example.depropdemo.Service.ProductsService;
import com.example.depropdemo.mail.BillConfirmTemplate;
import com.example.depropdemo.mail.EmailSender;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;


@Controller
public class BillConfirmController {

    @Autowired
    private EmailSender gmailSender;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/order-success-cash")
    public String User_ordersuccess(HttpSession session, Model model) {
        OrderRequestDTO OrderRequestDT = (OrderRequestDTO) session.getAttribute("OrderRequestDT");
        CustomerDTO customer = (CustomerDTO) session.getAttribute("customer1");
        if (OrderRequestDT == null) {
            return "redirect:/404";
        }
        if (customer.getEmail() != null) {
            int getOrderId = customerOrderService.getOrderId();
            System.out.println(getOrderId);
            model.addAttribute("order_code", getOrderId);
            int endDay = OrderRequestDT.calculateDurationInDays();
            String template = BillConfirmTemplate.getTemplate(customer, getDay(), getDayExp(), generateProductHtml(OrderRequestDT.getCartData(), endDay - 1), getOrderId);
            Thread emailThread = new Thread(() -> {
                try {
                    gmailSender.send(template, customer.getEmail(), getOrderId);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            emailThread.start();
            session.removeAttribute("customer1");
            session.removeAttribute("OrderRequestDT");
            return "user/order-success";
        }
        return "redirect:/404";
    }

    @RequestMapping(value = "/order-success-bank", method = RequestMethod.GET)
    public String orderSuccess(HttpSession session, Model model) {
        OrderRequestDTO OrderRequestDTO = (OrderRequestDTO) session.getAttribute("OrderRequestDTO");
        CustomerDTO customer = (CustomerDTO) session.getAttribute("customer");
        if (OrderRequestDTO == null) {
            return "redirect:/404";
        }
        if (customer.getEmail() != null) {
            int getOrderId = customerOrderService.getOrderId();
            System.out.println(getOrderId);
            model.addAttribute("order_code", getOrderId);
            int endDay = OrderRequestDTO.calculateDurationInDays();
            String template = BillConfirmTemplate.getTemplate(customer, getDay(), getDayExp(), generateProductHtml(OrderRequestDTO.getCartData(), endDay - 1), 1);
            Thread emailThread = new Thread(() -> {
                try {
                    gmailSender.send(template, customer.getEmail(), 1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            emailThread.start();
            session.removeAttribute("customer");
            session.removeAttribute("OrderRequestDTO");
            return "user/order-success";
        }
        return "redirect:/404";
    }

    @RequestMapping(value = "/order-fail", method = RequestMethod.GET)
    public String orderFailure(HttpSession session) {
        CustomerDTO customer = (CustomerDTO) session.getAttribute("customer");
        if (customer != null) {
            session.removeAttribute("customer");
            session.removeAttribute("OrderRequestDTO");
            return "user/order-failure";
        }
        return "redirect:/404";
    }

    //Right now
    public String getDay() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dayOfWeek = dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("vi", "VN"));
        dayOfWeek = dayOfWeek.substring(0, 1).toLowerCase() + dayOfWeek.substring(1);
        String formattedDateTime = String.format("%s %s, %s",
                dateTime.format(timeFormatter), dayOfWeek, dateTime.format(dateFormatter));
        System.out.println(formattedDateTime);
        return formattedDateTime;
    }

    //Expected
    public String getDayExp() {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime dateTimeExp = dateTime.plusDays(3);
        DateTimeFormatter dateFormatterExp = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dayOfWeekExp = dateTimeExp.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("vi", "VN"));
        dayOfWeekExp = dayOfWeekExp.substring(0, 1).toUpperCase() + dayOfWeekExp.substring(1);
        String formattedDateExp = String.format("%s, %s", dayOfWeekExp, dateTimeExp.format(dateFormatterExp));
        System.out.println(formattedDateExp);
        return formattedDateExp;
    }

    public String generateProductHtml(List<OrderDetailDTO> orderList, int endDay) {
        StringBuilder htmlBuilder = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("#,###");

        int index = 1;
        int totalAmount = 0;

        for (OrderDetailDTO o : orderList) {
            String productName = productsService.getProductById(o.getProductId()).get().getName();
            int totalPrice = (int) (o.getPrice() * o.getQuantity());
            totalAmount += totalPrice;

            String productHtml = String.format(
                    "<tr>\n" +
                            "    <td class=\"esdev-adapt-off es-m-p20r es-m-p20l\" align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:30px;padding-right:30px\">\n" +
                            "        <table cellpadding=\"0\" cellspacing=\"0\" class=\"esdev-mso-table\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:540px\">\n" +
                            "            <tr>\n" +
                            "                <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                            "                    <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                            "                        <tr>\n" +
                            "                            <td align=\"left\" style=\"padding:0;Margin:0;width:42px\">\n" +
                            "                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                            "                                    <tr>\n" +
                            "                                        <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:20px;color:#333333;font-size:13px\">%d.</p></td>\n" +
                            "                                    </tr>\n" +
                            "                                </table>\n" +
                            "                            </td>\n" +
                            "                        </tr>\n" +
                            "                    </table>\n" +
                            "                </td>\n" +
                            "                <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                            "                    <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                            "                        <tr>\n" +
                            "                            <td align=\"center\" style=\"padding:0;Margin:0;width:407px\">\n" +
                            "                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                            "                                    <tr>\n" +
                            "                                        <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:20px;color:#333333;font-size:13px\"><strong>%s</strong></p></td>\n" +
                            "                                    </tr>\n" +
                            "                                    <tr>\n" +
                            "                                        <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:20px;color:#333333;font-size:13px\">Số lượng: %d</p></td>\n" +
                            "                                    </tr>\n" +
                            "                                </table>\n" +
                            "                            </td>\n" +
                            "                        </tr>\n" +
                            "                    </table>\n" +
                            "                </td>\n" +
                            "                <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                            "                    <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                            "                        <tr>\n" +
                            "                            <td align=\"left\" style=\"padding:0;Margin:0;width:91px\">\n" +
                            "                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-bottom:1px solid #cccccc\" role=\"presentation\">\n" +
                            "                                    <tr>\n" +
                            "                                        <td align=\"right\" style=\"padding:0;Margin:0\"><p id=\"unit-price\" style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:20px;color:#333333;font-size:13px\"><strong>%s đ</strong></p></td>\n" +
                            "                                    </tr>\n" +
                            "                                    <tr>\n" +
                            "                                        <td align=\"right\" style=\"padding:0;Margin:0\"><p id=\"total-price\" style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:20px;color:#333333;font-size:13px\"><strong>x%d</strong></p></td>\n" +
                            "                                    </tr>\n" +
                            "                                    <tr>\n" +
                            "                                        <td align=\"center\" height=\"5\" style=\"padding:0;Margin:0\"></td>\n" +
                            "                                    </tr>\n" +
                            "                                </table>\n" +
                            "                            </td>\n" +
                            "                        </tr>\n" +
                            "                        <tr>\n" +
                            "                            <td align=\"left\" style=\"padding:0;Margin:0;width:91px\">\n" +
                            "                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                            "                                    <tr>\n" +
                            "                                        <td align=\"right\" style=\"padding:0;Margin:0;padding-top:5px\"><p id=\"total-amount\" style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:20px;color:#333333;font-size:13px\"><strong>%s đ</strong></p></td>\n" +
                            "                                    </tr>\n" +
                            "                                </table>\n" +
                            "                            </td>\n" +
                            "                        </tr>\n" +
                            "                    </table>\n" +
                            "                </td>\n" +
                            "            </tr>\n" +
                            "        </table>\n" +
                            "    </td>\n" +
                            "</tr>\n",
                    index, productName, o.getQuantity(),
                    formatter.format(o.getPrice()), o.getQuantity(),
                    formatter.format(totalPrice));

            htmlBuilder.append(productHtml);
            index++;
        }

        String next = String.format(
                "<tr>\n" +
                        "    <td class=\"esdev-adapt-off es-m-p20r es-m-p20l\" align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:30px;padding-right:30px\">\n" +
                        "        <table cellpadding=\"0\" cellspacing=\"0\" class=\"esdev-mso-table\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:540px\">\n" +
                        "            <tr>\n" +
                        "                <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                        "                    <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                        "                        <tr>\n" +
                        "                            <td align=\"left\" style=\"padding:0;Margin:0;width:418px\">\n" +
                        "                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-top:1px solid #cccccc;border-bottom:1px solid #cccccc\" role=\"presentation\">\n" +
                        "                                    <tr>\n" +
                        "                                        <td align=\"right\" style=\"padding:0;Margin:0;padding-top:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\">Tổng tiền:</p></td>\n" +
                        "                                    </tr>\n" +
                        "                                    <tr>\n" +
                        "                                        <td align=\"right\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\">Số ngày thuê:</p></td>\n" +
                        "                                    </tr>\n" +
                        "                                    <tr>\n" +
                        "                                        <td align=\"right\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\">Phí vận chuyển:</p></td>\n" +
                        "                                    </tr>\n" +
                        "                                    <tr>\n" +
                        "                                        <td align=\"right\" style=\"padding:0;Margin:0;padding-bottom:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\">Tổng thanh toán:</p></td>\n" +
                        "                                    </tr>\n" +
                        "                                </table>\n" +
                        "                            </td>\n" +
                        "                        </tr>\n" +
                        "                    </table>\n" +
                        "                </td>\n" +
                        "                <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                        "                    <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                        "                        <tr>\n" +
                        "                            <td align=\"left\" style=\"padding:0;Margin:0;width:122px\">\n" +
                        "                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-top:1px solid #cccccc;border-bottom:1px solid #cccccc\" role=\"presentation\">\n" +
                        "                                    <tr>\n" +
                        "                                        <td align=\"right\" style=\"padding:0;Margin:0;padding-top:10px\"><p id=\"total-amount\" style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\"><strong>%s đ</strong></p></td>\n" +
                        "                                    </tr>\n" +
                        "                                    <tr>\n" +
                        "                                        <td align=\"right\" style=\"padding:0;Margin:0\"><p id=\"total-days\" style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\"><strong>x%d ngày</strong></p></td>\n" +
                        "                                    </tr>\n" +
                        "                                    <tr>\n" +
                        "                                        <td align=\"right\" style=\"padding:0;Margin:0\"><p id=\"shipping-fee\" style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\"><strong>50.000 đ</strong></p></td>\n" +
                        "                                    </tr>\n" +
                        "                                    <tr>\n" +
                        "                                        <td align=\"right\" style=\"padding:0;Margin:0;padding-bottom:10px\"><p id=\"total-payment\" style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\"><strong>%s đ</strong></p></td>\n" +
                        "                                    </tr>\n" +
                        "                                </table>\n" +
                        "                            </td>\n" +
                        "                        </tr>\n" +
                        "                    </table>\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "        </table>\n" +
                        "    </td>\n" +
                        "</tr>\n",
                formatter.format(totalAmount),
                endDay,
                formatter.format(totalAmount * endDay + 50000)
        );
        htmlBuilder.append(next);
        return htmlBuilder.toString();
    }
}