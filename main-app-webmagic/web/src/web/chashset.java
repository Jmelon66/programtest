package web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class chashset {
	Set<String> gurl = new HashSet<>();
	private String next;
	private String lastadd;
	public chashset() {
	}
	public boolean check(String url) {
		gurl.add(url);
		lastadd=gurl.iterator().next();
		next=gurl.iterator().next();
		return next!=url;
	}
	public String out() {
		return next;
	}
	public String getNext() {
		if(lastadd==next) {
			lastadd=null;
		    return next;
		}
		else {
			next=gurl.iterator().next();
			return next;
		}
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getLastadd() {
		return lastadd;
	}
	public void setLastadd(String lastadd) {
		this.lastadd = lastadd;
	}
}
