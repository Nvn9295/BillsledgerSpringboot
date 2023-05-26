package com.example.billsledger.transferfunds.repository;


import com.example.billsledger.transferfunds.model.entity.TransferFund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferFundRepository extends JpaRepository<TransferFund, String> {

}
