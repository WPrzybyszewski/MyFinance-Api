package com.wp.myfinance.Transaction;

import com.wp.myfinance.Transaction.Repository.TransactionRepository;
import com.wp.myfinance.Transaction.model.AbstractTransaction;
import com.wp.myfinance.Transaction.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(AbstractTransaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(AbstractTransaction transaction) {
        transactionRepository.delete(transaction);
    }

    @Override
    public void updateTransaction(AbstractTransaction transaction) {
        transactionRepository.save(transaction);
    }
}
