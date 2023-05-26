package com.example.billsledger.totalfunds.model.dto;


import lombok.Data;

@Data
public class TotalFundsDto {
    private Long id;
    private Double expenses;
    private Double bankBalance;
    private Double walletBalance;
    private Double totalBalance;
    private String source;
}
