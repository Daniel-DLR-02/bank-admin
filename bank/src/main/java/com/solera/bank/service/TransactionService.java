package com.solera.bank.service;

import com.solera.bank.model.Transaction;
import com.solera.bank.model.dto.CreateTransactionDto;

import java.util.List;

public interface TransactionService {
    public Transaction createTransaction(CreateTransactionDto createTransactionDto);

    public List<Transaction> getTransactionsFromUser(Long idUser);

}
