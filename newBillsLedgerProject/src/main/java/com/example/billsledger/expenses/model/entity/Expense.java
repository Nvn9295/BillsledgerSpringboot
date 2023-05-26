package com.example.billsledger.expenses.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String transactionDetails;
    private Double amount;
    private String expensesCategory;
    private String source;
    private String spentBy;
    private Long billReceipt;
}
