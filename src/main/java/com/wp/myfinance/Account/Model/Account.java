package com.wp.myfinance.Account.Model;

import com.wp.myfinance.Authorization.model.User;
import com.wp.myfinance.Transaction.model.AbstractTransaction;
import com.wp.myfinance.Transaction.model.Transaction;
import lombok.Data;

import java.util.List;

//@Data
public interface Account {

    List<AbstractTransaction> transactions = null;
    User user = null;





}
