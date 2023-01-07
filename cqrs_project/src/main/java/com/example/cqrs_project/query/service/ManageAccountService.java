package com.example.cqrs_project.query.service;

import com.example.cqrs_project.query.query.FindAccountByIdQuery;
import lombok.extern.slf4j.Slf4j;
import com.example.cqrs_project.common.Model.Account;
import com.example.cqrs_project.common.Repository.AccountRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManageAccountService {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ManageAccountService.class);
	
    private final AccountRepository accountRepository;

    public ManageAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @QueryHandler
    public Account handle(FindAccountByIdQuery query) {
        log.info("Handling FindAccountByIdQuery...");
        Account account = accountRepository
                .findById(query.getAccountId()).orElse(null);

        return account;
    }

}
