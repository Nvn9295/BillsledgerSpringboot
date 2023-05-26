package com.example.billsledger.transferfunds.model.dto;


import lombok.Data;

@Data
public class TransferFundsDto {
    private int id;
    private String transactionId;
    private String date;
    private String creditBank;
    private Double amount;
    private String beneficiaryBank;
    private String beneficiary;
    private String message;

}
