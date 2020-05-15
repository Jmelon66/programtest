package web;

import com.jdbcsql.Booksql;

public class HURL {
	private String name;
	private String origin;
	private String sketch;
	private String url;
	private String time;
	public HURL(String name,String time,String origin,String sketch,String url) {
		this.name=name;
		this.origin=origin;
		this.sketch=sketch;
		this.url=url;
		this.time=time;
	}
	public String getTime() {
		return time;
	}
	public void getTime(String time) {
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public String getOrigin() {
		return origin;
	}
	public String getSketch() {
		return sketch;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public void setSketch(String sketch) {
		this.sketch = sketch;
	}
	public void save(Booksql sql) {
		sql.create2(name,origin,time, sketch,url);
	}
}
