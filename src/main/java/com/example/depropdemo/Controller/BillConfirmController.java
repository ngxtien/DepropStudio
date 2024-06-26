package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.Customer;
import com.example.depropdemo.Model.Products;
import com.example.depropdemo.Service.ProductsService;
import com.example.depropdemo.mail.EmailSender;
import com.example.depropdemo.mail.BillConfirmTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller
public class BillConfirmController {

    @Autowired
    private EmailSender gmailSender;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/mailSender")
    public String formBill(Model model) {
        model.addAttribute("customer", new Customer());
        return "Test/mailSender";
    }

    @PostMapping("/sendBill")
    public String proccesingBill(Customer customer) {
        List<Products> products = productsService.getAllProducts();
        String template = BillConfirmTemplate.getTemplate(customer, getDay(), getDayExp(), generateProductHtml(products));
//        String template = BillConfirmTemplate.getTemplate(customer, getDay(), getDayExp());
        Thread emailThread = new Thread(() -> {
            try {
                gmailSender.send(template, customer.getEmail());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        emailThread.start();
        return "redirect:/mailSender";
    }

    public String getDay() {
        //Right now
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

    public String generateProductHtml(List<Products> products) {
        StringBuilder htmlBuilder = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("#,###");

        int index = 1;
        int totalAmount = 0; // Tổng tiền

        // Tạo mã HTML cho từng sản phẩm
        for (Products product : products) {
            int totalPrice = (int) (product.getPrice() * product.getQuantity());
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
                    index, product.getName(), product.getQuantity(),
                    formatter.format(product.getPrice()), product.getQuantity(),
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
                7,
                formatter.format(totalAmount + 50000)
                );
        htmlBuilder.append(next);
        return htmlBuilder.toString();
    }
}