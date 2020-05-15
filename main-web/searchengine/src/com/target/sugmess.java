package com.target;

import com.jdbcsql.Booksql;

public class sugmess {
	private String content;
	private String origin;
	private String time;
	private int id;
	private int con;
	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public sugmess(int id,String content,String origin,String time) {
		this.content=content;
		this.origin=origin;
		this.time=time;
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void save(Booksql sql) {
	}
}
