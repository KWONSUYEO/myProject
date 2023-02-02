package com.kwon.mini.community;

public class CommunitySelector {
	private String search;
	private int start;
	private int end;
	public CommunitySelector() {
		// TODO Auto-generated constructor stub
	}
	public CommunitySelector(String search, int start, int end) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
