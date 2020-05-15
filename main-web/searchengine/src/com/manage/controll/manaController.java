package com.manage.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Finalmanager.finalmanager;
import com.target.banurl;
import com.target.book;
import com.target.hword;
import com.target.sugmess;

import web.processinir;

@Controller
public class manaController {
	@RequestMapping("/mana")
	public ModelAndView renet(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView view=new ModelAndView("/mana/manage");
		int d,m;
		try {
			processinir p = finalmanager.getprocessFacade();
			d=p.getthtime();
			m=p.getthmax();
		} catch (Exception e) {
			d=50;
			m=50;
		}
		view.addObject("delayTime",d);
		view.addObject("carrynum",m);
		return view;
	}

	@RequestMapping("/swithtype")
	@ResponseBody
	public void addclick(int type) {
		int ty = type;
		finalmanager.setPagetype(ty);
		System.out.println(ty);
	}

	@RequestMapping("/limitpage")
	@ResponseBody
	public void limitpage(int num) {
		System.out.println(num);
		int ty = num;
		finalmanager.setLimit(ty);
	}

	@RequestMapping("/runstart")
	@ResponseBody
	public String runstart(int SleepTime, int RetryTimes, int CycleRetryTimes, String url, int Page, int maxcount) {
		System.out.println("启动爬虫 maxcount");
		try {
			processinir p = finalmanager.getprocessFacade();
			p.init(url, SleepTime, RetryTimes, CycleRetryTimes, 1, Page, maxcount);
			p.run();
			return "success";
		} catch (Exception e) {
			System.out.println("启动爬虫失败");
			return "error";
		}

	}

	@RequestMapping("/spretry")
	@ResponseBody
	public String spretry(int RetryTimes, int maxcount) {
		try {
			processinir p = finalmanager.getprocessFacade();
			p.setthtime(RetryTimes);
			p.setthmax(maxcount);
			return "success save";
			
		} catch (Exception e) {
			System.out.println("启动爬虫失败");
			return "error save";
		}

	}
	@RequestMapping("/wordop")
	@ResponseBody
	public String wordop(String skey, int type) {
			List<hword> blist=finalmanager.gethword(skey, type);
//			   System.out.println(page+"  "+s+blist.get(1).getName());
			   String HTML="";
			   for (hword b : blist) {
				   HTML=HTML+"<tr><td>"+b.getRank()+"</td><td>"
						   +b.getWord()+"</td><td>"+b.getVisittimes()
						   		+ "</td><td>"+b.getHot()
						   		+ "</td><td><div class=\"glyphicon glyphicon-remove op-del\" title=\"删除\" onclick=\"opdeletekey(this)\">"
						   		+ "</div></td></tr>";
			   }
			return HTML;

	}
	@RequestMapping(value ="/hotrefresh",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String hotrefresh() {
			List<hword> blist=finalmanager.gethword(null,2);
			List<hword> blist2=finalmanager.gethword(null,3);
			   String HTML="";
			   String HTML1="1";
			   String HTML2="2";
			   for (hword b : blist) {
				   HTML1=HTML1+"<tr><td>"+b.getRank()+"</td><td>"
						   +b.getWord()+"</td><td>"+b.getVisittimes()
						   		+ "</td></td><td>"+b.getHot()+"</td></tr>";
			   }
			   for (hword b : blist2) {
				   HTML2=HTML2+"<tr><td>"+b.getRank()+"</td><td>"
						   +b.getWord()+"</td><td><div class='glyphicon glyphicon-pencil op-del' title='删除' onclick='oprehot(this)'>"
						   		+ "</td></tr>";
			   }
			   HTML="{\"f\":\""+HTML1+"\",\"s\":\""+HTML2+"\"}";
			   System.out.print(HTML);
			   return HTML;

	}
	@RequestMapping("/switchhot")
	@ResponseBody
	public String switchhot(String oldhot,String newhot) {
			String SQL="update hword set word='"+newhot+"' where word='"+oldhot+"'";
			finalmanager.addkey(SQL);
			return SQL;

	}
	@RequestMapping("/addban")
	@ResponseBody
	public String addban(String url,String reason) {
		if(!url.equals(null)&&!reason.equals("123")&&!reason.equals(null)){
			banurl t=new banurl(url, reason);
			finalmanager.sbh(t);
		}
		List<banurl> blist=finalmanager.getbh();
		   String HTML="";
		   for (banurl b : blist) {
			   HTML=HTML+"<tr><td>"+b.getUrl()+"</td><td>"
					   +b.getReason()+"</td><td><div class=\"glyphicon glyphicon-remove op-del\" title=\"删除\" onclick=\"delbanh(this)\"></div>"
					   		+ "</td></tr>";
		   }
		   return HTML;

	}
	@RequestMapping("/delbh")
	@ResponseBody
	public String delbh(String url,String reason) {
		String SQL="delete from htmlban where origin='"+url+"'";
		finalmanager.addkey(SQL);
		return SQL;

	}
	@RequestMapping("/opensug")
	@ResponseBody
	public String opensug(int type) {
		List<sugmess> blist=finalmanager.getsugm(type);
		   String HTML="";
		   for (sugmess b : blist) {
			   HTML=HTML+"<tr><td>"+b.getOrigin()+"</td><td>"
					   +b.getContent()+"</td><td>"+b.getTime()
					   		+ "</td><td><span class=\"glyphicon glyphicon-folder-open op-del\" title=\"具体\" onclick=\"toiinfo(this,"+b.getId()+")\"></span>";
			   if(b.getCon()==1) {
				   HTML=HTML+"<span class=\"glyphicon glyphicon-remove op-del\" title=\"删除\" onclick=\"delmes(this,"+b.getId()+")\"></span>";
			   }
			   HTML=HTML+ "</td></tr>";
		   }
		   return HTML;

	}
	@RequestMapping("/sugread")
	@ResponseBody
	public String sugread(int id) {
		String SQL="update sugmess set con= 1 where id='"+id+"'";
		finalmanager.addkey(SQL);
		return SQL;

	}
	@RequestMapping("/sugdel")
	@ResponseBody
	public String sugdel(int id) {
		String SQL="delete from sugmess where id='"+id+"'";
		finalmanager.addkey(SQL);
		return SQL;

	}
}
