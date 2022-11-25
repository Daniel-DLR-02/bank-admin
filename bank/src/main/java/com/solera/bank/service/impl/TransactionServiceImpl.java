package com.solera.bank.service.impl;

import com.solera.bank.component.TransactionDtoConverter;
import com.solera.bank.model.Transaction;
import com.solera.bank.model.UserAccount;
import com.solera.bank.model.dto.CreateTransactionDto;
import com.solera.bank.repository.TransactionRepos;
import com.solera.bank.repository.UserAccountRepos;
import com.solera.bank.service.TransactionService;
import com.solera.bank.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepos transactionRepos;
    private final UserAccountRepos userAccountRepos;
    private final TransactionDtoConverter transactionDtoConverter;

    @Override
    public Transaction createTransaction(CreateTransactionDto createTransactionDto) {
        return Transaction.builder().build();
    }

    @Override
    public Transaction save(CreateTransactionDto createTransactionDto) {

        Optional<UserAccount> userOrigin = userAccountRepos.findById(createTransactionDto.getUserOriginId());
        Optional<UserAccount> userDestiny = userAccountRepos.findById(createTransactionDto.getUserDestinyId());

        if(userOrigin.isPresent() && userDestiny.isPresent())
            return transactionRepos.save(transactionDtoConverter.createTransactionDtoToTransaction(createTransactionDto,userOrigin.get(),userDestiny.get()));
        else
            throw new EntityNotFoundException("Id de usuario no encontrado.");

    }

    @Override
    public List<Transaction> getTransactionsFromUser(UUID idUser) {
        return new ArrayList<>();
    }

    @Override
    public Transaction getOneTransaction(UUID id) {
        Optional<Transaction> transaction = transactionRepos.findById(id);
        if(transaction.isPresent())
            return transaction.get();
        else
            throw new EntityNotFoundException("Transaction not found.");
    }
}
