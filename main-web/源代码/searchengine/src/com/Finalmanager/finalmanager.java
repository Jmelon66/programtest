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
import com.target.book;
import com.target.booklist;

import web.processinir;

public class finalmanager {
	private static Booksql bsql;
	private static int pagetype=0;
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
	public static boolean getIsvalid(String s) {
		return bsql.isValid(s);
	}
	public static void addclick(String url) {
		bsql.addclick(url);
	}
	public static List<book> getBooks(String s,int page) {
		List<book> bli=bsql.listBooks(s, page, limit);
		return bli;
	}
}
