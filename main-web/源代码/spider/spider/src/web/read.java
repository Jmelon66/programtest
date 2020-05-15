package web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbcsql.Booksql;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.selector.Selectable;

public  class  read implements readintr{
	String url="https://b.faloo.com/y/0/0/0/0/0/0/";
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
	booklist blist;
	public read() {
	ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
	Booksql booksql = (Booksql) context.getBean("Booksql");
	blist = new booklist(booksql);
	}
	public int process(int count,int maxcount,int pag,int type,Page page) {
		System.out.println(6);
		if (!page.getUrl().regex("https://b.faloo.com/f/[0-9]{1,}.html").match()) {
			
			// 加入满足条件的链接/html/body/div[6]/div/a[3]
			// String/html/body/div[8]/div[1]/div/div[1]/div[2]/div[1]/div[1]/h1
//			 pa=page.getHtml().xpath("//*[@class=\"Page\"]//a[8]//span/text()").get();
			String pa = null;
			Selectable s = page.getHtml();
			System.out.println(1);
//			pa = s.xpath("//*[@id=\"PageListBTop\"]/tbody/tr//td[3]//a[1]/text()").get();
			for (int i = 1; i < 20; i++) {
				try {
					pa = s.xpath("//*[@id=\"PageListBTop\"]/tbody/tr//td[3]//a[" + i + "]/text()").get();
					if (pa != null && pa.equals("下一页")) {
						pa = s.xpath("//*[@id=\"PageListBTop\"]/tbody/tr//td[3]//a[" + i + "]/@href").get();
						pa.replace("?", "");
						pa.replace("#", "");
						// System.out.println("page"+pa);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			System.out.println(pa);
			if (count < maxcount&&pa!=null) {
				if (pa.indexOf("https://b.faloo.com/y/0/0/") > -1) {
					page.addTargetRequest(pa);
					try {
						String[] pages = pa.split("/");
						if (pages.length > 0) {
							// System.out.println(pages[pages.length-1]);
							pages = pages[pages.length - 1].split("\\.");
							String n = pages[0];
							pag = Integer.parseInt(n);
							// System.out.println(pag);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					pag++;
					String we = "https://b.faloo.com/y/0/0/0/0/0/0/" + pag + ".html";
					page.addTargetRequest(we);
				}
				page.addTargetRequests(page.getHtml().xpath("//*[@class=\"a_16b\"]/@href").all());
			}
			System.out.println(3);
		} else {
			System.out.println(5);
			 System.out.println("抓取的内容：" );
			Selectable se = page.getHtml();
			String name = se.xpath("//*[@class=\"a_24b\"]/text()").get();
			String author = se.xpath("//*[@class=\"ni_10\"]/a/text()").get();
			String type2= se.xpath("//*[@class=\"a_666\"]/a/text()").get();
			String origin = se.xpath("//*[@class=\"a_14 a_666\"]/b/text()").get();
			String sketch = se.xpath("//*[@id=\"con_tab11_box1\"]/a/text()").get();
			String url = page.getUrl().get();
			 System.out.println("抓取的内容："+name );
			 System.out.println("作者："+author );
			 System.out.println("类型："+type2 );
			 System.out.println("来源："+origin );
			 System.out.println("简述："+sketch );
			 System.out.println("链接："+url );
			try {
				if (name != null && author != null && origin != null && sketch != null && type2 != null && url != null)
					blist.input(name, author, origin, sketch, type2, url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(4);
			count++;
			System.out.println("已爬取数量：" + count);
		}
		return count;
	}
}
