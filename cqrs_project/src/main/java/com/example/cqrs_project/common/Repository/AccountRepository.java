package com.example.cqrs_project.common.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cqrs_project.common.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

}