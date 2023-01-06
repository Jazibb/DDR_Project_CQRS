package com.example.cqrs_project.command.controller;

import com.example.cqrs_project.command.dto.CreateAccountRequest;
import com.example.cqrs_project.command.dto.DepositeRequest;
import com.example.cqrs_project.command.dto.WithdrawalRequest;
import main.java.com.example.cqrs_project.command.service.AccountCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bank-account")
public class BankAccountController {

	private final AccountCommandService accountCommandService;
	@PostMapping(value = "/create")
	public ResponseEntity<String> createAccount(@RequestBody CreateAccountRequest request) { return null; }
	
	@PutMapping(value = "/deposit")
	public ResponseEntity<String> deposit(@RequestBody DepositeRequest request) { return null; }
	
	@PutMapping(value = "/withdraw")
	public ResponseEntity<String> withdraw(@RequestBody WithdrawalRequest request) { return null; }
}
