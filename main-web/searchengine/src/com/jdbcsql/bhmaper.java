package com.jdbcsql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.target.HURL;
import com.target.banurl;
import com.target.book;
import com.target.hword;

public class bhmaper implements RowMapper<banurl>{

	@Override
	public banurl mapRow(ResultSet rs, int rowNum) throws SQLException {
		banurl bo=new banurl(rs.getString(2),rs.getString(3));
//		book b=new book(name, author, origin, sketch, type, url)
		// TODO Auto-generated method stub
		return bo;
	}

}
