package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Profile;

public final class news_002dfeed_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/top_nav.jspf");
    _jspx_dependants.add("/WEB-INF/friend-list.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/head_tag.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("New feed", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\n");
      out.write("<nav class=\"container-fluid\" id=\"main-nav-user-home\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-md-6\" id=\"user-tools-left\">\n");
      out.write("            <a href=\"FrontController?action=news-feed\" id=\"main-logo\">F</a>\n");
      out.write("            <div id=\"search-box\">\n");
      out.write("                <input type=\"text\" name=\"search-friend\">\n");
      out.write("                <button><i class=\"fa fa-search\"></i></button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-6\" id=\"user-tools-right\">\n");
      out.write("            <ul>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"FrontController?action=view-profile\"><img class=\"avatar-small\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ProcessImage?emailOrPhone=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.emailOrPhone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> \n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"#\">Home <span>20+</span></a></li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-users\" aria-hidden=\"true\"></i></a>\n");
      out.write("                    <span class=\"mess-notif\">9</span>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-weixin\" aria-hidden=\"true\"></i></a>\n");
      out.write("                    <span class=\"mess-notif\">25</span>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-globe\" aria-hidden=\"true\"></i></a>\n");
      out.write("                    <span class=\"mess-notif\">5</span>\n");
      out.write("                </li>\n");
      out.write("                ");
 if (session.getAttribute("user") != null) 
                { 
                
      out.write("\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"ProcessLogout\">Sign out</a>\n");
      out.write("                </li>\n");
      out.write("                ");
 
                } 
                
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <section class=\"container-fluid\" id=\"main-body\">\r\n");
      out.write("            <div class=\"row no-pad\">\r\n");
      out.write("                <div class=\"col-md-2 no-pad\">\r\n");
      out.write("                    <div class=\"left-tool-section\">\r\n");
      out.write("                        <a href=\"\">\r\n");
      out.write("                            <img class=\"avatar-small\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ProcessImage?emailOrPhone=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.emailOrPhone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> \r\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"FrontController?action=view-profile\"><i class=\"fa fa-pencil\" aria-hidden=\"true\"></i> Edit Profile</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"left-tool-section\">\r\n");
      out.write("                        <h4>FAVORITES</h4>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-newspaper-o\" aria-hidden=\"true\"></i> News Feed</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-globe\" aria-hidden=\"true\"></i> Messages</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-weixin\" aria-hidden=\"true\"></i> Events</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-life-ring\" aria-hidden=\"true\"></i> Sales Group</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"left-tool-section\">\r\n");
      out.write("                        <h4>FRIENDS</h4>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-location-arrow\" aria-hidden=\"true\"></i> Ho Chi Minh City</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-graduation-cap\" aria-hidden=\"true\"></i> Truong THPT Phu Nhuan</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-building\" aria-hidden=\"true\"></i> FPT Corporation</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-graduation-cap\" aria-hidden=\"true\"></i> UIT</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"left-tool-section\">\r\n");
      out.write("                        <h4>APPS</h4>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-industry\" aria-hidden=\"true\"></i> Live Videos</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-gamepad\" aria-hidden=\"true\"></i> Games</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> On This Day</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-picture-o\" aria-hidden=\"true\"></i> Photos</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-gamepad\" aria-hidden=\"true\"></i> Games Feed</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"left-tool-section\">\r\n");
      out.write("                        <h4>EVENTS</h4>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-bicycle\" aria-hidden=\"true\"></i> Live Videos</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-music\" aria-hidden=\"true\"></i> Musics</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-fax\" aria-hidden=\"true\"></i> Re-Union</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-deaf\" aria-hidden=\"true\"></i> Company Trips</a>\r\n");
      out.write("                        <a href=\"\"><i class=\"fa fa-credit-card-alt\" aria-hidden=\"true\"></i> Family Trips</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-5 no-pad\">\r\n");
      out.write("                    <div class=\"middle-section\" id=\"post-form\">\r\n");
      out.write("                        <form action=\"FrontController\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("                            <div id=\"post-form-header\">\r\n");
      out.write("                                <a href=\"#\" id=\"button-upload-photo\">\r\n");
      out.write("                                    <i class=\"fa fa-file-image-o\" aria-hidden=\"true\"></i> Photo/Camera\r\n");
      out.write("                                    <input type=\"file\" class=\"masked-file-input\" id=\"myfile\" name=\"postimage\" />\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <span id=\"post-form-close-button\">x</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div id=\"post-form-body\">\r\n");
      out.write("                                <img class=\"avatar-small\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ProcessImage?emailOrPhone=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.emailOrPhone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                <!--                                                            <div id=\"post-form-editor\" contenteditable>\r\n");
      out.write("                                                                                                \r\n");
      out.write("                                                                                            </div>-->\r\n");
      out.write("                                <textarea  name=\"posttext\"  id=\"post-form-editor\" style=\"width: 100%;height: 100%;\" placeholder=\"What's your mind?\"></textarea>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div id=\"post-form-footer\">\r\n");
      out.write("                                <div class=\"row no-pad\">\r\n");
      out.write("                                    <div class=\"col-md-6 no-pad\">\r\n");
      out.write("                                        <a href=\"\">\r\n");
      out.write("                                            <i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <a href=\"\">\r\n");
      out.write("                                            <i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <a href=\"\">\r\n");
      out.write("                                            <i class=\"fa fa-smile-o\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-6 no-pad\" style=\"text-align:right;\">\r\n");
      out.write("                                        <a href=\"#\" id=\"button-public\">\r\n");
      out.write("                                            <i class=\"fa fa-globe\" aria-hidden=\"true\"></i> Public <i class=\"fa fa-caret-down\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <button type=\"submit\" name=\"action\" value=\"add-post\" id=\"button-post\">\r\n");
      out.write("                                            Post\r\n");
      out.write("                                        </button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"alert-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"middle-section user-post\">\r\n");
      out.write("                        <div class=\"user-post-header\">\r\n");
      out.write("                            <img src=\"img/user.jpg\">\r\n");
      out.write("                            <span>\r\n");
      out.write("                                <a href=\"#\">RNG Uzi</a>\r\n");
      out.write("                                <p class=\"help-block\">22hrs <i class=\"fa fa-globe\" aria-hidden=\"true\"></i></p>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"user-post-body\">\r\n");
      out.write("                            Ahuhu\r\n");
      out.write("                            <img src=\"img/sample.jpg\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"user-post-tool\">\r\n");
      out.write("                            <a href=\"\"><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i> Like</a>\r\n");
      out.write("                            <a href=\"\"><i class=\"fa fa-comment\" aria-hidden=\"true\"></i> Comment</a>\r\n");
      out.write("                            <a href=\"\"><i class=\"fa fa-share\" aria-hidden=\"true\"></i> Share</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"user-post-info\">\r\n");
      out.write("                            <span class=\"like-icon\"><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i></span>\r\n");
      out.write("                            <a href=\"\">You and others like this</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"user-post-comment-list\">\r\n");
      out.write("                            <div class=\"user-post-comment-item\">\r\n");
      out.write("                                <img src=\"img/user-comment1.jpg\">\r\n");
      out.write("                                <span>\r\n");
      out.write("                                    <a href=\"#\">Kiki</a> Ahuhu ahihi\r\n");
      out.write("                                    <div class=\"help-block\">\r\n");
      out.write("                                        <a href=\"#\">Like</a>.\r\n");
      out.write("                                        <a href=\"#\">Reply</a>.\r\n");
      out.write("                                        21 hrs\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </span>\r\n");
      out.write("                                <div class=\"user-post-reply-item\">\r\n");
      out.write("                                    <i class=\"fa fa-share\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                    <img src=\"img/user-comment3.jpg\">\r\n");
      out.write("                                    <a href=\"\">Ahiuhiu . 20 replies</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"user-post-comment-item\">\r\n");
      out.write("                                <img src=\"img/user_comment2.jpg\">\r\n");
      out.write("                                <span>\r\n");
      out.write("                                    <a href=\"#\">John cena</a> Ngon\r\n");
      out.write("                                    <div class=\"help-block\">\r\n");
      out.write("                                        <a href=\"#\">Like</a>.\r\n");
      out.write("                                        <a href=\"#\">Reply</a>.\r\n");
      out.write("                                        21 hrs\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"user-post-comment-item\">\r\n");
      out.write("                                <img src=\"img/user-comment3.jpg\">\r\n");
      out.write("                                <span>\r\n");
      out.write("                                    <a href=\"#\">RNG Xiaohu</a> Ngon ngon\r\n");
      out.write("                                    <div class=\"help-block\">\r\n");
      out.write("                                        <a href=\"#\">Like</a>.\r\n");
      out.write("                                        <a href=\"#\">Reply</a>.\r\n");
      out.write("                                        <span class=\"like-icon-small\"><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i></span>. 21 hrs\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"user-post-reply-form\">\r\n");
      out.write("                            <img class=\"avatar-small\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ProcessImage?emailOrPhone=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.emailOrPhone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> \r\n");
      out.write("                            <div class=\"user-post-reply-editor\" contenteditable=\"true\">\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <span>\r\n");
      out.write("                                <i class=\"fa fa-picture-o\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                <input type=\"file\" class=\"masked-file-input\" name=\"upload-2\"/>\r\n");
      out.write("                            </span>\r\n");
      out.write("                            <span>\r\n");
      out.write("                                <i class=\"fa fa-smile-o\" aria-hidden=\"true\"></i>\r\n");
      out.write("                            </span>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-3 no-pad\">\r\n");
      out.write("                    <div class=\"middle-right-section\">\r\n");
      out.write("                        <div class=\"middle-right-section-header\">\r\n");
      out.write("                            <span>\r\n");
      out.write("                                <i class=\"fa fa-gift\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                <a href=\"#\">3 event invitations today</a>\r\n");
      out.write("                            </span>\r\n");
      out.write("                            <span>\r\n");
      out.write("                                <i class=\"fa fa-calendar\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                <a href=\"\">Dang Xuan Duy Khuong</a>'s birthday is today\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"middle-right-section-body\">\r\n");
      out.write("                            <div class=\"middle-right-section-body-title\">\r\n");
      out.write("                                <label>PEOPLE YOU MAY KNOW</label>\r\n");
      out.write("                                <a href=\"#\">See All</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div id=\"suggested-friend\">\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-2 no-pad ahi\">\r\n");
      out.write("                    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"online-list\">\n");
      out.write("    <div id=\"friend-detail-popup\">\n");
      out.write("        <span id=\"back-triange\"></span>\n");
      out.write("        <span id=\"front-triange\"></span>\n");
      out.write("        <img id=\"profile-img\" src=\"img/profile.jpg\">\n");
      out.write("        <div id=\"friend-detail-popup-detail\">\n");
      out.write("            <p>\n");
      out.write("                <a id=\"profile-full-name\" href=\"#\"></a>\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <ul>\n");
      out.write("        ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#online-list li\").click(function () {\n");
      out.write("            if (window.confirm(\"Do you want to unfriend?\") === true)\n");
      out.write("            {\n");
      out.write("                var idFriend = $(this).attr(\"class\");\n");
      out.write("                $.ajax({\n");
      out.write("                    url: \"ProcessUnfriend\",\n");
      out.write("                    type: \"POST\",\n");
      out.write("                    data: {\n");
      out.write("                        idFriend: idFriend\n");
      out.write("                    },\n");
      out.write("                    success: function (data) {\n");
      out.write("                        $(\".ahi\").html(data);\n");
      out.write("                        $.ajax({\n");
      out.write("                            url: \"ProcessSuggestFriend\",\n");
      out.write("                            type: \"POST\",\n");
      out.write("                            success: function (data) {\n");
      out.write("                                $(\"#suggested-friend\").html(data);\n");
      out.write("                            },\n");
      out.write("                            error: function (e) {\n");
      out.write("                                alert(\"Error loading ajax \" + e);\n");
      out.write("                            }\n");
      out.write("                        })\n");
      out.write("                        var viewportHeight = $(window).height();\n");
      out.write("                        $(\"#online-list ul\").css(\"max-height\", viewportHeight);\n");
      out.write("                    },\n");
      out.write("                    error: function () {\n");
      out.write("                        alert(\"cannot unfriend\");\n");
      out.write("                    }\n");
      out.write("                })\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("        $(\"#online-list li\").hover(function () {\n");
      out.write("            var emailOrPhone = $(this).attr(\"id\");\n");
      out.write("            $.ajax({\n");
      out.write("                url: \"IndividualProfile\",\n");
      out.write("                type: \"POST\",\n");
      out.write("                dataType: \"json\",\n");
      out.write("                data: {\n");
      out.write("                    emailOrPhone: emailOrPhone\n");
      out.write("                },\n");
      out.write("                success: function (data) {\n");
      out.write("                    $(\"#profile-img\").attr(\"src\", data.imageString);\n");
      out.write("                    $(\"#profile-full-name\").html(data.fullName);\n");
      out.write("                },\n");
      out.write("                error: function () {\n");
      out.write("                    alert(\"cannot load data\");\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }, function () {\n");
      out.write("        })\n");
      out.write("    })\n");
      out.write("</script>\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <section id=\"chat-box\">\r\n");
      out.write("                <div id=\"chat-box-header\">\r\n");
      out.write("                    <a href=\"#\">CÃ  Chua</a>\r\n");
      out.write("                    <span>\r\n");
      out.write("                        <i class=\"fa fa-plus\" aria-hidden=\"true\"></i>\r\n");
      out.write("                        <i class=\"fa fa-camera\" aria-hidden=\"true\"></i>\r\n");
      out.write("                        <i class=\"fa fa-volume-control-phone\" aria-hidden=\"true\"></i>\r\n");
      out.write("                        <i class=\"fa fa-cog\" aria-hidden=\"true\"></i>\r\n");
      out.write("                        <i id=\"close-chat-box-button\" class=\"fa fa-times\" aria-hidden=\"true\"></i>\r\n");
      out.write("                    </span>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"chat-box-content-wrapper\">\r\n");
      out.write("                    <div id=\"chat-box-content\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"chat-box-editor\" contenteditable=\"true\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"chat-box-editor-tool\">\r\n");
      out.write("                    <span>\r\n");
      out.write("                        <i class=\"fa fa-picture-o\" aria-hidden=\"true\"></i>\r\n");
      out.write("                        <i class=\"fa fa-paperclip\" aria-hidden=\"true\"></i>\r\n");
      out.write("                        <i class=\"fa fa-smile-o\" aria-hidden=\"true\"></i>\r\n");
      out.write("                        <i class=\"fa fa-hand-peace-o\" aria-hidden=\"true\"></i>\r\n");
      out.write("                    </span>\r\n");
      out.write("                    <span>\r\n");
      out.write("                        <i class=\"fa fa-thumbs-o-up\" aria-hidden=\"true\"></i>\r\n");
      out.write("                    </span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <!--Confirm dialog -This must be the child of body-->\r\n");
      out.write("        <div id=\"dialog-confirm\">\r\n");
      out.write("            <div id=\"dialog-confirm-header\">\r\n");
      out.write("                <a href=\"#\" id=\"dc-btn-close\">Close</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"dialog-confirm-body\">\r\n");
      out.write("                <p>Are you sure you want to remove this friend?</p>\r\n");
      out.write("                <p>Becareful! Because you will not be able to see this person again</p>\r\n");
      out.write("                <p>Why don't you take some time to think about this action?</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"dialog-confirm-footer\">\r\n");
      out.write("                <a href=\"#\" id=\"dc-btn-yes\">Yes, I do</a>\r\n");
      out.write("                <a href=\"#\" id=\"dc-btn-no\">No, This is a mistake</a>\r\n");
      out.write("                <a href=\"#\" id=\"dc-btn-cancel\">Cancel</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            $(function () {\r\n");
      out.write("                    // Load suggested friend with AJAX\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: \"ProcessSuggestFriend\",\r\n");
      out.write("                    type: \"POST\",\r\n");
      out.write("                        success: function (data) {\r\n");
      out.write("                    $(\"#suggested-friend\").html(data);\r\n");
      out.write("                    },\r\n");
      out.write("                        error: function (e) {\r\n");
      out.write("                alert(\"Error loading ajax \" + e);\r\n");
      out.write("                }\r\n");
      out.write("                })\r\n");
      out.write("                var viewportHeight = $(window).height();\r\n");
      out.write("            $(\"#online-list ul\").css(\"max-height\", viewportHeight);\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("        <script src=\"js/app.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("list");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.friendList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("friend");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <li id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friend.emailOrPhone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friend.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                <img class=\"avatar-small\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/ProcessImage?emailOrPhone=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friend.emailOrPhone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"> \n");
          out.write("                <span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friend.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friend.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                <span></span>\n");
          out.write("            </li>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
