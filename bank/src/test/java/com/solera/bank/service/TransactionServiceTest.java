package com.solera.bank.service;


import com.solera.bank.model.Role;
import com.solera.bank.model.Transaction;
import com.solera.bank.model.UserAccount;
import com.solera.bank.model.dto.CreateTransactionDto;
import com.solera.bank.repository.TransactionRepos;
import com.solera.bank.repository.UserAccountRepos;
import com.solera.bank.service.impl.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionRepos mockRepository;

    @Mock
    private UserAccountRepos mockUserRepository;

    private UserAccount user1;
    private UserAccount user2;
    private Transaction transaction1;
    private CreateTransactionDto createTransactionDto;

    @BeforeEach
    void initTest(){

        UserAccount user = new UserAccount();
        user.setRole(Role.ADMIN);

        UserAccount mockPrincipal = Mockito.mock(UserAccount.class);

        UserAccount user1 = UserAccount.builder().userName("user1").build();
        UserAccount user2 = UserAccount.builder().userName("user2").build();

        Transaction transaction1 = Transaction.builder().userOrigin(user1).userDestiny(user2).money("23€").build();
        createTransactionDto = CreateTransactionDto
                .builder()
                .userOriginId(user1.getId())
                .userDestinyId(user2.getId())
                .money("30")
                .build();


    }


    @Test
    @DisplayName("List all user transactions")
    void test_getAllTransactionsUser_returnAllTransactionOfUser() {
        when(mockRepository.findAll()).thenReturn((List<Transaction>) List.of(transaction1));
        when(mockUserRepository.findById(user1.getId())).thenReturn(Optional.ofNullable(user1));
        assertEquals(List.of(transaction1),transactionService.getTransactionsFromUser(transaction1.getId()));
    }

    @Test
    @DisplayName("Get a specific transactions")
    void test_getOneTransactions_returnSearchedTransaction() {
        when(mockUserRepository.save(user1)).thenReturn(user1);
        when(mockUserRepository.save(user2)).thenReturn(user2);
        when(mockRepository.save(transaction1)).thenReturn(transaction1);
        when(mockRepository.findById(transaction1.getId())).thenReturn(Optional.ofNullable(transaction1));
        assertEquals(transaction1,transactionService.getOneTransaction(transaction1.getId()));
    }

    @Test
    @DisplayName("Create new transaction.")
    void test_createTransaction_returnCreatedTransaction(){
        when(mockRepository.save(transaction1)).thenReturn(transaction1);

        assertEquals(transaction1,transactionService.save(createTransactionDto));
    }

    //Añadir validacion
    /*
    * Comprobar que un usuario no puede hacer una transaccion consigo mismo.
    *
    * */


}
