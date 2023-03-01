package com.example.microservicesaccounts.controller;

import com.example.microservicesaccounts.model.Accounts;
import com.example.microservicesaccounts.service.AccountsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountsController {
    @Autowired
    private AccountsServices accountsServices;
    @GetMapping("accounts")
    public List<Accounts> getAllAccounts(){
        return accountsServices.getAllAccounts();
    }
    @PostMapping("/createAccounts")
    public Accounts createNewAccounts(@RequestBody Accounts accounts){
        return accountsServices.createAccounts(accounts);
    }
    @GetMapping("/accounts/{id}")
    public Optional<Accounts> findById(@PathVariable Integer id){
        return accountsServices.findById(id);
    }
    @PutMapping("/update")
    public Accounts updateAccount(@RequestBody Accounts accounts){
        return accountsServices.updateAccount(accounts);
    }
    @DeleteMapping("/accounts/{id}")
    public void deleteAccounts(Accounts accounts){
        accountsServices.deleteAccount(accounts);
    }
}
