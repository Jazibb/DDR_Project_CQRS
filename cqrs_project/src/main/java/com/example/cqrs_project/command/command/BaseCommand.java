package com.example.cqrs_project.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand<T> {
	private final T id;
	
	public BaseCommand(T id) { this.id = id; }
	
	public T getId() { return id; }
}
