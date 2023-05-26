package com.example.billsledger.expenses.repository;

import com.example.billsledger.expenses.model.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

}