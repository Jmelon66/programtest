package web;

import us.codecraft.webmagic.Page;

public interface readintr {
	public int process(int count,int maxcount,int pag,int type,Page page) ;

	public String getUrl();
	public void setUrl(String url) ;
	public booklist getBlist();
	public void setBlist(booklist blist);
	public int getCon();
	public void setCon(int con);
	public void setMax(int maxcount);
}
