package com.example.cqrs_project.command.events;

public class BaseEvent<T> {
	private final T id;
	
	public BaseEvent(T id) {
		this.id = id;
	}
	
	public T getId( ) {
		return id;
	}
}
