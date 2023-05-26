package com.example.billsledger.beneficiary.repository;

import com.example.billsledger.beneficiary.model.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
    Beneficiary findByUserName(String userName);
    Beneficiary findByNumber(Long number);
}
