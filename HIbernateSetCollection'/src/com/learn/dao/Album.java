package com.learn.dao;

import java.util.Set;

public class Album {
	
	private int id;
	
	private String name;
	
	private Set<String> pictures;

	public Album() {
		super();
	}


	public Album(String name) {
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


	public Set<String> getPictures() {
		return pictures;
	}


	public void setPictures(Set<String> pictures) {
		this.pictures = pictures;
	}
	
	

}
