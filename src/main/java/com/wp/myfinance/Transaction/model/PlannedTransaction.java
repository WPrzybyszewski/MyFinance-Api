package com.wp.myfinance.Transaction.model;


import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planned_transaction")

@JsonTypeName("planned_transaction")
public class PlannedTransaction  extends AbstractTransaction{
    String Plannedtst ;


    public String getPlannedtst() {
        return Plannedtst;
    }

    public void setPlannedtst(String plannedtst) {
        Plannedtst = plannedtst;
    }
}
