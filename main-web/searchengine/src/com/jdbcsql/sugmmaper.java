package com.jdbcsql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.target.HURL;
import com.target.book;
import com.target.hword;
import com.target.sugmess;

public class sugmmaper implements RowMapper<sugmess>{

	@Override
	public sugmess mapRow(ResultSet rs, int rowNum) throws SQLException {
		sugmess bo=new sugmess(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5));
		bo.setCon(rs.getInt(4));
		// TODO Auto-generated method stub
		return bo;
	}

}
