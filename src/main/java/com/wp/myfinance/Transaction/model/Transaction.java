package com.wp.myfinance.Transaction.model;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "transaction")
@JsonTypeName("standard_transaction")
public class Transaction extends  AbstractTransaction {

    int Test;

    public int getTest() {
        return Test;
    }

    public void setTest(int test) {
        Test = test;
    }
}
