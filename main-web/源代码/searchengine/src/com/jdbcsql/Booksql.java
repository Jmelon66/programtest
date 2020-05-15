package com.jdbcsql;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.target.book;

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
		int i=page*10-1;
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
	public void addclick(String url) {
		// TODO Auto-generated method stub
		String SQL ="update books set visittimes=visittimes+1 where url=\""
				+ url+"\"";
		jdbc.update(SQL);
	}
	public boolean isValid(String s) {
		// TODO Auto-generated method stub
		return false;
	}
}
