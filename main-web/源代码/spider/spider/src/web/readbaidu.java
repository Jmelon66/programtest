package web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbcsql.Booksql;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Selectable;

public class readbaidu {
	booklist blist;
	String url="https://wenku.baidu.com/view/28c48f421a37f111f0855ba6.html";
	public readbaidu() {
	ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
	Booksql booksql = (Booksql) context.getBean("Booksql");
	blist = new booklist(booksql);
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public booklist getBlist() {
		return blist;
	}
	public void setBlist(booklist blist) {
		this.blist = blist;
	}
	public int process(int count,int maxcount,int pag,int type,Page page) {
	       System.out.println(6); 
			// 加入满足条件的链接/html/body/div[6]/div/a[3]
			// String
			// pa=page.getHtml().xpath("//*[@class=\"Page\"]//a[8]//span/text()").get();
			String pa = null;
			Selectable s = page.getHtml();
			pa = s.xpath("//*[@class=\"bd\"]/text()").get();
			System.out.println(pa);
	        return count;
}
}

