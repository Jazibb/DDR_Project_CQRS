package com.example.cqrs_project.command.events;

import java.math.BigDecimal;


public class AccountCreatedEvent extends BaseEvent<String>{
	
	private final BigDecimal balance;
	
	public AccountCreatedEvent(String id, BigDecimal balance){
		super(id);
		this.balance = balance;
		
	}
	
	public BigDecimal getBalance() { return balance; }


}