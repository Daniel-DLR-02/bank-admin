package com.solera.bank.controller;

import com.solera.bank.model.Transaction;
import com.solera.bank.model.dto.CreateTransactionDto;
import com.solera.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionsController {
    TransactionService transactionService;

    @GetMapping("/{id}")
    public List<Transaction> getAllFromUser(@PathVariable Long id){
        return transactionService.getTransactionsFromUser(id);
    }

    @PostMapping("/")
    public ResponseEntity<Transaction> getAllFromUser(@RequestBody CreateTransactionDto cto){
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction(cto));
    }
}
