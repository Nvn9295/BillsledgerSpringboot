package com.example.billsledger.banks.repository;

import com.example.billsledger.banks.model.entity.Banks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanksRepository extends JpaRepository<Banks, Long> {
    Banks findBanksByBankName(String name);
}
