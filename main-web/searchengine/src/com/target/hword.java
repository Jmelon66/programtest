package com.target;

import com.jdbcsql.Booksql;

public class hword {
	private String word;
	private int visittimes;
	private int rank;
	private int hot;
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public hword(String word,int rank) {
		this.word=word;
		this.rank=rank;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getVisittimes() {
		return visittimes;
	}
	public void setVisittimes(int visittimes) {
		this.visittimes = visittimes;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void save(Booksql sql) {
		sql.createhword(word);
	}
}
