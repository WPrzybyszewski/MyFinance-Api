package com.wp.myfinance.Transaction.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Transaction")
public class StandardTransaction  implements Transaction{
}
