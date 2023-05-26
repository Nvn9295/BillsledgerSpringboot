package com.example.billsledger.beneficiary.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private Long number;
}
