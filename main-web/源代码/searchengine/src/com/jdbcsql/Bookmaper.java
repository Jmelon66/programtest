package com.jdbcsql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.target.book;

public class Bookmaper implements RowMapper<book>{

	@Override
	public book mapRow(ResultSet rs, int rowNum) throws SQLException {
		book bo=new book(rs.getString(2), rs.getString(3), rs.getString(5),
				rs.getString(6), rs.getString(8), 
				rs.getString(4),rs.getInt(7));
		String s=rs.getString(3);
		if(s.length()>7) {
			bo.setAuthor(s.substring(0,6));
		System.out.println(s+" , "+bo.getAuthor());
		}
		bo.setVisittimes(rs.getInt("visittimes"));
//		book b=new book(name, author, origin, sketch, type, url)
		// TODO Auto-generated method stub
		return bo;
	}

}
