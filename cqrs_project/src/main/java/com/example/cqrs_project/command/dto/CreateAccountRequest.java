package com.example.cqrs_project.command.dto;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateAccountRequest {
	private BigDecimal startingBalance;

	public BigDecimal getStartingBalance() {
		return startingBalance;
	}

	public void setStartingBalance(BigDecimal startingBalance) {
		this.startingBalance = startingBalance;
	}
}
