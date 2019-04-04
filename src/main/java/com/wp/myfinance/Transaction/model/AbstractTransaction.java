package com.wp.myfinance.Transaction.model;

import org.springframework.data.annotation.Id;

public abstract class AbstractTransaction {

    @Id
    public String id;

    String Title;


}
