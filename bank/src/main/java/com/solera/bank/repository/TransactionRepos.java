package com.solera.bank.repository;

import com.solera.bank.model.Transaction;
import com.solera.bank.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepos extends JpaRepository<Transaction, UUID> {
}
