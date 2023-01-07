package com.example.cqrs_project.command.service;

import com.example.cqrs_project.command.events.AccountCreatedEvent;
import com.example.cqrs_project.command.events.AccountActivatedEvent;
import com.example.cqrs_project.command.events.AccountCreditedEvent;
import com.example.cqrs_project.command.events.AccountDebitedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import com.example.cqrs_project.common.Repository.AccountRepository;
import com.example.cqrs_project.common.Model.Account;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HandleEvents {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HandleEvents.class);
	
	private final AccountRepository accountRepository;

    public HandleEvents(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    @EventHandler
    public void on(AccountCreatedEvent accountCreatedEvent) {
        log.info("Handling AccountCreatedEvent...");
        Account account = new Account();
        account.setAccountID(accountCreatedEvent.getId());
        account.setBalance(accountCreatedEvent.getBalance());
        account.setStatus("CREATED");

        accountRepository.save(account);
    }
    
    @EventHandler
    public void on(AccountActivatedEvent accountActivatedEvent) {
        log.info("Handling AccountActivatedEvent...");
        Account account = accountRepository.findById(accountActivatedEvent.getId()).orElse(null);

        if (account != null) {
            account.setStatus(accountActivatedEvent.getStatus());
            accountRepository.save(account);
        }
    }
    
    @EventHandler
    public void on(AccountCreditedEvent accountCreditedEvent) {
        log.info("Handling AccountCreditedEvent...");
        Account account = accountRepository
                .findById(accountCreditedEvent.getId()).orElse(null);

        if (account != null) {
            account.setBalance(account.getBalance()
                    .add(accountCreditedEvent.getAmount()));
        }
    }
    @EventHandler
    public void on(AccountDebitedEvent accountDebitedEvent) {
        log.info("Handling AccountDebitedEvent...");
        Account account = accountRepository
                .findById(accountDebitedEvent.getId()).orElse(null);

        if (account != null) {
            account.setBalance(account.getBalance()
                    .subtract(accountDebitedEvent.getAmount()));
        }
    }


}
