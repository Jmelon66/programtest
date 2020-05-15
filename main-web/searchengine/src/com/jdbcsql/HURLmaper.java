package com.jdbcsql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.target.HURL;
import com.target.book;

public class HURLmaper implements RowMapper<HURL>{

	@Override
	public HURL mapRow(ResultSet rs, int rowNum) throws SQLException {
		HURL bo=new HURL(rs.getString(2), rs.getString(6), rs.getString(8),
				rs.getString(4), rs.getString(3));
		bo.setVisittimes(Integer.parseInt(rs.getString("vtimes")));
//		book b=new book(name, author, origin, sketch, type, url)
		// TODO Auto-generated method stub
		return bo;
	}

}
