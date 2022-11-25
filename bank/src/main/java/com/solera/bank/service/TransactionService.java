package com.solera.bank.service;

import com.solera.bank.model.Transaction;
import com.solera.bank.model.dto.CreateTransactionDto;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    public Transaction createTransaction(CreateTransactionDto createTransactionDto);


    public Transaction save(CreateTransactionDto createTransactionDto);

    public List<Transaction> getTransactionsFromUser(UUID idUser);

    public Transaction getOneTransaction(UUID id);
}
