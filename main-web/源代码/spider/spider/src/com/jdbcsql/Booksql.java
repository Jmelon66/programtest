package com.jdbcsql;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import web.book;

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
	public void create(String name, String author, String origin, String sketch, String type,String url) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO `searchengine`.`books`\r\n" + 
				"(" + 
				"`name`,\r\n" + 
				"`author`,\r\n" + 
				"`origin`,\r\n" + 
				"`sketch`,\r\n" + 
				"`type`,url)\r\n" + 
				"VALUES\r\n" + 
				"(" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,\r\n" + 
				"?,?);"; 
		jdbc.update(SQL, name,author,origin,sketch,type,url);
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
	
}
