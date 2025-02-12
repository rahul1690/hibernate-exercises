package com.learn.onetomany;

import java.util.Set;

public class Writer {

	private int id;
	
	private String name;
	
	private Set<Story> stories;
	
	public Writer() {
	}
	

	public Writer(String name) {
		super();
		this.name = name;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Story> getStories() {
		return stories;
	}

	public void setStories(Set<Story> stories) {
		this.stories = stories;
	}


	@Override
	public String toString() {
		return "Writer [id=" + id + ", name=" + name + ", stories=" + stories + "]";
	}
	
	
}
