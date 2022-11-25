package com.solera.bank.service.impl;

import com.solera.bank.model.BankAccount;
import com.solera.bank.model.UserAccount;
import com.solera.bank.repository.BankAccountRepos;
import com.solera.bank.repository.UserAccountRepos;
import com.solera.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankAccountRepos bankAccountRepos;
    private final UserAccountRepos userAccountRepos;

    @Override
    public BankAccount findById(UUID id) {
        Optional<BankAccount> baSearched = bankAccountRepos.findById(id);
        if(baSearched.isPresent())
            return baSearched.get();
        else
            throw new EntityNotFoundException("Bank account not found");
    }

    @Override
    public List<BankAccount> getAccountsByUserId(UUID userId) {
        Optional<UserAccount> userAccount =  userAccountRepos.findById(userId);
        if(userAccount.isPresent())
            return userAccount.get().getBankAccounts();
        else
            throw new EntityNotFoundException("User account not found");
    }

    @Override
    public BankAccount save(BankAccount ba1) {
        return null;
    }
}
