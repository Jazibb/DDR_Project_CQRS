package com.example.cqrs_project.command.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqrs_project.command.dto.CreateAccountRequest;
import com.example.cqrs_project.command.dto.DepositeRequest;
import com.example.cqrs_project.command.dto.WithdrawalRequest;

@RestController
@RequestMapping(value = "/bank-account")
public class BankAccountController {
	
	@PostMapping(value = "/create")
	public ResponseEntity<String> createAccount(@RequestBody CreateAccountRequest request) { return null; }
	
	@PutMapping(value = "/deposite")
	public ResponseEntity<String> deposite(@RequestBody DepositeRequest request) { return null; }
	
	@PutMapping(value = "/withdraw")
	public ResponseEntity<String> withdraw(@RequestBody WithdrawalRequest request) { return null; }
}
