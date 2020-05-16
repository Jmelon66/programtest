package web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbcsql.Booksql;
import com.optionkey.searchdes;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class readbai implements readintr{
	booklist blist;
	static int  con=0;
	  String pa ,name,
		time,
		type2 = "1",
		origin = "1",
		sketch = "1",urll;
	static int num=0;
	int max=1000;
	String url="https://top.baidu.com/buzz?b=1&fr=20811";
//	String url="http://sp0.baidu.com/s?ie=utf-8&mod=1&wd=机器人展";
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
		num=0;
	}
	public  readbai() {
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
		con=1;
		if(max==1000&&maxcount>100)
		max=maxcount;
	       pa = null;
	       List<String> l=null;
			Selectable s = page.getHtml();
			name =s.xpath("//*title/text()").get();
			time=s.xpath("//*[@class=\"time\"]/text()").get();
			if(time==null) {
				time=s.xpath("//*[@class=\"date\"]/text()").get();
				if(time==null) {
					time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				}
			}
			time=searchdes.gettime(time);
			sketch =s.xpath("//*[@name=\"description\"]/@content").get();
			urll = page.getUrl().get();
			origin = urll.substring(urll.indexOf("/", 1)+2,urll.indexOf("/", 10));
			if(sketch==null && name!=null) {
				sketch=searchdes.search(s.xpath("//*/text()").all(),name);
			}
//			System.out.println("n:"+name);
//			System.out.println("t:"+time);
//			System.out.println("s:"+sketch);
//			System.out.println("o:"+origin);
			try {
				if (name != null && time != null && origin != null && sketch != null && type2 != null && urll != null)
					blist.input2(name, time, origin, sketch, urll);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(s);
			l=s.xpath("//*a/@href").all();
//			System.out.println(l.size());
			
			for(int i=0;i<l.size();i++){
				try {
					if(!l.get(i).equals(null)&&num<max) {
						num++;
					page.addTargetRequest(l.get(i));
					}
//					System.out.println(i+":"+l.get(i));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (!page.getUrl().regex(".*baidu.com").match()) {
				System.out.println(s.xpath("//*title/text()"));
				
			}
			if(num>=max) {
				con=0;
			}
			return num;
}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
}

