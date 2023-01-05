package com.example.cqrs_project.command.command;

import java.math.BigDecimal;

public class DepositeMoneyCommand extends BaseCommand<String> {

    private final BigDecimal amount;

    public DepositeMoneyCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}