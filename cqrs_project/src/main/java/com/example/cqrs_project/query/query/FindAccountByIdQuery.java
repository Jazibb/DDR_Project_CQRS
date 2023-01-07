package com.example.cqrs_project.query.query;

import lombok.Data;

@Data
public class FindAccountByIdQuery {
	private String accountId;
	
	public FindAccountByIdQuery(String accountId) { this.accountId = accountId; }

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	

}
