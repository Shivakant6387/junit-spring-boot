package com.example.microservicesaccounts.service;

import com.example.microservicesaccounts.model.Accounts;
import com.example.microservicesaccounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsServices {
    @Autowired
    private AccountsRepository accountsRepository;
    @GetMapping("/accounts")

    public List<Accounts> getAllAccounts(){
        return accountsRepository.findAll();
    }
    public Accounts createAccounts (Accounts accounts){
        return accountsRepository.save(accounts);
    }
    public Optional<Accounts> findById(Integer id){
        return accountsRepository.findById(id);
    }
    public Accounts updateAccount(Accounts accounts){
        Optional<Accounts>accountsExiting=findById(accounts.getId());
        accountsExiting.isPresent();
        Accounts account=accountsExiting.get();
        account.setId(accounts.getId());
        account.setFirstName(accounts.getFirstName());
        account.setLastName(accounts.getLastName());
        account.setAccountNumber(accounts.getAccountNumber());
        account.setDistrict(accounts.getDistrict());
        account.setAddress(accounts.getAddress());
        account.setPhoneNumber(accounts.getPhoneNumber());
        account.setState(accounts.getState());
        return accountsRepository.save(account);
    }
    public void deleteAccount(Accounts accounts){
        accountsRepository.delete(accounts);
    }
}
