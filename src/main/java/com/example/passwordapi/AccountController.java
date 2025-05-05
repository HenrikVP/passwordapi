package com.example.passwordapi;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    AccountRepository repo;

    public AccountController(AccountRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id) {
        return repo.findById(id).get();
    }

    @GetMapping
    List<Account> getAccounts(){
        return repo.findAll() ;
    }

    @PostMapping()
    int createAccount(@RequestBody Account account){
        if (account==null){return -1;}
        repo.save(account);
        return account.getId();
    }

    @PutMapping
    void updateAccount(@RequestBody Account account){
        repo.save(account);
    }

    @DeleteMapping("/{id}")
    void deleteAccount(@PathVariable int id){
        repo.deleteById(id);
    }

    @DeleteMapping("")
    void deleteAccount(@RequestBody Account account){
        repo.delete(account);
    }
}