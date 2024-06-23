package com.example.depropdemo.mail;

public class BillConfirm {

    public static String getTemplate(String firstname) {
        String template =
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
                "      href=\"https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap\"\n" +
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
                "      .logo {\n" +
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
                "\n" +
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
                "      <div class=\"d-flex justify-content-between align-items-center mb-5\">\n" +
                "        <div class=\"logo\">\n" +
                "          <a href=\"/user/index.html\" target=\"_blank\">\n" +
                "            <svg id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 1920 761.5\"><defs><style>.cls-1{stroke-width:0px;}</style></defs><path class=\"cls-1\" d=\"m192.3,112.88c34.66-.53,78.25,16.28,102.41,41.49,8.4,8.4,14.18,23.63,17.86,34.66h1.05c-3.68-11.55-6.83-26.78-6.83-38.86V11h51.47v367.63h-51.47v-32.04c0-12.08,3.15-27.31,6.83-38.34l-1.05-.53c-3.68,11.03-9.45,26.26-17.86,34.66-24.68,24.68-67.75,39.39-102.41,39.39-78.25,0-125-43.59-125-134.45s46.74-133.92,125-134.45Zm-73.53,134.45c0,61.97,26.79,90.34,90.34,90.34,46.74,0,97.69-33.61,97.69-90.34s-50.95-92.43-97.69-91.91c-64.07.53-90.34,29.94-90.34,91.91Z\"/><path class=\"cls-1\" d=\"m385.04,247.33c0-90.86,66.18-134.97,143.9-134.45,77.2.53,139.7,43.59,139.7,134.45,0,7.35,0,7.88-1.05,14.71h-228.98c7.88,51.99,43.06,78.25,91.38,77.73,40.44-.53,72.48-13.13,87.18-51.99l47.27,6.3c-19.96,63.55-73.52,87.18-135.5,87.7-77.73.53-143.9-43.59-143.9-134.45Zm53.57,14.71c7.88-28.36,20.48-31.51,45.69-31.51h135.5c-7.35-53.57-42.02-76.68-89.81-77.2-46.74-.53-96.64,35.19-91.38,108.71Z\"/><path class=\"cls-1\" d=\"m699.62,116.04h51.99v33.61c0,12.08-3.15,27.31-6.83,38.86h1.05c3.68-11.03,9.45-26.26,17.86-34.66,24.16-25.21,67.22-41.49,101.36-40.97,78.25.53,124.99,43.59,124.99,134.45s-46.74,134.45-124.99,134.45c-34.14,0-77.2-15.23-101.36-39.91-8.4-8.41-14.18-23.63-17.86-34.66h-1.05c3.68,11.55,6.83,26.78,6.83,38.86v79.39h-51.47l-.53-309.42Zm148.63,223.21c64.07,0,90.34-29.94,90.34-91.91s-25.74-89.81-90.34-90.33c-46.22-.53-96.64,33.61-96.64,90.33s50.42,91.91,96.64,91.91Z\"/><path class=\"cls-1\" d=\"m1088.25,116.04h105.56v48.32l-88.76.53c-29.41,0-35.19,3.15-35.19,39.39v174.36h-51.47v-192.22c0-47.27,22.06-70.37,69.85-70.37Z\"/><path class=\"cls-1\" d=\"m1193.81,247.33c0-90.86,67.22-134.97,144.95-134.45,78.25.53,145.48,43.59,145.48,134.45s-67.22,134.45-145.48,134.45-144.95-43.59-144.95-134.45Zm51.47,0c0,61.45,41.49,90.34,93.48,90.34s94.01-29.94,94.01-90.34-44.12-90.33-94.01-90.86c-48.32-.53-93.48,31.51-93.48,90.86Z\"/><path class=\"cls-1\" d=\"m1511.53,116.04h51.99v33.61c0,12.08-3.15,27.31-6.83,38.86h1.05c3.68-11.03,9.45-26.26,17.86-34.66,24.16-25.21,67.22-41.49,101.36-40.97,78.25.53,125,43.59,125,134.45s-46.74,134.45-125,134.45c-34.14,0-77.2-15.23-101.36-39.91-8.4-8.41-14.18-23.63-17.86-34.66h-1.05c3.68,11.55,6.83,26.78,6.83,38.86v79.39h-51.47l-.53-309.42Zm148.63,223.21c64.07,0,90.33-29.94,90.33-91.91s-25.74-89.81-90.33-90.33c-46.22-.53-96.64,33.61-96.64,90.33s50.42,91.91,96.64,91.91Z\"/><path class=\"cls-1\" d=\"m126.24,643.89c4.73,35.19,32.04,47.27,78.78,47.27,49.89,0,76.68-13.65,76.68-47.79,0-49.37-200.63-2.1-200.63-99.79,0-75.63,91.91-81.4,124.47-81.4,40.97,0,112.92,12.61,120.8,70.9l-46.74,6.83c-5.26-28.89-29.41-37.29-75.1-37.29s-71.95,9.45-71.95,42.54c0,50.42,200.62,3.15,200.62,99.26,0,80.35-96.11,87.18-129.2,87.18-30.46,0-121.32-8.93-127.62-78.78l49.89-8.93Z\"/><path class=\"cls-1\" d=\"m344.19,512.06v-48.32h9.98c24.16,0,54.62-43.59,54.62-79.83l51.99-.53c-1.05,28.89-14.18,57.25-38.34,73.53-8.93,5.77-23.63,7.35-34.14,9.45v1.05c10.5-2.1,24.68-3.68,35.19-3.68h92.96v48.32h-66.7v139.7c0,23.11,12.6,28.36,28.89,28.36h50.42v48.32h-47.79c-68.8,0-82.98-25.74-82.98-86.66v-129.72h-54.09Z\"/><path class=\"cls-1\" d=\"m544.8,598.72v-133.92h51.47v133.92c0,55.67,21.53,80.88,64.07,80.88,22.58,0,73-18.38,73-116.59v-98.21h51.47v262.6h-51.47v-50.42c0-11.03,2.1-24.68,4.2-35.19l-1.05-.53c-9.98,49.37-38.86,90.33-94.54,90.33-76.15,0-97.16-63.55-97.16-132.87Z\"/><path class=\"cls-1\" d=\"m956.02,462.69c34.66-.53,78.25,16.28,102.41,41.49,8.4,8.4,14.18,23.63,17.86,34.66h1.05c-3.68-11.55-6.83-26.78-6.83-38.86v-118.25h51.47v346.71h-51.47v-32.04c0-12.08,3.15-27.31,6.83-38.34l-1.05-.53c-3.68,11.03-9.45,26.26-17.86,34.66-24.68,24.68-67.75,39.39-102.41,39.39-78.25,0-125-43.59-125-134.45s46.74-133.92,125-134.45Zm-73.53,134.45c0,61.97,26.79,90.34,90.34,90.34,46.74,0,97.69-33.61,97.69-90.34s-50.95-92.43-97.69-91.91c-64.07.53-90.34,29.94-90.34,91.91Z\"/><path class=\"cls-1\" d=\"m1152.43,425.63v-44.64h53.04v44.64h-53.04Zm1.05,302.81h50.94v-262.6h-50.94v262.6Z\"/><path class=\"cls-1\" d=\"m1377.2,462.69c-77.68-.52-144.87,43.55-144.94,134.31,0,.05,0,.09,0,.14,0,90.86,67.23,134.45,144.95,134.45s145.48-43.59,145.48-134.45v-.14c-.07-90.76-67.26-133.78-145.48-134.31Zm94.01,134.45c0,60.4-43.06,90.34-94.01,90.34s-93.48-28.89-93.48-90.34v-.14c.08-59.25,45.2-91.24,93.48-90.72,49.86.53,93.94,31.47,94.01,90.72v.14Z\"/><polygon class=\"cls-1\" points=\"1838.8 484.21 1725.83 514.64 1709.31 573.46 1852.25 534.95 1838.8 484.21\"/><polygon class=\"cls-1\" points=\"1691.69 415.32 1661.57 528.37 1704.24 572.09 1742.36 429.04 1691.69 415.32\"/><polygon class=\"cls-1\" points=\"1558.48 508.27 1641.32 590.88 1700.52 575.79 1595.7 471.25 1558.48 508.27\"/><polygon class=\"cls-1\" points=\"1572.37 670.11 1685.34 639.67 1701.87 580.86 1558.93 619.37 1572.37 670.11\"/><polygon class=\"cls-1\" points=\"1719.48 739 1749.6 625.95 1706.93 582.23 1668.81 725.28 1719.48 739\"/><polygon class=\"cls-1\" points=\"1852.69 646.05 1769.85 563.44 1710.65 578.53 1815.47 683.06 1852.69 646.05\"/></svg>\n" +
                "          </a>\n" +
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
                "      <div class=\"order_info d-flex align-items-start\">\n" +
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
                "    <script>\n" +
                "        document.addEventListener(\"DOMContentLoaded\", function () {\n" +
                "        function formatPrice(price) {\n" +
                "            const formattedPrice = price.toFixed(3).replace(/\\d(?=(\\d{3})+\\.)/g, '$&.');\n" +
                "            return formattedPrice.substring(0, formattedPrice.length - 4) + \".000 đ\";\n" +
                "        }\n" +
                "\n" +
                "        let prices = document.querySelectorAll(\".current_prefix\");\n" +
                "        prices.forEach((priceElement) => {\n" +
                "            let price = parseFloat(priceElement.textContent.trim());\n" +
                "            let formattedPrice = formatPrice(price);\n" +
                "            priceElement.textContent = formattedPrice;\n" +
                "        });\n" +
                "        });\n" +
                "    </script>\n" +
                "  </body>\n" +
                "</html>\n";
        return template;
    }
}
