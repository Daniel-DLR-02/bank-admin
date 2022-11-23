package com.solera.bank.service.impl;

import com.solera.bank.model.Transaction;
import com.solera.bank.model.UserAccount;
import com.solera.bank.model.dto.CreateTransactionDto;
import com.solera.bank.service.TransactionService;
import com.solera.bank.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final UserAccountService userAccountService;
    List<Transaction> mockTransactionDB = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Transaction t1 = Transaction.builder()
                .id(1L)
                .money("30")
                .userOrigin("Admin")
                .userDestiny("User2")
                .build();
        Transaction t2 = Transaction.builder()
                .id(2L)
                .money("30")
                .userOrigin("User2")
                .userDestiny("Admin")
                .build();
        Transaction t3 = Transaction.builder()
                .id(3L)
                .money("30")
                .userOrigin("Admin")
                .userDestiny("User2")
                .build();

        mockTransactionDB.add(t1);
        mockTransactionDB.add(t2);
        mockTransactionDB.add(t3);

    }


    @Override
    public Transaction createTransaction(CreateTransactionDto createTransactionDto) {
        Transaction userToAdd = Transaction.builder()
                .userOrigin(createTransactionDto.getUserOrigin())
                .userDestiny(createTransactionDto.getUserDestiny())
                .money(createTransactionDto.getMoney())
                .build();
        return userToAdd;
    }

    @Override
    public List<Transaction> getTransactionsFromUser(Long idUser) {
        UserAccount usuario = userAccountService.getById(idUser);
        List<Transaction> transactionsUser = mockTransactionDB.stream().filter(u -> u.getUserDestiny() == usuario.getUserName()).collect(Collectors.toList());
        return transactionsUser;
    }
}
