package com.search;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Finalmanager.finalmanager;
import com.net.changepage.Pageajax;
import com.net.changepage.Pageintr;
import com.net.changepage.Pageshownum;
import com.target.book;

import org.springframework.ui.ModelMap;
@Controller
public class searchController{ 
   @RequestMapping(value="/home",method = RequestMethod.GET)
   public String printHello(ModelMap model) {
	   System.out.print("ok");
    return "home";
   }
   @RequestMapping(value="/searching")
   public ModelAndView  searching(HttpServletRequest request,HttpServletResponse response) {
	   ModelAndView view=new ModelAndView("searching");
	   System.out.print(request.getParameter("username"));
	   String s=request.getParameter("username");
	   s=s.replace("/", "").replace("\"","").replace("%","").trim().replace("+", "")
			   .replace("-", "").replace("*", "").replace("/", "").replace("\\.", "")
			   .replace("\"", "").replace(",", "").replace("?", "").trim();
	   int page=1;
	   int maxn=finalmanager.getmax(s);
	   maxn=(int) Math.ceil(maxn/10)+1;
	   if(request.getParameter("page")!=null) {
		  page=Integer.parseInt(request.getParameter("page"));
	   }
	   List<book> blist=finalmanager.getBooks(s, page-1);
//	   System.out.println(page+"  "+s+blist.get(1).getName());  
	   String HTML="";
	   String tr="<div class=\"from_URL\">";
	   String tr2="</div>";
	   String temp="";
	   for (book b : blist) {
		   HTML=HTML+tr+"<div class=\"from_URL_name\"><a href=\""+b.getUrl()+"\" target=\"_blank\" onclick=\"clickpage(this)\">"+b.getName()+"---"+b.getType()+"</a></div>"
	   +"<div class=\"from_URL_sketch\">"+b.getSketch().trim()+"</div>"
	   +"<div class=\"from_URL_author\">"+b.getAuthor()+"</div>"
	   +"<div class=\"from_URL_origin\">"+b.getOrigin()+"</div>"
	   + "<div class=\"from_URL_origin\">点击量:"+b.getVisittimes()+"</div>"
	   +tr2;
	   }
	   Pageintr p;
	   if(finalmanager.getPagetype()==1) {
		   p=new Pageshownum();
	   }
	   else {
		   p=new Pageajax();
	   }
	   HTML=HTML+p.getpagecontent(page, maxn, s);
	   view.addObject("data",HTML);
	   view.addObject("content",s);
//	   System.out.println(maxn);
//	   request.setAttribute("data", blist);
    return view;
   }
   @RequestMapping(value="/addclick")
   public void addclick(HttpServletRequest request) {
	   String url=request.getParameter("url");
	   finalmanager.addclick(url);
	   System.out.print("search123");
   }
   @RequestMapping("/nextpage")
   @ResponseBody
   public String next(String content,int page) {
	   String s=content;
	   s=s.replace("/", "").replace("\"","").replace("%","").trim().replace("+", "")
			   .replace("-", "").replace("*", "").replace("/", "").replace("\\.", "")
			   .replace("\"", "").replace(",", "").replace("?", "").trim();
	   int maxn=finalmanager.getmax(s);
	   maxn=(int) Math.ceil(maxn/10)+1;
	   String HTML="";
	   System.out.println(page);
	   if(page<maxn) {
	   List<book> blist=finalmanager.getBooks(s, page-1);
//	   System.out.println(page+"  "+s+blist.get(1).getName());
	   ModelAndView view=new ModelAndView("searching");
	   String tr="<div class=\"from_URL\">";
	   String tr2="</div>";
	   String temp="";
	   for (book b : blist) {
		   HTML=HTML+tr+"<div class=\"from_URL_name\"><a href=\""+b.getUrl()+"\" target=\"_blank\" onclick=\"clickpage(this)\">"+b.getName()+"---"+b.getType()+"</a></div>"
	   +"<div class=\"from_URL_sketch\">"+b.getSketch().trim()+"</div>"
	   +"<div class=\"from_URL_author\">"+b.getAuthor()+"</div>"
	   +"<div class=\"from_URL_origin\">"+b.getOrigin()+"</div>"
	   +tr2;
	   }
	   Pageintr p=new Pageajax();
	   HTML=HTML+p.getpagecontent(page, maxn, s);
	   }
	   else {
		   HTML="<div class=\"from_URL_bottom\">\"客官没了喔！\"</div>";
	   }
	return HTML;
   }
}
