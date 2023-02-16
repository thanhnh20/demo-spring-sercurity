package com.practice.practiceauthentication.service;

import com.practice.practiceauthentication.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    Account getAccountByUsername();
}
