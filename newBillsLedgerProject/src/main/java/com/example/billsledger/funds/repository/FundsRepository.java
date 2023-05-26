package com.example.billsledger.funds.repository;

import com.example.billsledger.funds.model.entity.Funds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundsRepository extends JpaRepository<Funds, Long> {

}
