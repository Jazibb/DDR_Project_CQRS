package com.example.cqrs_project.command.aggregate;

import lombok.extern.Slf4j;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
@Slf4j
public class AccountAggregate {

	@AggregateIdentifier
	private String accountId;
	private BigDecimal balance;
	private String status;
	
	public AccountAggregate() {
		
	}

	@CommandHandler
	public AccountAggregate(CreateAccountCommand createAccountCommand ){
		log.info("CreateAccountCommand received.");

		AggregateLifecycle.apply (new AccountCreatedEvent)(
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
				status: "ACTIVATED"
		));
	}
	@EventSourcingHandler
	public void on(AccountActivatedEvent accountActivatedEvent){
		log.info("An AccountActivatedEvent occured.");
		this.status = accountActivatedEvent.getStatus();


	}

	@CommandHandler
	public void on(DepositMoneyCommand depositMoneyCommand){
		log.info("DepositMoneyCommand received.");
		AggreagteLifecycle.apply(new AccountCreditedEvent(
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
		AggreagteLifecycle.apply(new AccountDebitedEvent(
				withdrawMoneyCommand.getId(),
				withdrawMoneyCommand.getAmount()
		));
	}

	@EventSourcingHandler
	public void on(AccountDebitedEvent accountDebitedEvent{
		log.info("AccountDebitedEvent occured.");
		this.balance = this.balance.add(accountDebitedEvent.getAmount());
	}
	}


