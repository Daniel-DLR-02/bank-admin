package com.solera.bank.controller;

import com.solera.bank.model.Transaction;
import com.solera.bank.model.dto.CreateTransactionDto;
import com.solera.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionsController {
    private final TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Transaction>> getAllFromUser(@PathVariable UUID id){
        List<Transaction> transactions = transactionService.getTransactionsFromUser(id);
        if(transactions == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @PostMapping("/")
    public ResponseEntity<Transaction> getAllFromUser(@RequestBody CreateTransactionDto cto){
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction(cto));
    }
}
