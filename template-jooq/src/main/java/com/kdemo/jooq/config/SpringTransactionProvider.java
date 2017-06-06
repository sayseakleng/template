package com.kdemo.jooq.config;

import org.jooq.TransactionContext;
import org.jooq.TransactionProvider;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class SpringTransactionProvider implements TransactionProvider {

	// Based on the jOOQ-spring-example from https://github.com/jOOQ/jOOQ

	private final PlatformTransactionManager transactionManager;

	SpringTransactionProvider(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public void begin(TransactionContext context) {
		TransactionDefinition definition = new DefaultTransactionDefinition(
				TransactionDefinition.PROPAGATION_NESTED);
		TransactionStatus status = this.transactionManager.getTransaction(definition);
		context.transaction(new SpringTransaction(status));
	}

	@Override
	public void commit(TransactionContext ctx) {
		this.transactionManager.commit(getTransactionStatus(ctx));
	}

	@Override
	public void rollback(TransactionContext ctx) {
		this.transactionManager.rollback(getTransactionStatus(ctx));
	}

	private TransactionStatus getTransactionStatus(TransactionContext ctx) {
		SpringTransaction transaction = (SpringTransaction) ctx.transaction();
		return transaction.getTransactionStatus();
	}

}
