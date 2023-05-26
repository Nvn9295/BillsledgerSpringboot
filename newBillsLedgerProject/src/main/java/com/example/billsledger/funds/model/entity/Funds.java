package com.example.billsledger.funds.model.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "funds")
public class Funds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private String creditBy;
    private Double amount;
    private String comment;

}
