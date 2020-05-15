package com.manage.controll;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Finalmanager.finalmanager;

import web.processinir;

@Controller
public class manaController {
	@RequestMapping("/mana")
	public String renet(ModelMap model) {
		return "/mana/manage";
	}
	@RequestMapping("/swithtype")
	@ResponseBody
	   public void addclick(int type) {
		   int ty=type;
		   finalmanager.setPagetype(ty);
		   System.out.println(ty);
	   }
	
	@RequestMapping("/limitpage")
	@ResponseBody
	   public void limitpage(int num) {
		   System.out.println(num);
		   int ty=num;
		   finalmanager.setLimit(ty);
	   }
	@RequestMapping("/runstart")
	@ResponseBody
	   public void runstart(int SleepTime,
			   int RetryTimes,
				int CycleRetryTimes,
				int urltype,
				int Page,
				int maxcount) {
		System.out.println("启动爬虫");
		try {
			processinir p=finalmanager.getprocessFacade();
		p.init(SleepTime, RetryTimes, CycleRetryTimes, Page, urltype, maxcount);
		p.run();
		}
		catch(Exception e) {
			System.out.println("启动爬虫失败");
		}
		
	   }
}
