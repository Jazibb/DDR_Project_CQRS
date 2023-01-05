package com.example.cqrs_project.command.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class DepositeRequest {
	private String accountId;
	private BigDecimal amount;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
