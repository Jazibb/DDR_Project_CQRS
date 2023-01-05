package main.java.com.example.cqrs_project.command.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandService {

    private final CommandGateway commandGateway;

    public AccountCommandService(CommandGateway commandGateway){
        this.commandGateway =commandGateway;
    }

    public CompletableFuture<String> createAccount (CreateAccountRequest createAccountRequest){
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                createAccountRequest.getStartingBalance()
                ));

    }

    public CompletableFuture<String> depositToAccount (DepositRequest depositRequest){
        return commandGateway.send(new DepositeMoneyCommand(
                depositRequest.getAccountId(),
                depositRequest.getAmount()
        ));

    }

    public CompletableFuture<String> withdrawFromAccount (WithdrawalRequest withdrawalRequest){
        return commandGateway.send(new WithdrawalMoneyCommand(
                withdrawalRequest.getAccountId(),
                withdrawalRequest.getAmount()
        ));

    }
}
