package com.wp.myfinance.Transaction.Repository;


import com.wp.myfinance.Transaction.model.AbstractTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<AbstractTransaction,String> {


}
