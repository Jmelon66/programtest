package com.target;

import com.jdbcsql.Booksql;

public class banurl {
	private String url;
	private String reason;
	public banurl(String url,String reason) {
		this.url=url;
		this.reason=reason;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void save(Booksql sql) {
		sql.createban(url,reason);
	}
}
