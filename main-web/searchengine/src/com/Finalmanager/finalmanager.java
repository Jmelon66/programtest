package com.Finalmanager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbcsql.BookDao;
import com.jdbcsql.Booksql;
import com.target.HURL;
import com.target.banurl;
import com.target.book;
import com.target.booklist;
import com.target.hword;
import com.target.sugmess;

import web.processinir;

public class finalmanager {
	private static Booksql bsql;
	private static int pagetype=1;
	private static int limit=10;
	public static int getPagetype() {
		return pagetype;
	}
	public static void setPagetype(int pagetype) {
		finalmanager.pagetype = pagetype;
	}
	public static processinir getprocessFacade() {
		processinir p=null;
		try {
			p = (processinir) Naming.lookup("rmi://127.0.0.1:12/processFacade");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	public static Booksql getBsql() {
		return bsql;
	}
	public static void setBsql(Booksql bsql) {
		finalmanager.bsql = bsql;
	}
	public static int getLimit() {
		return limit;
	}
	public static void setLimit(int limit) {
		finalmanager.limit = limit;
	}

	public static int getmax(String s) {
		return bsql.getcount(s);
	}
	public static int getmax(List<String> s) {
		return bsql.getcount(s);
	}
	public static boolean getIsvalid(String s) {
		return bsql.isValid(s);
	}
	public static void addclick(String url) {
		bsql.addclick(url);
	}
	public static void addkey(String SQL) {
		bsql.searchkey(SQL);
	}
	public static void switchhot(String SQL) {
		bsql.searchkey(SQL);
	}
	public static void sbh(banurl bh) {
		bh.save(bsql);
	}
	public static List<book> getBooks(String s,int page) {
		List<book> bli=bsql.listBooks(s, page, limit);
		return bli;
	}
	public static List<HURL> getHURL(List<String> s,int page) {
		List<HURL> bli=bsql.listURL(s, page, limit);
		return bli;
	}
	public static List<hword> gethword(String s,int type) {
		List<hword> bli=bsql.listWORD(s,type);
		return bli;
	}
	public static List<banurl> getbh() {
		List<banurl> bli=bsql.listbh();
		return bli;
	}
	public static List<sugmess> getsugm(int type) {
		// TODO Auto-generated method stub
		List<sugmess> bli=bsql.listsugm(type);
		return bli;
	}
	public static List<hword> gethword(List<String> t,String s,int type) {
		// TODO Auto-generated method stub
		List<hword> bli=bsql.listWORD(t,s,type);
		return bli;
	}
}
