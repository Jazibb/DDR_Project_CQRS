package com.example.cqrs_project.command.events;

public class AccountActivatedEvent extends BaseEvent<String>{
	
	private final String status;
	
	public AccountActivatedEvent(String id, String status){
		super(id);
		this.status = status;
		
	}
	
	public String getStatus() { return status; }

}
