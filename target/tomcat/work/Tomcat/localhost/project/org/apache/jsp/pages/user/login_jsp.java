/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-02-04 09:31:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/pages/common/head.jsp", Long.valueOf(1643891603358L));
    _jspx_dependants.put("/pages/common/footer.jsp", Long.valueOf(1643192514931L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>尚硅谷会员登录页面</title>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("\r\n");

    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            +"/";
    request.setAttribute("basePath",basePath);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\"/>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"static/css/style.css\" >\r\n");
      out.write("<script src=\"Script/jquery.js\"></script>\r\n");
      out.write("<script src=\"Script/axios.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<div id=\"login_header\">\r\n");
      out.write("\t\t\t<img class=\"logo_img\" alt=\"\" src=\"static/img/logo.gif\" >\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"login_banner\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"l_content\">\r\n");
      out.write("\t\t\t\t\t<span class=\"login_word\">欢迎登录</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t\t<div class=\"login_form\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"login_box\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h1>尚硅谷会员</h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"pages/user/regist.jsp\">立即注册</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"msg_cont\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<b></b>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"errorMsg\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty msg ? \"请输入用户名和密码\":\"用户名或密码错误!\"}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<form action=\"/project/UserServlet?action=login\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>用户名称：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"itxt\" type=\"text\" placeholder=\"请输入用户名\" autocomplete=\"off\" tabindex=\"1\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username == null ? cookie.username.value : username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>用户密码：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"itxt\" type=\"password\" placeholder=\"请输入密码\" autocomplete=\"off\" tabindex=\"1\" name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cookie.password.value}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"remember\" value=\"1\"> 记住我\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"登录\" id=\"sub_btn\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"bottom\">\r\n");
      out.write("\t\t<span>\r\n");
      out.write("\t\t\t尚硅谷书城.Copyright &copy;2015\r\n");
      out.write("\t\t</span>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
