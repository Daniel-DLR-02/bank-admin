package com.solera.bank.component;

import com.solera.bank.model.Transaction;
import com.solera.bank.model.UserAccount;
import com.solera.bank.model.dto.CreateTransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public Transaction createTransactionDtoToTransaction(CreateTransactionDto createTransactionDto, UserAccount userOrigin,
                                                         UserAccount userDestiny){
        return Transaction.builder()
                .money(createTransactionDto.getMoney())
                .userOrigin(userOrigin)
                .userDestiny(userDestiny)
                .build();
    }


}
