package web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import javax.xml.xpath.*;
import com.jdbcsql.Booksql;

import test.Process;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Spider.Status;
import us.codecraft.webmagic.monitor.SpiderStatus;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class REPrecess implements PageProcessor {
	// 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private static Site site;
	private static int count = 0;
	private static booklist blist;
	static int pag = 10;
	private static int type = 0;
	private static int maxcount = 10;
	boolean flag = true;
	String port = "12";
	String host = "127.0.0.1";
	readintr r ;
	public Site getSite() {
        return site;
    }
//	  public void process(Page page) {
//	        //判断链接是否符合http://www.cnblogs.com/任意个数字字母-/p/7个数字.html格式
//	    	r.process(1, 5, 1, 1, page);
//	    }

	public void process(Page page) {
		count=r.process(count, maxcount, pag, type, page);
		
	}

	public void run(String url,int SleepTime, int RetryTimes, int CycleRetryTimes, int pag, int type, int maxcount) {
		
		if(SleepTime>0){
		site = Site.me().setSleepTime(SleepTime);
		}
		else {
			site = Site.me().setSleepTime(50);
		}
		if(RetryTimes>0) {
			site.setRetryTimes(RetryTimes);
		}
		else {
			site.setRetryTimes(50);
		}
		if(CycleRetryTimes>0) {
			site.setCycleRetryTimes(CycleRetryTimes);
		}
		System.out.println("SleepTime:"+SleepTime);
		System.out.println("RetryTimes:"+RetryTimes);
		System.out.println("CycleRetryTimes:"+CycleRetryTimes);
		System.out.println("pag:"+pag);
		System.out.println("type:"+type);
		System.out.println("maxcount:"+maxcount);
		if(pag>0)
		this.pag = pag;
		if(maxcount>0)
		this.maxcount = maxcount;
		if(count>0)
		this.count = 0;
		if(type>0)
		this.type = type;
		long startTime, endTime;
		r=new readbai();
		r.setUrl(url);
		r.setMax(maxcount);
		flag = false;
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		Booksql booksql = (Booksql) context.getBean("Booksql");
		blist = new booklist(booksql);
		System.out.println("开始爬取..."+r.getUrl() + ".html");
		startTime = System.currentTimeMillis();
		Spider.create(this)
				.addUrl(r.getUrl()).thread(5).run();
		endTime = System.currentTimeMillis();
		  System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+count+"条记录");
//		// 3497 3507
		  
		flag = true;
		
	}
	public int getcon() {
		return r.getCon();
	}
	public boolean isValid() {
		return flag;
	}


}