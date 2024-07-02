package com.example.depropdemo.mail;

import com.example.depropdemo.Model.DTO.CustomerDTO;

public class BillConfirmTemplate {

    public static String getTemplate(CustomerDTO customer, String getDay, String getDayExp, String text) {
        String template ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html dir=\"ltr\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"vi\">\n" +
                " <head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "  <meta content=\"telephone=no\" name=\"format-detection\">\n" +
                "  <title></title><!--[if (mso 16)]>\n" +
                "    <style type=\"text/css\">\n" +
                "    a {text-decoration: none;}\n" +
                "    </style>\n" +
                "    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n" +
                "<xml>\n" +
                "    <o:OfficeDocumentSettings>\n" +
                "    <o:AllowPNG></o:AllowPNG>\n" +
                "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "    </o:OfficeDocumentSettings>\n" +
                "</xml>\n" +
                "<![endif]-->\n" +
                "  <style type=\"text/css\">\n" +
                "#mttContainer {\n" +
                "      left: 0 !important;\n" +
                "      top: 0 !important;\n" +
                "      width: 1000px !important;\n" +
                "      margin: 0px !important;\n" +
                "      margin-left: -500px !important;\n" +
                "      position: fixed !important;\n" +
                "      z-index: 100000200 !important;\n" +
                "      background: none !important;\n" +
                "      pointer-events: none !important;\n" +
                "      display: inline-block !important;\n" +
                "      visibility: visible  !important;\n" +
                "      white-space: pre-line;\n" +
                "    }\n" +
                "    .tippy-box[data-theme~=\"custom\"], .tippy-content *{\n" +
                "      font-size: 14px  !important;\n" +
                "      text-align: center !important;\n" +
                "      overflow-wrap: break-word !important;\n" +
                "      color: #ffffffff !important;\n" +
                "      font-family: \n" +
                "        -apple-system, BlinkMacSystemFont,\n" +
                "        \"Segoe UI\", \"Roboto\", \"Oxygen\",\n" +
                "        \"Ubuntu\", \"Cantarell\", \"Fira Sans\",\n" +
                "        \"Droid Sans\", \"Helvetica Neue\", sans-serif  !important;\n" +
                "      white-space: pre-line;\n" +
                "    }\n" +
                "    .tippy-box[data-theme~=\"custom\"]{\n" +
                "      max-width: 200px  !important;\n" +
                "      backdrop-filter: blur(2px) !important;\n" +
                "      background-color: #000000b8 !important;\n" +
                "      border: 1px solid #ffffff00; \n" +
                "    }\n" +
                "    [data-tippy-root] {\n" +
                "      display: inline-block !important;\n" +
                "      visibility: visible  !important;\n" +
                "      position: absolute !important;\n" +
                "    }\n" +
                "    .tippy-box[data-theme~='custom'][data-placement^='top'] > .tippy-arrow::before { \n" +
                "      border-top-color: #000000b8 !important;\n" +
                "    }\n" +
                "    .tippy-box[data-theme~='custom'][data-placement^='bottom'] > .tippy-arrow::before {\n" +
                "      border-bottom-color: #000000b8 !important;\n" +
                "    }\n" +
                "    .tippy-box[data-theme~='custom'][data-placement^='left'] > .tippy-arrow::before {\n" +
                "      border-left-color: #000000b8 !important;\n" +
                "    }\n" +
                "    .tippy-box[data-theme~='custom'][data-placement^='right'] > .tippy-arrow::before {\n" +
                "      border-right-color: #000000b8 !important;\n" +
                "    }\n" +
                "    .mtt-highlight{\n" +
                "      background-color: #21dc6d40  !important;\n" +
                "      position: absolute !important;   \n" +
                "      z-index: 100000100 !important;\n" +
                "      pointer-events: none !important;\n" +
                "      display: inline !important;\n" +
                "      border-radius: 3px !important;\n" +
                "    }\n" +
                "    .mtt-image{\n" +
                "      width: 180px  !important;\n" +
                "      border-radius: 3px !important;\n" +
                "    }\n" +
                "    .ocr_text_div{\n" +
                "      position: absolute;\n" +
                "      opacity: 0.5;\n" +
                "      color: transparent !important;\n" +
                "      border: 2px solid CornflowerBlue;\n" +
                "      background: none !important;\n" +
                "      border-radius: 3px !important;\n" +
                "    }\n" +
                "#outlook a {\n" +
                "\tpadding:0;\n" +
                "}\n" +
                ".es-button {\n" +
                "\tmso-style-priority:100!important;\n" +
                "\ttext-decoration:none!important;\n" +
                "}\n" +
                "a[x-apple-data-detectors] {\n" +
                "\tcolor:inherit!important;\n" +
                "\ttext-decoration:none!important;\n" +
                "\tfont-size:inherit!important;\n" +
                "\tfont-family:inherit!important;\n" +
                "\tfont-weight:inherit!important;\n" +
                "\tline-height:inherit!important;\n" +
                "}\n" +
                ".es-desk-hidden {\n" +
                "\tdisplay:none;\n" +
                "\tfloat:left;\n" +
                "\toverflow:hidden;\n" +
                "\twidth:0;\n" +
                "\tmax-height:0;\n" +
                "\tline-height:0;\n" +
                "\tmso-hide:all;\n" +
                "}\n" +
                "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120%!important } h1 { font-size:36px!important; text-align:left } h2 { font-size:26px!important; text-align:left } h3 { font-size:20px!important; text-align:left } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:36px!important; text-align:left } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:26px!important; text-align:left } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important; text-align:left } .es-menu td a { font-size:12px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:14px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:20px!important; display:inline-block!important } .es-adaptive table, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0!important } .es-m-p0r { padding-right:0!important } .es-m-p0l { padding-left:0!important } .es-m-p0t { padding-top:0!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-m-p5 { padding:5px!important } .es-m-p5t { padding-top:5px!important } .es-m-p5b { padding-bottom:5px!important } .es-m-p5r { padding-right:5px!important } .es-m-p5l { padding-left:5px!important } .es-m-p10 { padding:10px!important } .es-m-p10t { padding-top:10px!important } .es-m-p10b { padding-bottom:10px!important } .es-m-p10r { padding-right:10px!important } .es-m-p10l { padding-left:10px!important } .es-m-p15 { padding:15px!important } .es-m-p15t { padding-top:15px!important } .es-m-p15b { padding-bottom:15px!important } .es-m-p15r { padding-right:15px!important } .es-m-p15l { padding-left:15px!important } .es-m-p20 { padding:20px!important } .es-m-p20t { padding-top:20px!important } .es-m-p20r { padding-right:20px!important } .es-m-p20l { padding-left:20px!important } .es-m-p25 { padding:25px!important } .es-m-p25t { padding-top:25px!important } .es-m-p25b { padding-bottom:25px!important } .es-m-p25r { padding-right:25px!important } .es-m-p25l { padding-left:25px!important } .es-m-p30 { padding:30px!important } .es-m-p30t { padding-top:30px!important } .es-m-p30b { padding-bottom:30px!important } .es-m-p30r { padding-right:30px!important } .es-m-p30l { padding-left:30px!important } .es-m-p35 { padding:35px!important } .es-m-p35t { padding-top:35px!important } .es-m-p35b { padding-bottom:35px!important } .es-m-p35r { padding-right:35px!important } .es-m-p35l { padding-left:35px!important } .es-m-p40 { padding:40px!important } .es-m-p40t { padding-top:40px!important } .es-m-p40b { padding-bottom:40px!important } .es-m-p40r { padding-right:40px!important } .es-m-p40l { padding-left:40px!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } .h-auto { height:auto!important } }\n" +
                "@media screen and (max-width:384px) {.mail-message-content { width:414px!important } }\n" +
                "</style>\n" +
                " </head>\n" +
                " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
                "  <div dir=\"ltr\" class=\"es-wrapper-color\" lang=\"vi\" style=\"background-color:#FAFAFA\"><!--[if gte mso 9]>\n" +
                "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "\t\t\t\t<v:fill type=\"tile\" color=\"#fafafa\"></v:fill>\n" +
                "\t\t\t</v:background>\n" +
                "\t\t<![endif]-->\n" +
                "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#FAFAFA\">\n" +
                "     <tr>\n" +
                "      <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "         <tr>\n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                "             <tr>\n" +
                "              <td class=\"es-m-p0r es-m-p0l esdev-adapt-off\" align=\"left\" style=\"padding:0;Margin:0;padding-top:30px;padding-left:30px;padding-right:30px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"esdev-mso-table\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:540px\">\n" +
                "                 <tr>\n" +
                "                  <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;width:285px\">\n" +
                "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                         <tr>\n" +
                "                          <td align=\"left\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px;font-size:0px\"><a target=\"_blank\" href=\"https://depropstudio.com\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#5C68E2;font-size:14px\"><img src=\"https://i.ibb.co/ZBbBrGP/black-logo.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"100\"></a></td>\n" +
                "                         </tr>\n" +
                "                       </table></td>\n" +
                "                     </tr>\n" +
                "                   </table></td>\n" +
                "                  <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;width:255px\">\n" +
                "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                         <tr>\n" +
                "                          <td align=\"right\" class=\"es-m-txt-c es-m-p10t es-m-p10b\" style=\"padding:0;Margin:0;padding-bottom:15px;padding-top:20px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#333333;font-size:16px;margin-left:40px;vertical-align:middle\"><strong>Đơn hàng <a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#929292;font-size:16px;vertical-align:middle\" href=\"\">#65000500</a></strong></p></td>\n" +
                "                         </tr>\n" +
                "                       </table></td>\n" +
                "                     </tr>\n" +
                "                   </table></td>\n" +
                "                 </tr>\n" +
                "               </table></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td class=\"es-m-p20r es-m-p20l\" align=\"left\" style=\"padding:0;Margin:0;padding-top:30px;padding-left:30px;padding-right:30px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:540px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0;padding-bottom:10px\"><h1 style=\"Margin:0;line-height:25px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:25px;font-style:normal;font-weight:bold;color:#333333\">Đơn hàng của bạn đã được xác nhận!!!</h1></td>\n" +
                "                     </tr>\n" +
                "                   </table></td>\n" +
                "                 </tr>\n" +
                "               </table></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td class=\"es-m-p20r es-m-p20l\" align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:30px;padding-right:30px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:540px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:20px;color:#333333;font-size:13px\">Chào <strong>"+ customer.getLastname() +",</strong></p></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:20px;color:#333333;font-size:13px\">Đơn hàng của bạn đã được xác nhận và đang trong quá trình vận chuyển.</p></td>\n" +
                "                     </tr>\n" +
                "                   </table></td>\n" +
                "                 </tr>\n" +
                "               </table></td>\n" +
                "             </tr>\n" +
                "           </table></td>\n" +
                "         </tr>\n" +
                "       </table>\n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "         <tr>\n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                "             <tr>\n" +
                "              <td class=\"es-m-p20r es-m-p20l\" align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-top:20px;padding-left:30px;padding-right:30px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:540px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:23px;color:#333333;font-size:15px\"><strong>Chi tiết đơn hàng:</strong></p></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:20px;color:#333333;font-size:13px\">Đơn hàng của bạn đặt vào <b>"+ getDay +"</b></p></td>\n" +
                "                     </tr>\n" +
                "                   </table></td>\n" +
                "                 </tr>\n" +
                "               </table></td>\n" +
                "             </tr>\n" +
                                text +
                "              <td class=\"es-m-p20r es-m-p20l\" align=\"left\" style=\"padding:0;Margin:0;padding-top:10px;padding-left:30px;padding-right:30px\"><!--[if mso]><table style=\"width:540px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:260px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:260px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\">Họ và tên: <strong>"+ customer.getLastname() +" "+customer.getFirstname()+"</strong></p></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\">Số điện thoại: <strong>"+ customer.getPhonenumber()+"</strong></p></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:26px;color:#333333;font-size:13px\">Địa chỉ: <strong>"+ customer.getAddress()+"</strong></p></td>\n" +
                "                     </tr>\n" +
                "                   </table></td>\n" +
                "                 </tr>\n" +
                "               </table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:260px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:260px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tr>\n" +
                "                      <td align=\"right\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">Thời gian nhận hàng dự kiến:</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>"+ getDayExp +"</strong></p></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"right\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">Phương thức thanh toán:</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Chuyển khoản ngân hàng</strong></p></td>\n" +
                "                     </tr>\n" +
                "                   </table></td>\n" +
                "                 </tr>\n" +
                "               </table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "           </table></td>\n" +
                "         </tr>\n" +
                "       </table>\n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "         <tr>\n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"Margin:0;padding-bottom:20px;padding-top:30px;padding-left:30px;padding-right:30px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"none\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:540px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:28px;color:#333333;font-size:14px\">Deprop Studio xin cảm ơn bạn !</p></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:28px;color:#333333;font-size:14px\"><strong><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#000000;font-size:14px;line-height:28px\" href=\"\">depropstudio.com</a></strong></p></td>\n" +
                "                     </tr>\n" +
                "                   </table></td>\n" +
                "                 </tr>\n" +
                "               </table></td>\n" +
                "             </tr>\n" +
                "           </table></td>\n" +
                "         </tr>\n" +
                "       </table></td>\n" +
                "     </tr>\n" +
                "   </table>\n" +
                "  </div>\n" +
                " </body>\n" +
                "</html>";
        return template;
    }
}
