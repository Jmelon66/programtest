package web;

import com.jdbcsql.Booksql;

public class book {
	private String name;
	private String author;
	private String origin;
	private String sketch;
	private String type;
	private String url;
	public book(String name,String author,String origin,String sketch,String type,String url) {
		this.name=name;
		this.author=author;
		this.origin=origin;
		this.sketch=sketch;
		this.type=type;
		this.url=url;
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
	public String getAuthor() {
		return author;
	}
	public String getOrigin() {
		return origin;
	}
	public String getSketch() {
		return sketch;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public void setSketch(String sketch) {
		this.sketch = sketch;
	}
	public void save(Booksql sql) {
		sql.create(name, author, origin, sketch, type, url);
	}
}
