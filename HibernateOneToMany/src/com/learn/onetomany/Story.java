package com.learn.onetomany;

public class Story {
	
	private int id;
	
	private String info;
	
	private Writer writer;
	
	public Story() {}

	public Story(String info) {
		super();
		this.info = info;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", info=" + info + "]";
	}
	
	
}
