package com.wp.myfinance.Transaction.Controller;

import com.wp.myfinance.Transaction.TransactionService;
import com.wp.myfinance.Transaction.model.AbstractTransaction;
import com.wp.myfinance.Transaction.model.PlannedTransaction;
import com.wp.myfinance.Transaction.model.Transaction;
import com.wp.myfinance.Transaction.model.TransactionCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/addTransaction")
    public ResponseEntity addTransaction(@RequestBody AbstractTransaction transaction)
    {
        transactionService.saveTransaction(transaction);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/testTransaction")
    public ResponseEntity <AbstractTransaction>testTransaction()
    {
        PlannedTransaction transaction = new PlannedTransaction();

        transaction.setTitle("test");
        transaction.setTransactionType(AbstractTransaction.TransactionType.expenditure);
        transactionService.saveTransaction(transaction);
        transaction.setNote("test Note");
        transaction.setAmount(new BigDecimal(66.66));
        transaction.setPlannedtst("PlannedTransaction");

        return new ResponseEntity(transaction,HttpStatus.OK);
    }

    @PostMapping("/getAllTransactions")
    public ResponseEntity<List<Transaction>> getAllTransactions(@RequestBody AbstractTransaction transaction)
    {


            return  null;
    }

}
