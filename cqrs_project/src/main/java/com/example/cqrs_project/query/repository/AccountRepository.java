package com.example.cqrs_project.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cqrs_project.query.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

}
