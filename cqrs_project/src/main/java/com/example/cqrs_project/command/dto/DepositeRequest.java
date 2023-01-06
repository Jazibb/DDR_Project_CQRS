package com.example.cqrs_project.command.dto;

import lombok.Data;
import java.math.BigDecimal;

public class DepositeRequest {
	private String accountId;
	private BigDecimal amount;
}
