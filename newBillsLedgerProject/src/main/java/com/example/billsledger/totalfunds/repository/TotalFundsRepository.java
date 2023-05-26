package com.example.billsledger.totalfunds.repository;

import com.example.billsledger.totalfunds.model.entity.TotalFunds;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TotalFundsRepository extends JpaRepository<TotalFunds, Long> {

    @Query("SELECT e FROM TotalFunds e ORDER BY e.id DESC")
    List<TotalFunds> findLastValue(Pageable pageable);

    @Query("SELECT e FROM TotalFunds e WHERE e.source = :source ORDER BY e.id DESC")
    List<TotalFunds> findLastSource(@Param("source") String source);


}
