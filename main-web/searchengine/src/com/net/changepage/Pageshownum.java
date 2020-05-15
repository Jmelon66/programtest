package com.net.changepage;

public class Pageshownum implements Pageintr{

	@Override
	public String getpagecontent(int page,int maxn,String s) {
		String HTML="";
		// TODO Auto-generated method stub
		 HTML=HTML+"<div>";
		   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+1+
				   "\">首页</a>";
//		   上一页
		   if(page>1) {
			   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+(page-1)+
					   "\">上一页</a>";
		   }
		   else {
			   HTML=HTML+"<span class=\"b_disable\">上一页</span>";
		   }
//		   可指点页数
		   if(page>4) {
			   for(int j=page-3;j<page;j++) {
				   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+j+
						   "\">"+j+"</a>";
			   }
		   }
		   else if(page>maxn-6) {
			   int start=1;
			   if(page>10) {
				   start=(int) Math.floor(page/10)+1;
			   }
			   for(int j=start;j<page;j++) {
				   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+j+
						   "\">"+j+"</a>";
			   }
		   }
		   else{
			   for(int j=1;j<page;j++) {
				   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+j+
						   "\">"+j+"</a>";
			   }
		   }
		   HTML=HTML+"<span class=\"b_disable\">"+page+"</span>";
		   if(page<4&&maxn>10) {
			   for(int j=page+1;j<11;j++) {
				   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+j+
						   "\">"+j+"</a>";
			   }
		   }
		   else if(page<maxn-6) {
			   for(int j=page+1;j<page+6;j++) {
				   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+j+
						   "\">"+j+"</a>";
			   }
		   }
		   else {
			   for(int j=page+1;j<=maxn;j++) {
				   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+j+
						   "\">"+j+"</a>";
			   }
		   }
		   if(page<maxn) {
			   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+(page+1)+
					   "\">下一页</a>";
		   }
		   else {
			   HTML=HTML+"<span class=\"b_disable\">下一页</span>";
		   }
		   HTML=HTML+"<a class=\"page_button\" href=\"http://localhost:8084/searchengine/searchurl?searchkey="+s+"&page="+maxn+
				   "\">尾页</a></div>";
		return HTML;
	}

}
