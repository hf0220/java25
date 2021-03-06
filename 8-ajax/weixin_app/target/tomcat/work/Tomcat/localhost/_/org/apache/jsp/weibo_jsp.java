/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-23 03:00:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class weibo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/css/bootstrap.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div id=\"newalert\" class=\"alert alert-danger\" style=\"display:none\"><a id=\"text\" href=\"javascript:;\"></a></div>\r\n");
      out.write("\t\t<ul class=\"list-group\" id=\"weibo\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    <script src=\"/static/js/jquery-1.12.4.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("    \t$(function(){\r\n");
      out.write("    \t\tvar maxId = null;\r\n");
      out.write("    \t\tvar newMessage = null;\r\n");
      out.write("    \t\t$.get(\"/message\").done(function(data){\r\n");
      out.write("    \t\t\tfor(var i = 0; i < data.length; i++) {\r\n");
      out.write("    \t\t\t\t// 找到当前数据中id的最大值\r\n");
      out.write("    \t\t\t\tmaxId = data[0].id;\r\n");
      out.write("    \t\t\t\tvar li = \"<li class='list-group-item'>\" + data[i].message + \"</li>\";\r\n");
      out.write("    \t\t\t\t$(\"#weibo\").append(li);\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t}).error(function(){\r\n");
      out.write("    \t\t\talert(\"系统异常\")\r\n");
      out.write("    \t\t});\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\tsetInterval(function(){\r\n");
      out.write("    \t\t\t$.get(\"/message\",{\"maxId\": maxId}).done(function(data){\r\n");
      out.write("        \t\t\tif(data.length > 0) {\r\n");
      out.write("        \t\t\t\t$(\"#text\").text(\"有\" + data.length + \"条新微博\");\r\n");
      out.write("        \t\t\t\t$(\"#newalert\").show();\r\n");
      out.write("        \t\t\t\tnewMessage = data;\r\n");
      out.write("        \t\t\t}\r\n");
      out.write("        \t\t\t\r\n");
      out.write("        \t\t}).error(function(){\r\n");
      out.write("        \t\t\talert(\"系统异常\")\r\n");
      out.write("        \t\t});\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t},5000);\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\t$(\"#text\").click(function(){\r\n");
      out.write("    \t\t\t// alert框消失\r\n");
      out.write("    \t\t\t$(\"#newalert\").hide();\r\n");
      out.write("    \t\t\t// 添加数据\r\n");
      out.write("    \t\t\tfor(var i =  newMessage.length - 1; i >= 0; i--) {\r\n");
      out.write("\t    \t\t\t// 修改maxid\r\n");
      out.write("\t\t\t\t\tmaxId= newMessage[0].id;\r\n");
      out.write("\t    \t\t\t\r\n");
      out.write("    \t\t\t\tvar li = \"<li class='list-group-item'>\" + newMessage[i].message + \"</li>\";\r\n");
      out.write("    \t\t\t\t$(\"#weibo\").prepend(li);\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t});\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t})\r\n");
      out.write("    \t\t\r\n");
      out.write("    </script>\r\n");
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
