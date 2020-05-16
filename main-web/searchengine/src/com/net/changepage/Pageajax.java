package com.net.changepage;

public class Pageajax implements Pageintr{

	@Override
	public String getpagecontent(int page, int maxn, String s) {
		// TODO Auto-generated .method stub
		String HTML="<div class=\"from_next_page\" onmouseover=\"loadpage()\">下一页</div>"
				+ "<input name=\"page\" value=\""+page+"\" style=\"display: none;\"/>";
		return HTML;
	}

}
