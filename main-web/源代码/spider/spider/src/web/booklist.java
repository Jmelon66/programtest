package web;



import java.util.ArrayList;
import java.util.List;

import com.jdbcsql.Booksql;

public class booklist {
	private ArrayList<book> blist=new ArrayList<>();
	Booksql sql;
	public booklist(Booksql sql) {
	      this.sql=sql;
	}
	public void input(String name,String author,String origin,String sketch,String type,String url) {
		if(name!=null&&author!=null&&origin!=null&&sketch!=null&&type!=null&&url!=null) {
		if(!sketch.equals(null)) {
			sketch=sketch.trim();
		byte[] by=sketch.getBytes();
		if(by.length>299) {
			sketch=new String(by, 0, 299);
		}
		}
		else {
			sketch="无";
		}
		book b=new book(name, author, origin, sketch, type,url);
		blist.add(b);
		b.save(sql);
	}
	}
}
