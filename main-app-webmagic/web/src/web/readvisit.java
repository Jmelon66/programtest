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

public class readvisit implements readintr{
	booklist blist;
	static int  con=0;
	  String pa ,name,
		time,
		type2 = "1",
		origin = "1",
		sketch = "1",urll;
	static int num=0;
	int max=10;
	String url="https://blog.csdn.net/qq_39205157/article/details/106306835";
	String[] blog= {"https://blog.csdn.net/qq_39205157/article/details/106451854",
			"https://blog.csdn.net/qq_39205157/article/details/106313021"
			};
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
		num=0;
	}
	public  readvisit() {
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
		    for(String b : blog)
			page.addTargetRequest(b);
			num++;
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

