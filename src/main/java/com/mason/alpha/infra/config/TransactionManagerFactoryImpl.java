package com.mason.alpha.infra.config;

import com.atomikos.icatch.jta.UserTransactionManager;

public class TransactionManagerFactoryImpl implements TransactionManagerFactory{

    @Override
    public UserTransactionManager makeTransactionManager() {
        return new UserTransactionManager();
    }

}
