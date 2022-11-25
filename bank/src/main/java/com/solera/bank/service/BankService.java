package com.solera.bank.service;

import com.solera.bank.model.BankAccount;

import java.util.List;
import java.util.UUID;

public interface BankService {

    public BankAccount findById(UUID id);

    public List<BankAccount> getAccountsByUserId(UUID userId);

    public BankAccount save(BankAccount ba1);
}
