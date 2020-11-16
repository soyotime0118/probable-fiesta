package com.mason.alpha.infra.config;

import com.atomikos.icatch.jta.UserTransactionManager;

public interface TransactionManagerFactory {
    UserTransactionManager makeTransactionManager();
}
