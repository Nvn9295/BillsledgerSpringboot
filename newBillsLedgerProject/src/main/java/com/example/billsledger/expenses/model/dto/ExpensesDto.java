package com.example.billsledger.expenses.model.dto;


import lombok.Data;

@Data
public class ExpensesDto {
    private Long id;
    private String date;
    private String transactionDetails;
    private Double amount;
    private String expensesCategory;
    private String source;
    private String spentBy;
    private Long billReceipt;
    private String message;
}
