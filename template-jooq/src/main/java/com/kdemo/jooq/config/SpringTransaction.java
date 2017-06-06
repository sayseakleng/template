package com.kdemo.jooq.config;

import org.jooq.Transaction;
import org.springframework.transaction.TransactionStatus;

public class SpringTransaction implements Transaction {
    
	final TransactionStatus transactionStatus;

    SpringTransaction(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
}
