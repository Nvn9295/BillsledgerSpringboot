package com.example.billsledger.totalfunds.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "total_funds")
public class TotalFunds {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "expenses_amount")
    private Double expenses;
    @Column(name = "bank_balance")
    private Double bankBalance;
    @Column(name = "wallet_balance")
    private Double walletBalance;
    @Column(name = "total_balance")
    private Double totalBalance;
    private String source;

}
