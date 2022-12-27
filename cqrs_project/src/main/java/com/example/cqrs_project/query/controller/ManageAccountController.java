package com.example.cqrs_project.query.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqrs_project.query.entity.Account;

@RestController
@RequestMapping(value = "/manage-account")
public class ManageAccountController {
	@GetMapping("/get-account")
	public ResponseEntity<Account> getAccount(@RequestParam String id) { return null; }
}
