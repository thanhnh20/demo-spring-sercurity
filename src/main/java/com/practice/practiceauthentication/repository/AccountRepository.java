package com.practice.practiceauthentication.repository;

import com.practice.practiceauthentication.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account getAccountByUsername(String username);
}
