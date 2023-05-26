package com.example.billsledger.banks.model.dto;

import lombok.Data;


@Data
public class BanksDto {
    private Long id;
    private String bankName;
    private String ifscCode;
    private  String message;
}
