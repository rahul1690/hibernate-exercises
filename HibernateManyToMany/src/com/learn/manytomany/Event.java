package com.learn.manytomany;

import java.util.Set;

public class Event {
	
	private int id;
	
	private String eventName;
	
	private Set<Speaker> speakers;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String eventName) {
		super();
		this.eventName = eventName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Set<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}
	
}
