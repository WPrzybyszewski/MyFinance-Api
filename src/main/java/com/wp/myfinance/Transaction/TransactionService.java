package com.wp.myfinance.Transaction;


import com.wp.myfinance.Transaction.model.AbstractTransaction;
import com.wp.myfinance.Transaction.model.Transaction;

public interface TransactionService {

        void saveTransaction(AbstractTransaction transaction);
    void deleteTransaction(AbstractTransaction transaction);
    void updateTransaction(AbstractTransaction transaction);

}
