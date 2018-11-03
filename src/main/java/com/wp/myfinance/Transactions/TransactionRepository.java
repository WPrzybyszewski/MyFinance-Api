package com.wp.myfinance.Transactions;

import com.wp.myfinance.Transactions.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TransactionRepository extends MongoRepository<Transaction,String> {
}
