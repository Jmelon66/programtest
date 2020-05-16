package com.jdbcsql;
import java.util.List;
import javax.sql.DataSource;

import com.target.HURL;
import com.target.book;
import com.target.hword;

public interface BookDao {
	   /** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the Student table.
	    */
	   public void create(String name,String author,String origin,String sketch,String type,String url);
	   /** 
	    * This is the method to be used to list down
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public book getBook(Integer id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public List<book> listBooks();
	   /** 
	    * This is the method to be used to delete
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public void delete(Integer id);
	   /** 
	    * This is the method to be used to update
	    * a record into the Student table.
	    */
	   public void update(Integer id, Integer age);
	List<book> listBooks(String s,int page, int limit);
	public int getcount(String s);
	List<HURL> listURL(String s,int page, int limit);
	int getcount(List<String> s);
	List<HURL> listURL(List<String> s, int page, int limit);
	List<hword> listWORD(String s, int type);
}
