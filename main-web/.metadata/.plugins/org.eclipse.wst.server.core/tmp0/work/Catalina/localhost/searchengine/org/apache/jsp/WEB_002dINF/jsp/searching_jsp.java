/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.19
 * Generated at: 2020-05-10 03:05:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class searching_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/F:/李智营work/java应用技术/last/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/searchengine/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1557327650427L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
    }

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
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print(basePath);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".head-pan-op{\r\n");
      out.write("width:95%;\r\n");
      out.write("margin-right:3vw;\r\n");
      out.write("text-align: right;\r\n");
      out.write("font: 15px,helvetica;\r\n");
      out.write("color:gray;\r\n");
      out.write("}\r\n");
      out.write(".head-pan-op a:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.print(basePath);
      out.write("css/search.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("\t<script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>冲浪搜索</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class='head-pan-op'><a data-toggle=\"modal\" data-target=\"#myModal\">举报反馈</a></div>\r\n");
      out.write("<div class=\"modal fade head-op-sug\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t\t\t&times;\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">\r\n");
      out.write("\t\t\t\t\t反馈内容\r\n");
      out.write("\t\t\t\t</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("                <div class=\"input-group\">\r\n");
      out.write("                    <div class=\"input-group-btn\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default \r\n");
      out.write("                        dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <span id='sugtype'>举报</span>\r\n");
      out.write("                            <span class=\"caret\"></span>\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li>\r\n");
      out.write("                                <a href=\"#\" onclick=\"tchange('举报')\">举报</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\" onclick=\"tchange('推荐')\">推荐</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\" onclick=\"tchange('意见')\">意见</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\" onclick=\"tchange('其他')\">其他</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"inputurl\" placeholder=\"输入网页地址（选）\">\r\n");
      out.write("                    <textarea class=\"form-control input\" placeholder=\"简述信息\"\r\n");
      out.write("\t\t\t\t\tid=\"reason\"></textarea>\r\n");
      out.write("                </div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"subsug(this)\">\r\n");
      out.write("\t\t\t\t\t提交\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div><!-- /.modal-content -->\r\n");
      out.write("\t</div><!-- /.modal -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<form action=\"searchurl\" method=\"post\">\r\n");
      out.write("\t\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t\t<img alt='加载失败' src=\"");
      out.print(basePath);
      out.write("img/sea.png\" class=\"logoimg\" /> \r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"searchkey\" id=\"searchkey\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"输入搜索内容\" class=\"inputtext\" /> \r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"\" id=\"\" value=\"搜搜\" class=\"button\" /> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\tname=\"page\" value=\"1\" style=\"display: none;\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<from>\r\n");
      out.write("\t\t\t<hr class=\"hr_span\" />\r\n");
      out.write("\t<div id=\"recom\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recom}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t<div id=\"body2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t<div id=\"from-page\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t<hr class=\"hr_span\" />\r\n");
      out.write("\t<div class=\"bottom\">请勿随意转载</div></div>\r\n");
      out.write("\t<div id=\"hotinfo\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${hotinfo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction subsug(e){\r\n");
      out.write("\t\t\tvar type = $(\"#sugtype\").text();;\r\n");
      out.write("\t\t\tvar url = $(\"input[name='inputurl']\").val();\r\n");
      out.write("\t\t\tvar info = $(\"#reason\").val()\r\n");
      out.write("\t\t\tif((type==\"举报\"||type==\"推荐\")&&url==\"\"){\r\n");
      out.write("\t\t\t\talert(\"请输入网址\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t$('.close').trigger(\"click\");\r\n");
      out.write("\t\t\tvar da = {\r\n");
      out.write("\t\t\t\ttype : type,\r\n");
      out.write("\t\t\t\turl : url,\r\n");
      out.write("\t\t\t\tinfo : info\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"subsug\",\r\n");
      out.write("\t\t\t\tcache : false,\r\n");
      out.write("\t\t\t\tdata : da,\r\n");
      out.write("\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\talert(\"反馈成功\");\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction tchange(e){\r\n");
      out.write("\t\t$('#sugtype').text(e);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction clickpage(e) {\r\n");
      out.write("\t\tvar url = $(e).attr(\"href\")\r\n");
      out.write("\t\tvar jsonString = {\r\n");
      out.write("\t\t\t\"url\" : url\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\turl : \"addclick?url=\" + url,\r\n");
      out.write("\t\t\tasync : true,\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction loadpage() {\r\n");
      out.write("\t\t$(\"div\").remove(\".from_next_page\")\r\n");
      out.write("\t\tvar val = $(\"input[name='page']\").val()\r\n");
      out.write("\t\tvar page = Number(val) + 1\r\n");
      out.write("\t\t$(\"input[name='page']\").val(page)\r\n");
      out.write("\t\t$(\"#body2\")\r\n");
      out.write("\t\t\t\t.append(\r\n");
      out.write("\t\t\t\t\t\t\"<div class=\\\"loading\\\"><img alt='加载失败' src=\\\"http://localhost:8084/searchengine/img/load2.gif\\\"/></div>\")\r\n");
      out.write("\t\tvar content = $(\"input[name='searchkey']\").val()\r\n");
      out.write("\t\tvar da = {\r\n");
      out.write("\t\t\tcontent : content,\r\n");
      out.write("\t\t\tpage : page\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"nextpage2\",\r\n");
      out.write("\t\t\tcache : false,\r\n");
      out.write("\t\t\tdata : da,\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t$(\"div\").remove(\".loading\");\r\n");
      out.write("\t\t\t\t$(\"#body2\").append(data);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
