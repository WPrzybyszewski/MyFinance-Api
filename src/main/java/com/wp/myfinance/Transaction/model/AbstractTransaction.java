package com.wp.myfinance.Transaction.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;


import java.math.BigDecimal;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "classType")

@JsonSubTypes({
        @JsonSubTypes.Type(value = Transaction.class, name = "standard_transaction"),
        @JsonSubTypes.Type(value = PlannedTransaction.class, name = "planned_transaction")
})

public abstract class AbstractTransaction {

    public enum TransactionType
    {
        expenditure,income
    }
    @Id
    private String id = String.valueOf(UUID.randomUUID());

    String Title;

    TransactionCategory transactionCategory;
    TransactionType transactionType;
    String Note;

    BigDecimal amount;

    TransactionType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
