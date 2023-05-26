package com.example.billsledger.funds.model.dto;

import lombok.Data;


@Data
public class FundsDto {
    private Long id;
    private String source;
    private String creditBy;
    private Double amount;
    private String comment;
}
