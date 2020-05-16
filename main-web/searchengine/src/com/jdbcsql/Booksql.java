package com.jdbcsql;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.keyop.searchdes;
import com.target.HURL;
import com.target.banurl;
import com.target.book;
import com.target.hword;
import com.target.sugmess;

public class Booksql implements BookDao{
	private JdbcTemplate jdbc;
	private DataSource data;
	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.data=ds;
		jdbc=new JdbcTemplate(ds);
	}
	@Override
	public void create(String name, String author, String origin, String sketch, String type, String url) {
		// TODO Auto-generated method stub
		
	}
	public void create2(String name, String origin,String time, String sketch, String url) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO `searchengine`.`htmlu`\r\n" + 
				"(" + 
				"`title`,\r\n" + 
				"`url`,\r\n" + 
				"`describtion`,\r\n" + 
				"`date`,\r\n" + 
				"`vtimes`,\r\n" + 
				"`origin`)\r\n" + 
				"VALUES\r\n" + 
				"(" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,?);"; 
		jdbc.update(SQL, name,url,sketch,time,"0",origin);
	}
	public void createhword(String word) {
		// TODO Auto-generated method stub
		String SQL="";
		SQL = SQL+"INSERT INTO `searchengine`.`htmlu`\r\n" + 
				"(" + 
				"`title`,\r\n" + 
				"`url`,\r\n" + 
				"`describtion`,\r\n" + 
				"`date`,\r\n" + 
				"`vtimes`,\r\n" + 
				"`origin`)\r\n" + 
				"VALUES\r\n" + 
				"(" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,?);"; 
		jdbc.update(SQL, word);
	}
	public void createban(String url,String reason) {
		// TODO Auto-generated method stub
		String SQL="";
		SQL = SQL+"INSERT INTO `searchengine`.`htmlban`\r\n" + 
				"(" + 
				"`origin`,\r\n" + 
				"`reason`)\r\n" + 
				"VALUES\r\n" + 
				"(" + 
				"?,\r\n" +
				"?);"; 
		jdbc.update(SQL, url,reason);
	}
	@Override
	public book getBook(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<book> listBooks() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<book> listBooks(String s,int page,int limit) {
		// TODO Auto-generated method stub
		s=s.replace("/", "").replace("\"","").replace("%","").trim();
		String c;
		String temp="'";
		String wtemp="";
		for(int i=0;i<s.length();i++) {
			c=String.valueOf(s.charAt(i));
			temp=temp+"%"+c;
		}
		String []att= {"name","author","sketch","type"};
		
		temp="select * from searchengine.books where concat(name,author,sketch) like "+temp+"%' "
				+ " and Bno\r\n" + 
				"not in(select Bno from taboo,books where concat(name,author,sketch) like concat('%',taboo.word,'%'))"
				+ " order by ";
		int num=-1;
		for(String tat: att) {
			num++;
			temp=temp+" case when "+tat+" like '"+s+"' then "+1+" else 2 end,";
			num++;
			temp=temp+" case when "+tat+" like '"+s+"%' then "+1+" else 2 end,";
			num++;
			temp=temp+" case when "+tat+" like '%"+s+"' then "+1+" else 2 end,";
			num++;
			temp=temp+" case when "+tat+" like '%"+s+"%' then "+1+" else 2 end,";
		}
		int i=(page-1)*10-1;
		if(i<0) {
			i=0;
		}
		temp=temp
				+ "Bno limit "+i+","+limit;
		String SQL =temp;
		System.out.println(SQL);
		List<book> bli=jdbc.query(SQL, new Bookmaper());
		return bli;
	}
	@Override
	public List<HURL> listURL(List<String> s,int page, int limit) {
		// TODO Auto-generated method stub
		String c = "";
		String temp="select * from searchengine.htmlu where concat(title,describtion) like '";
		String wtemp="";
		List<String> slist;
		for(String l:s) {
			l=l.replace("/", "/").replace("\"","\\").replace("%","\\%").trim();
			temp=temp+"%"+l;
			c=c+"%"+l;
			wtemp=wtemp+l;
		}
		String []att= {"title","describtion"};
		
		temp=temp+"%' "
				+ " and origin not in(select htmlban.origin from htmlban)"
				+ " order by ";
		int num=-1;
			temp=temp+"case when title like '%"+wtemp+"%' then 1 else 2 end,"
					+ "case when title like '%"+wtemp+"%' then 1 else 2 end,"
					+ "case when describtion like '%"+c+"%' then 1 else 2 end,"
					+ "case when describtion like '%"+c+"%' then 1 else 2 end,";
		int i=page*10-1;
		if(i<0) {
			i=0;
		}
		temp=temp
				+ "date limit "+i+","+limit;
		String SQL =temp;
		System.out.println(SQL+"\n----page----"+page);
		List<HURL> bli=jdbc.query(SQL, new HURLmaper());
		return bli;
	}
	public List<hword> listWORD(List<String> t,String s, int type) {
		// TODO Auto-generated method stub
		String SQL ="SELECT (@i:=@i+1) rank, word,snum,hot from hword ,(SELECT @i:=0) as rank ";
		int l=t.size();
		if(type==0) {
			SQL=SQL+"where (snum>0 and word!='"+s+"' and type=1) and ( ";
			int i=0;
			for(String temp : t) {
				i++;
			SQL=SQL+" word like '%"+temp+"%' ";
			if(i!=l)
				SQL=SQL+" or ";
			}
		}
		SQL=SQL+") order by snum desc ";
		SQL=SQL+"limit 0,10";
		
		List<hword> bli=jdbc.query(SQL, new hwordmaper());
		System.out.println(SQL);
		System.out.println(bli.size());
		return bli;
	}
	public List<hword> listWORD(String s,int type) {
		// TODO Auto-generated method stub
		
		String SQL ="SELECT (@i:=@i+1) rank, word,snum,hot from hword ,(SELECT @i:=0) as rank";
		if(s!=null&&type==0) {
			SQL=SQL+" where word like '%"+s+"%'";
		}
		
		else if(type==3) {
			SQL=SQL+" where type=2 ";
		}
		SQL=SQL+" order by hot desc ";
		if(type==2) {
			SQL=SQL+"limit 0,50";
		}
		else if(type==3){
			SQL=SQL+"limit 0,10";
		}
		List<hword> bli=jdbc.query(SQL, new hwordmaper());
		
		return bli;
	}
	public List<banurl> listbh() {
		// TODO Auto-generated method stub
		
		String SQL ="SELECT * from htmlban order by id desc";
		List<banurl> bli=jdbc.query(SQL, new bhmaper());
		return bli;
	}
	public List<sugmess> listsugm(int type) {
		// TODO Auto-generated method stub
		String SQL ="SELECT * from sugmess";
		if(type==0) {
			SQL=SQL+" where con=1 ";
		}
		else if(type==1) {
			SQL=SQL+" where con=0 ";
		}
		SQL=SQL+" order by time desc";
		
		List<sugmess> bli=jdbc.query(SQL, new sugmmaper());
		
		return bli;
	}
	@Override
	public int getcount(String s) {
		// TODO Auto-generated method stub
		s=s.replace("/", "").replace("\"","").replace("%","").trim();
		String c;
		String temp="'";
		String wtemp="";
		for(int i=0;i<s.length();i++) {
			c=String.valueOf(s.charAt(i));
			temp=temp+"%"+c;
		}
		String []att= {"name","author","sketch","type"};
		
		temp="select count(*) from searchengine.books where concat(name,author,sketch) like "+temp+"%'" + 
				" and Bno not in(select Bno from taboo,books where concat(name,author,sketch) like concat('%',taboo.word,'%'))";
		String SQL =temp;
		System.out.println(SQL);
		int i=jdbc.queryForObject(temp, Integer.class);
//		System.out.println(temp);
		return i;
	}
	@Override
	public int getcount(List<String> s) {
		// TODO Auto-generated method stub
		String c = "";
		String temp="select count(*) from searchengine.htmlu where concat(title,describtion) like '";
		String wtemp="";
		List<String> slist;
		for(String l:s) {
			l=l.replace("/", "/").replace("\"","\\").replace("%","\\%").trim();
			temp=temp+"%"+l;
			c=c+"%"+l;
		}
		String []att= {"title","describtion"};
		
		temp=temp+"%' "
				+ " and origin not in(select htmlban.origin from htmlban)";
		System.out.println(temp);
		int i=jdbc.queryForObject(temp, Integer.class);
//		System.out.println(temp);
		return i;
	}
	public void addclick(String url) {
		// TODO Auto-generated method stub
		String SQL ="update htmlu set vtimes=vtimes+1 where url=\""
				+ url+"\"";
//		jdbc.update(SQL);
		jdbc.execute(SQL);
	}
	public void searchkey(String SQL) {
		// TODO Auto-generated method stub
		System.out.print(SQL);
		jdbc.update(SQL);
	}
	public boolean isValid(String s) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<HURL> listURL(String s, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
