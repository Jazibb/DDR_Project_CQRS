package com.example.cqrs_project.command.events;

import java.math.BigDecimal;


public class AccountCreditedEvent extends BaseEvent<String>{
	
	private final BigDecimal amount;
	
	public AccountCreditedEvent(String id, BigDecimal amount){
		super(id);
		this.amount = amount;
		
	}
	
	public BigDecimal getAmount() { return amount; }


}