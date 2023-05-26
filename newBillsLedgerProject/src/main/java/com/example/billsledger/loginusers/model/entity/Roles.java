package com.example.billsledger.loginusers.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roles;
}
