package com.solera.bank.repository;

import com.solera.bank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountRepos extends JpaRepository<BankAccount, UUID> {
}
