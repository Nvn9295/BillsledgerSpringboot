package com.example.billsledger.loginusers.repository;

import com.example.billsledger.loginusers.model.entity.LoginUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUsersRepository extends JpaRepository<LoginUsers, Long> {
    LoginUsers findByUserName(String userName);
    LoginUsers findByEmail(String emailId);
}
