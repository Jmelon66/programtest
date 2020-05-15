package web;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import javax.xml.xpath.*;
import com.jdbcsql.Booksql;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Spider.Status;
import us.codecraft.webmagic.monitor.SpiderStatus;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class git implements PageProcessor {
	// 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private static Site site= Site.me().setSleepTime(50).setSleepTime(50).setRetryTimes(50);
	private static int count = 0;
	private static booklist blist;
	static int pag = 15;
	private static int type = 2;
	private static int maxcount = 10;
	boolean flag = true;
	String port = "12";
	String host = "127.0.0.1";
      static read r=null;
	public void process(Page page) {
		// 判断链接是否符合http://www.cnblogs.com/任意个数字字母-/p/7个数字.html格式

		
		count=r.process(count, maxcount, pag, type, page);
		System.out.println("已爬取数量：" + count);
	}

	public static void main(String[] args) {
		r=new read();
		
		long startTime, endTime;
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		Booksql booksql = (Booksql) context.getBean("Booksql");
		blist = new booklist(booksql);
		System.out.println("开始爬取...");
//		System.out.println("http://all.17k.com/lib/book/" + type + "_0_0_0_0_0_0_0_" + pag + ".html");
		startTime = System.currentTimeMillis();
		Spider.create(new git())
				.addUrl("https://b.faloo.com/y/0/0/0/0/0/0/" + pag + ".html").thread(5).run();
		endTime = System.currentTimeMillis();
		// 3497 3507
		System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了" + count + "条记录");
	}

	public boolean isValid() {
		return flag;
	}

	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

}