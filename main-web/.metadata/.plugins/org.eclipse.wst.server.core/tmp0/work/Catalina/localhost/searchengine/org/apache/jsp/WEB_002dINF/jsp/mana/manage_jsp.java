/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.19
 * Generated at: 2020-05-10 02:50:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.mana;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print(basePath);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\" http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8;width=device-width,initial-scale=1.0;\">\r\n");
      out.write("<title>冲浪搜索管理</title>\r\n");
      out.write("<script src=\"https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("css/mana.css\" />\r\n");
      out.write("<script  type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("js/mana.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"from-input-pan\">\r\n");
      out.write("\t\t<div class=\"from-input-mpan\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" onclick=\"closeinp()\">&times;</button>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">具体消息</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<textarea class=\"from-suginfo\" readonly=\"true\" id=\"concrete\"></textarea>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"from-input-mpan\" style=\"display: none;\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" onclick=\"closeinp()\">&times;</button>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">违规网站添加</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t<span class=\"input-group-addon\">网站:</span> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\tclass=\"form-control input\" placeholder=\"www\" name=\"banurl\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t<span class=\"input-group-addon\">原因:</span>\r\n");
      out.write("\t\t\t\t<textarea class=\"form-control input\" placeholder=\"如暴力，请简述\"\r\n");
      out.write("\t\t\t\t\tid=\"banreason\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" onclick=\"closeinp()\">关闭</button>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"addbanf(this)\">提交</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"from-main\">\r\n");
      out.write("\t\t<div class=\"form-nav\">\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t\t<a onclick=\"Switchpan(0)\" class=\"nav-click\">爬虫管理</a> <a\r\n");
      out.write("\t\t\t\t\tonclick=\"Switchpan(1)\" class=\"nav-click\">词库管理</a> <a\r\n");
      out.write("\t\t\t\t\tonclick=\"Switchpan(2)\" class=\"nav-click\">热点配置</a> <a\r\n");
      out.write("\t\t\t\t\tonclick=\"Switchpan(3)\" class=\"nav-click\">违规处理</a> <a\r\n");
      out.write("\t\t\t\t\tonclick=\"Switchpan(4)\" class=\"nav-click\">意见箱管理</a>\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"from-content\" style=\"display: none;\">\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t<span class=\"input-group-addon\">循环间隔:</span> <input type=\"number\"\r\n");
      out.write("\t\t\t\t\tclass=\"form-control input\" placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${delayTime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"delayTime\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t<span class=\"input-group-addon\">爬取数量:</span> <input type=\"number\"\r\n");
      out.write("\t\t\t\t\tclass=\"form-control input\" placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${carrynum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"carrynum\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\tonclick=\"spidertretry()\">保存设置</button>\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<h4>定点爬取</h4>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t<span class=\"input-group-addon\">网站URL:</span> <input\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control input\" placeholder=\"www.baidu.com\" name=\"HURL\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t<span class=\"input-group-addon\">爬取数量:</span> <input type=\"number\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control input\" placeholder=\"50\" name=\"caughnum\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"spiderstart()\">启动</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<div class=\"retip\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"from-content\" style=\"display: none;\">\r\n");
      out.write("\t\t\t<div class=\"form-group \">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"name\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"请输入名称\" name=\"skey\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"opskey(1)\">搜索</button>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"opskey(2)\">检索</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<div class=\"from-opkey\">\r\n");
      out.write("\t\t\t<table class=\"table table-striped table-word\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<caption>词表</caption>\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>序号</th>\r\n");
      out.write("\t\t\t\t\t\t<th>词</th>\r\n");
      out.write("\t\t\t\t\t\t<th>搜索量</th>\r\n");
      out.write("\t\t\t\t\t\t<th>热度</th>\r\n");
      out.write("\t\t\t\t\t\t<th>操作</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody class=\"opkey\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>词</th>\r\n");
      out.write("\t\t\t\t\t\t<th>被检索次数</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"glyphicon glyphicon-remove op-del\" title=\"删除\"></div>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"from-content\" style=\"display: none;\">\r\n");
      out.write("\t\t\t<div class=\"from-hotmana\">\r\n");
      out.write("\t\t\t\t<div class=\"form-hotmana-key\">\r\n");
      out.write("\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>排名</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>词名</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>量</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>热度</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody class=\"wrank\">\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"hr-horizontal\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"form-hotmana-key\">\r\n");
      out.write("\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>排名</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>热点名</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>操作</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody class=\"hotmana\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>词</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>被检索次数</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"glyphicon glyphicon-pencil op-del\" title=\"删除\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"from-content\" style=\"display: none;\">\r\n");
      out.write("\t\t\t<div class=\"form-group \">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"addban()\">添加</button>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"searban()\">检索</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<table class=\"table table-striped\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<caption>网页</caption>\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>网页</th>\r\n");
      out.write("\t\t\t\t\t\t<th>违规原因</th>\r\n");
      out.write("\t\t\t\t\t\t<th>操作</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody class='banhurl'>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>2</th>\r\n");
      out.write("\t\t\t\t\t\t<th>1</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"glyphicon glyphicon-remove op-del\" title=\"删除\" onclick=\"delbanh(this)\"></div>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"from-content\" style=\"display: none;\">\r\n");
      out.write("\t\t\t<div class=\"btn-group\" data-toggle=\"buttons\">\r\n");
      out.write("\t\t\t\t<label class=\"btn btn-primary\"> <input type=\"radio\"\r\n");
      out.write("\t\t\t\t\tname=\"selectmes\" id=\"option1\" value=\"1\" checked=\"checked\"\r\n");
      out.write("\t\t\t\t\tonchange=\"sugtype(2)\">全部\r\n");
      out.write("\t\t\t\t</label> <label class=\"btn btn-primary\"> <input type=\"radio\"\r\n");
      out.write("\t\t\t\t\tname=\"selectmes\" value=\"2\" id=\"option2\" onchange=\"sugtype(1)\">未读\r\n");
      out.write("\t\t\t\t</label> <label class=\"btn btn-primary\"> <input type=\"radio\"\r\n");
      out.write("\t\t\t\t\tname=\"selectmes\" value=\"2\" id=\"option2\" onchange=\"sugtype(0)\">已读\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<table class=\"table table-striped\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<caption>消息</caption>\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>来源</th>\r\n");
      out.write("\t\t\t\t\t\t<th>信息</th>\r\n");
      out.write("\t\t\t\t\t\t<th>时间</th>\r\n");
      out.write("\t\t\t\t\t\t<th>是否已读</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody id=\"sugcon\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>2</th>\r\n");
      out.write("\t\t\t\t\t\t<th>1</th>\r\n");
      out.write("\t\t\t\t\t\t<th>2</th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"glyphicon glyphicon-folder-open op-del\" title=\"具体\" onclick=\"toiinfo(this)\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-remove op-del\" title=\"删除\" onclick=\"delmes(1)\"></span>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function sugtype(e){\r\n");
      out.write("\tvar da = {\r\n");
      out.write("\t\ttype : e\r\n");
      out.write("\t}\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"opensug\",\r\n");
      out.write("\t\tcache : false,\r\n");
      out.write("\t\tdata : da,\r\n");
      out.write("\t\ttype : \"post\",\r\n");
      out.write("\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t$(\"#sugcon\").html(data);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("function toiinfo(e,id){\r\n");
      out.write("\t$('.from-input-pan').show();\r\n");
      out.write("\t$('.from-input-pan').children('.from-input-mpan').hide();\r\n");
      out.write("\t$('.from-input-pan').children('.from-input-mpan').eq(0).show();\r\n");
      out.write("\tvar t=$(e).parents('tr').children('td');\r\n");
      out.write("\tvar con=t.eq(1).html();\r\n");
      out.write("\tvar ori=t.eq(0).html();\r\n");
      out.write("\tvar time=t.eq(2).html();\r\n");
      out.write("\tvar info=con+\"，时间：\"+time\r\n");
      out.write("\t$('#concrete').val(info);\r\n");
      out.write("\tt.eq(3).html(\"<span class='glyphicon glyphicon-folder-open op-del' title='具体' onclick='toiinfo(this,\"+id+\")'></span><span class='glyphicon glyphicon-remove op-del' title='删除' onclick='delmes(this,\"+id+\")'></span>\");\r\n");
      out.write("\tvar da = {\r\n");
      out.write("\t\tid : id\r\n");
      out.write("\t}\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"sugread\",\r\n");
      out.write("\t\tcache : false,\r\n");
      out.write("\t\tdata : da,\r\n");
      out.write("\t\ttype : \"post\",\r\n");
      out.write("\t\tsuccess : function(data) {\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("function delmes(t,id){\r\n");
      out.write("\t\r\n");
      out.write("\tvar da = {\r\n");
      out.write("\t\t\tid : id\r\n");
      out.write("\t\t}\r\n");
      out.write("\tvar f= confirm(\"确定删除吗？\");\r\n");
      out.write("\tif(f==true){\r\n");
      out.write("\tvar t1=$(t).parents('tr');\r\n");
      out.write("\t$(t1).remove();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"sugdel\",\r\n");
      out.write("\t\t\tcache : false,\r\n");
      out.write("\t\t\tdata : da,\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
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
