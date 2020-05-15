package test;

import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class test {
	public static void main(String[] args) {
		String pa = null;
		Html h=new Html("<a href=\"www.www.www\"><\\a>\r\n" + 
				"<a href=\"www.2www\"><\\a>");	
		System.out.print(h);
	}
}
