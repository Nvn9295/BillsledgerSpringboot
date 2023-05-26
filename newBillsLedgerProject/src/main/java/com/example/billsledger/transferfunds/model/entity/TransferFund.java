package com.example.billsledger.transferfunds.model.entity;


import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "transfer_funds")
public class TransferFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transactionId;
    private String date;
    private String creditBank;
    private Double amount;
    private String beneficiaryBank;
    private String beneficiary;
}
