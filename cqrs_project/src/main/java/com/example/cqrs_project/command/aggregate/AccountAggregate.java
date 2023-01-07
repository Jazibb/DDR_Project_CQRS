package com.example.cqrs_project.command.aggregate;

import lombok.extern.slf4j.Slf4j;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.cqrs_project.command.command.CreateAccountCommand;
import com.example.cqrs_project.command.command.DepositeMoneyCommand;
import com.example.cqrs_project.command.command.WithdrawMoneyCommand;
import com.example.cqrs_project.common.event.AccountActivatedEvent;
import com.example.cqrs_project.common.event.AccountCreatedEvent;
import com.example.cqrs_project.common.event.AccountCreditedEvent;
import com.example.cqrs_project.common.event.AccountDebitedEvent;

import java.math.BigDecimal;

@Aggregate
@Slf4j
public class AccountAggregate {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AccountAggregate.class);

	@AggregateIdentifier
	private String accountId;
	private BigDecimal balance;
	@SuppressWarnings("unused")
	private String status;
	
	public AccountAggregate() {
		
	}

	@CommandHandler
	public AccountAggregate(CreateAccountCommand createAccountCommand ){
		log.info("CreateAccountCommand received.");

		AggregateLifecycle.apply (new AccountCreatedEvent(
				createAccountCommand.getId(),
				createAccountCommand.getBalance()
		));
	}

	@EventSourcingHandler
	public void on(AccountCreatedEvent accountCreatedEvent){
		log.info("An AccountCreatedEvent occured.");
		this.accountId = accountCreatedEvent.getId();
		this.balance = accountCreatedEvent.getBalance();
		this.status = "CREATED";

		AggregateLifecycle.apply(new AccountActivatedEvent(
				this.accountId,
				"ACTIVATED"
		));
	}
	@EventSourcingHandler
	public void on(AccountActivatedEvent accountActivatedEvent){
		log.info("An AccountActivatedEvent occured.");
		this.status = accountActivatedEvent.getStatus();


	}

	@CommandHandler
	public void on(DepositeMoneyCommand depositMoneyCommand){
		log.info("DepositMoneyCommand received.");
		AggregateLifecycle.apply(new AccountCreditedEvent(
				depositMoneyCommand.getId(),
				depositMoneyCommand.getAmount()
		));
	}

	@EventSourcingHandler
	public void on(AccountCreditedEvent accountCreditedEvent){
		log.info("AccountCreditedEvent occured.");
		this.balance = this.balance.add(accountCreditedEvent.getAmount());
	}


	@CommandHandler
	public void on(WithdrawMoneyCommand withdrawMoneyCommand){
		log.info("WithdrawMoneyCommand received.");
		AggregateLifecycle.apply(new AccountDebitedEvent(
				withdrawMoneyCommand.getId(),
				withdrawMoneyCommand.getAmount()
		));
	}

	@EventSourcingHandler
	public void on(AccountDebitedEvent accountDebitedEvent){
		log.info("AccountDebitedEvent occured.");
		this.balance = this.balance.add(accountDebitedEvent.getAmount());
	}
	}


