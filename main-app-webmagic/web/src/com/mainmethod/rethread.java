package com.mainmethod;

import test.Process;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import web.readbai;
import web.readintr;

public class rethread extends Thread  implements PageProcessor{
	int con=0;//0 off .1 wait. 2 on
	int time=3600;
	int max=1000;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private static int count =0;
    static readintr r=new  readbai();
    public rethread() {
    	
    }
    public Site getSite() {
        return site;
    }

    public void process(Page page) {
        //判断链接是否符合http://www.cnblogs.com/任意个数字字母-/p/7个数字.html格式
    	r.process(1,max, 139,  1, page);
    }
    @Override
	public  void run() {
		if(con!=0)
			return;
			try {
				con=1;
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=2;
			 Spider.create(new Process()).addUrl(r.getUrl()).thread(5).run();
			 while(true) {
				 try {
					Thread.sleep(5000);
					con=r.getCon();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 if(con==0) {
					 break;
				 }
			 }
			 this.run();
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public void setSite(Site site) {
		this.site = site;
	}

}
