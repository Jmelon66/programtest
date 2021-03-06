package test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import web.readbai;
import web.readbai;
import web.readintr;
import web.readvisit;

public class Process implements PageProcessor {
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(13).setSleepTime(100).setCycleRetryTimes(15).setRetryTimes(10);
    private static int count =0;
    static readintr r=new readvisit();

    public Site getSite() {
        return site;
    }

    public void process(Page page) {
        //判断链接是否符合http://www.cnblogs.com/任意个数字字母-/p/7个数字.html格式
    	count=r.process(1,500, 139,  1, page);
    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            Spider.create(new Process()).addUrl(r.getUrl()).thread(5).run();
            try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+count+"条记录");
    }

}