package web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbcsql.Booksql;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Selectable;

public class read17  implements readintr{
	booklist blist;
	String url="http://all.17k.com/lib/book/3_0_0_0_0_0_0_0_";
	public read17() {
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
	System.out.println(6); {
		if (!page.getUrl().regex("http://www.17k.com/book/[0-9]{1,}.html").match()) {
			// 加入满足条件的链接/html/body/div[6]/div/a[3]
			// String
			// pa=page.getHtml().xpath("//*[@class=\"Page\"]//a[8]//span/text()").get();
			String pa = null;
			Selectable s = page.getHtml();
			for (int i = 5; i < 20; i++) {
				try {
					pa = s.xpath("//*[@class=\"Page\"]//a[" + i + "]//span/text()").get();
					if (pa != null && pa.equals("下一页")) {
						pa = s.xpath("//*[@class=\"Page\"]//a[" + i + "]/@href").get();
						pa.replace("?", "");
						pa.replace("#", "");
						// System.out.println("page"+pa);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (count < maxcount) {
				if (pa.indexOf("http://all.17k.com/lib/book/") > -1) {
					page.addTargetRequest(pa);
					try {
						String[] pages = pa.split("_");
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
					String we = "http://all.17k.com/lib/book/" + type + "_0_0_0_0_0_0_0_" + pag + ".html";
					page.addTargetRequest(we);
				}
				page.addTargetRequests(page.getHtml().xpath("*[@class=\"jt\"]/@href").all());
			}
		} else {
			// System.out.println("抓取的内容：" );
			Selectable se = page.getHtml();
			String name = se.xpath("//*[@class=\"Info\"]/h1/a/text()").get();
			String author = se.xpath("//*[@class=\"name\"]/text()").get();
			String type2 = se.xpath("//*[@class=\"infoPath\"]//a[3]/text()").get();
			String origin = se.xpath("//*[@class=\"infoPath\"]//a[1]/text()").get();
			String sketch = se.xpath("//*[@class=\"cont\"]/a/text()").get();
			String url = page.getUrl().get();
			// System.out.println("抓取的内容："+name );
			// System.out.println("作者："+author );
			// System.out.println("类型："+type );
			// System.out.println("来源："+origin );
			// System.out.println("简述："+sketch );
			// System.out.println("链接："+url );
			try {
				if (name != null && author != null && origin != null && sketch != null && type2 != null && url != null)
					blist.input(name, author, origin, sketch, type2, url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++;
			System.out.println("已爬取数量：" + count);
		}
	}
	return count;
}
}
