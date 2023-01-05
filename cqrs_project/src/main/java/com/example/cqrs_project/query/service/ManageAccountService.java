package com.example.cqrs_project.query.service;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import com.example.cqrs_project.common.event.AccountCreatedEvent;
import com.example.cqrs_project.query.entity.Account;
import com.example.cqrs_project.query.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManageAccountService {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ManageAccountService.class);


    private final AccountRepository accountRepository;

    public ManageAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @EventHandler
    public void on(AccountCreatedEvent accountCreatedEvent) {
        log.info("Handling AccountCreatedEvent...");
        Account account = new Account();
        account.setAccountId(accountCreatedEvent.getId());
        account.setBalance(accountCreatedEvent.getBalance());
        account.setStatus("CREATED");

        accountRepository.save(account);
    }

}
