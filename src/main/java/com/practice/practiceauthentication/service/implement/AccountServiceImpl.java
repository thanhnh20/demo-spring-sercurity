package com.practice.practiceauthentication.service.implement;

import com.practice.practiceauthentication.domain.Account;
import com.practice.practiceauthentication.repository.AccountRepository;
import com.practice.practiceauthentication.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.getAccountByUsername(username);
        if(account == null){
            log.error("Account not found in DB");
            throw new UsernameNotFoundException("Account not found in DB");
        }else {
            log.info("Account found in DB");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getRole()));
        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), authorities);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountByUsername() {
        return null;
    }


}
