package com.learn.manytomany;

import java.util.Set;

public class Speaker {

	private int id;
	private String speakerName;
	private Set<Event> events;
	
	public Speaker() {
		// TODO Auto-generated constructor stub
	}

	public Speaker(String speakerName) {
		super();
		this.speakerName = speakerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpeakerName() {
		return speakerName;
	}

	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
}
