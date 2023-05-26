package com.example.billsledger.loginusers.repository;

import com.example.billsledger.loginusers.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
