package com.example.depropdemo.mail;

public class BillConfirmTemplate {

    public static String getTemplate(String firstname) {
        String template =
                "<!DOCTYPE html>\n" +
                        "<html lang=\"zxx\">\n" +
                        "  <head>\n" +
                        "    <!-- Required meta tags -->\n" +
                        "    <meta charset=\"utf-8\" />\n" +
                        "    <meta\n" +
                        "      name=\"viewport\"\n" +
                        "      content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"\n" +
                        "    />\n" +
                        "    <title></title>\n" +
                        "    <!-- fonts -->\n" +
                        "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\" />\n" +
                        "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin />\n" +
                        "    <link\n" +
                        "      href=\"https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,600;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,600&display=swap\"\n" +
                        "      rel=\"stylesheet\"\n" +
                        "    />\n" +
                        "    <!-- Bootstrap CSS -->\n" +
                        "    <link\n" +
                        "      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n" +
                        "      rel=\"stylesheet\"\n" +
                        "      integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n" +
                        "      crossorigin=\"anonymous\"\n" +
                        "    />\n" +
                        "    <!-- style CSS -->\n" +
                        "    <style>\n" +
                        "      body {\n" +
                        "        display: flex;\n" +
                        "        flex-direction: column;\n" +
                        "        font-family: \"Be Vietnam Pro\", sans-serif;\n" +
                        "      }\n" +
                        "\n" +
                        "      html,\n" +
                        "      body {\n" +
                        "        height: 100%;\n" +
                        "        margin: 0;\n" +
                        "      }\n" +
                        "      ::-webkit-scrollbar {\n" +
                        "        width: 0;\n" +
                        "      }\n" +
                        "\n" +
                        "      .logo img {\n" +
                        "        width: 100px;\n" +
                        "      }\n" +
                        "\n" +
                        "      .order_confirmation {\n" +
                        "        max-width: 600px;\n" +
                        "        margin: auto;\n" +
                        "        padding: 30px 25px;\n" +
                        "        font-size: 13px;\n" +
                        "        line-height: 24px;\n" +
                        "        border: 1px solid #ddd;\n" +
                        "        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                        "        background-color: #ffffff;\n" +
                        "      }\n" +
                        "\n" +
                        "      .order_code_text {\n" +
                        "        font-size: 16px;\n" +
                        "        color: #9c9c9c;\n" +
                        "      }\n" +
                        "\n" +
                        "      .order_title {\n" +
                        "        margin-bottom: 10px;\n" +
                        "      }\n" +
                        "      .order_title h1 {\n" +
                        "        font-size: 20px;\n" +
                        "        font-weight: 600;\n" +
                        "        color: #333;\n" +
                        "        margin-bottom: 20px;\n" +
                        "      }\n" +
                        "      .order_title .customer_name {\n" +
                        "        font-weight: 700;\n" +
                        "      }\n" +
                        "\n" +
                        "      .info_title {\n" +
                        "        font-weight: 700;\n" +
                        "        font-size: 15px;\n" +
                        "        margin-bottom: 10px;\n" +
                        "      }\n" +
                        "\n" +
                        "      .order_info {\n" +
                        "        background-color: rgba(129, 129, 139, 0.2);\n" +
                        "        padding: 10px 10px;\n" +
                        "        margin-bottom: 10px;\n" +
                        "        gap: 0;\n" +
                        "      }\n" +
                        "      .order_info .customer_name,\n" +
                        "      .order_info .customer_phone,\n" +
                        "      .order_info .customer_address {\n" +
                        "        font-weight: 700;\n" +
                        "      }\n" +
                        "\n" +
                        "      .order_summary {\n" +
                        "        width: 50%;\n" +
                        "        padding-left: 10px;\n" +
                        "        border-left: 1px solid rgba(74, 74, 80, 0.2);\n" +
                        "      }\n" +
                        "      .order_summary .deliver_time,\n" +
                        "      .order_summary .payment_status {\n" +
                        "        font-weight: 700;\n" +
                        "      }\n" +
                        "\n" +
                        "      .order_customer {\n" +
                        "        width: 50%;\n" +
                        "        padding-right: 10px;\n" +
                        "      }\n" +
                        "\n" +
                        "      .order_details {\n" +
                        "        padding: 10px 0;\n" +
                        "      }\n" +
                        "      .order_details .details_title {\n" +
                        "        font-weight: 700;\n" +
                        "        font-size: 15px;\n" +
                        "      }\n" +
                        "      .order_details .order_time,\n" +
                        "      .order_details .product_name,\n" +
                        "      .order_details .subtotal_price {\n" +
                        "        font-weight: 700;\n" +
                        "      }\n" +
                        "      .order_details .order_item {\n" +
                        "        display: flex;\n" +
                        "        flex-direction: row;\n" +
                        "        justify-content: space-between;\n" +
                        "        align-items: start;\n" +
                        "        padding: 10px 0;\n" +
                        "        border-bottom: 1px solid #ddd;\n" +
                        "      }\n" +
                        "      .order_details .order_item .item_details {\n" +
                        "        display: flex;\n" +
                        "        gap: 10px;\n" +
                        "      }\n" +
                        "      .order_details .order_item img {\n" +
                        "        height: 80px;\n" +
                        "        width: 80px;\n" +
                        "      }\n" +
                        "      .order_details .order_item .item_quantity {\n" +
                        "        border-bottom: 1px solid #ddd;\n" +
                        "      }\n" +
                        "      .order_details .order_item:last-child {\n" +
                        "        border-bottom: none;\n" +
                        "      }\n" +
                        "      .order_total {\n" +
                        "        display: flex;\n" +
                        "        gap: 20px;\n" +
                        "        justify-content: right;\n" +
                        "      }\n" +
                        "      .order_total .order_total_text {\n" +
                        "        text-align: right;\n" +
                        "      }\n" +
                        "      .order_total .order_total_price {\n" +
                        "        text-align: right;\n" +
                        "      }\n" +
                        "      .order_total .total_payment {\n" +
                        "        font-weight: 700;\n" +
                        "      }\n" +
                        "\n" +
                        "      .thank_you {\n" +
                        "        text-align: center;\n" +
                        "        margin-top: 40px;\n" +
                        "      }\n" +
                        "      .thank_you a {\n" +
                        "        color: #000;\n" +
                        "        font-weight: 700;\n" +
                        "        text-decoration: none;\n" +
                        "      }\n" +
                        "      .thank_you a:hover {\n" +
                        "        text-decoration: underline;\n" +
                        "      }\n" +
                        "    </style>\n" +
                        "  </head>\n" +
                        "\n" +
                        "  <body>\n" +
                        "    <div class=\"order_confirmation\">\n" +
                        "      <div style=\"display: flex; justify-content: space-between; align-content: center; margin-bottom: 40px;\">\n" +
                        "        <div class=\"logo\">\n" +
                        "          <a href=\"/user/index\" target=\"_blank\">\n" +
                        "            <img src=https://i.ibb.co/ZBbBrGP/black-logo.png\">\n" +
                        "          </a>\n" +
                        "\n" +
                        "        </div>\n" +
                        "        <div class=\"order_code_text\">\n" +
                        "          Đơn hàng #<span class=\"order_code\">1234</span>\n" +
                        "        </div>\n" +
                        "      </div>\n" +
                        "\n" +
                        "      <div class=\"order_title\">\n" +
                        "        <h1>Đơn hàng của bạn đã được xác nhận!!!</h1>\n" +
                        "        <div>Hello <span class=\"customer_name\">"+ firstname +"</span>,</div>\n" +
                        "        <div>\n" +
                        "          Đơn hàng của bạn đã được xác nhận và đang trong quá trình vận chuyển.\n" +
                        "        </div>\n" +
                        "      </div>\n" +
                        "\n" +
                        "      <div class=\"info_title\">Thông tin khách hàng:</div>\n" +
                        "      <div class=\"order_info\" style=\"display: flex; align-items: start;\">\n" +
                        "        <div class=\"order_customer\">\n" +
                        "          <div class=\"info_name\">\n" +
                        "            Họ và tên: <span class=\"customer_name\">Diệp Tuấn Ngọc</span>\n" +
                        "          </div>\n" +
                        "          <div class=\"info_phone\">\n" +
                        "            Số điện thoại: <span class=\"customer_phone\">0901131465</span>\n" +
                        "          </div>\n" +
                        "          <div class=\"info_address\">\n" +
                        "            Địa chỉ: <span class=\"customer_address\">Quận 9, TPHCM</span>\n" +
                        "          </div>\n" +
                        "        </div>\n" +
                        "        <div class=\"order_summary\">\n" +
                        "          <div>\n" +
                        "            Thời gian nhận hàng dự kiến:<br />\n" +
                        "            <span class=\"deliver_time\">Thứ 7, 22/06/2024</span>\n" +
                        "          </div>\n" +
                        "          <div>\n" +
                        "            Phương thức thanh toán:<br />\n" +
                        "            <span class=\"payment_status\">Chuyển khoản ngân hàng</span>\n" +
                        "          </div>\n" +
                        "        </div>\n" +
                        "      </div>\n" +
                        "\n" +
                        "      <div class=\"order_details\">\n" +
                        "        <div class=\"details_title\">Chi tiết đơn hàng:</div>\n" +
                        "        <div>\n" +
                        "          Đơn hàng của bạn đặt vào\n" +
                        "          <span class=\"order_time\">23:23 thứ 6, 21/06/2024</span>.\n" +
                        "        </div>\n" +
                        "        <div class=\"order_product\">\n" +
                        "          <div class=\"order_item\">\n" +
                        "            <div class=\"item_details\">\n" +
                        "              <img class=\"product_img\" src=\"/images/product/item.jpg\" />\n" +
                        "              <div class=\"item_detail\">\n" +
                        "                <div class=\"product_name\">Product Name</div>\n" +
                        "                <div>Số lượng: <span class=\"product_quantity\">02</span></div>\n" +
                        "              </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"item_price\">\n" +
                        "              <div class=\"product_price current_prefix\">170</div>\n" +
                        "              <div class=\"item_quantity\">\n" +
                        "                x<span class=\"product_quantity\">2</span>\n" +
                        "              </div>\n" +
                        "              <div class=\"subtotal_price current_prefix\">340</div>\n" +
                        "            </div>\n" +
                        "          </div>\n" +
                        "          <div class=\"order_item\">\n" +
                        "            <div class=\"item_details\">\n" +
                        "              <img class=\"product_img\" src=\"/images/product/item.jpg\" />\n" +
                        "              <div class=\"item_detail\">\n" +
                        "                <div class=\"product_name\">Product Name</div>\n" +
                        "                <div>Số lượng: <span class=\"product_quantity\">01</span></div>\n" +
                        "              </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"item_price\">\n" +
                        "              <div class=\"product_price current_prefix\">50</div>\n" +
                        "              <div class=\"item_quantity\">\n" +
                        "                x<span class=\"product_quantity\">1</span>\n" +
                        "              </div>\n" +
                        "              <div class=\"subtotal_price current_prefix\">50</div>\n" +
                        "            </div>\n" +
                        "          </div>\n" +
                        "        </div>\n" +
                        "      </div>\n" +
                        "      <div class=\"order_total\">\n" +
                        "        <div class=\"order_total_text\">\n" +
                        "          <div>Tổng tiền:</div>\n" +
                        "          <div>Số ngày thuê:</div>\n" +
                        "          <div>Phí vận chuyển:</div>\n" +
                        "          <div>Tổng thanh toán:</div>\n" +
                        "        </div>\n" +
                        "        <div class=\"order_total_price\">\n" +
                        "          <div class=\"totalprice current_prefix\">390</div>\n" +
                        "          <div>x<span class=\"rent_day\">2</span> ngày</div>\n" +
                        "          <div class=\"deliver_fee current_prefix\">50</div>\n" +
                        "          <div class=\"total_payment current_prefix\">830</div>\n" +
                        "        </div>\n" +
                        "      </div>\n" +
                        "      <div class=\"thank_you\">\n" +
                        "        <div>Deprop Studio xin cảm ơn bạn !</div>\n" +
                        "        <a href=\"https://depropstudio.com\" target=\"_blank\">depropstudio.com</a>\n" +
                        "      </div>\n" +
                        "    </div>\n" +
                        "\n" +
                        "  </body>\n" +
                        "</html>\n";
        return template;
    }
}
