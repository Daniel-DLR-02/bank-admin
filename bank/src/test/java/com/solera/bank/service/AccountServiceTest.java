package com.solera.bank.service;


import com.solera.bank.model.BankAccount;
import com.solera.bank.model.UserAccount;
import com.solera.bank.repository.BankAccountRepos;
import com.solera.bank.repository.UserAccountRepos;
import com.solera.bank.service.impl.BankServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountServiceTest {

    @InjectMocks
    private BankServiceImpl accountService;

    @Mock
    private BankAccountRepos mockRepository;

    @Mock
    private UserAccountRepos mockUserRepository;

    private BankAccount ba1;
    private BankAccount ba2;
    private UserAccount ua1;



    @BeforeEach
    void initTest(){
        ua1 = UserAccount.builder().build();

        ba1 = BankAccount.builder()
                .bankName("BBVA")
                .build();

        ba2 = BankAccount.builder()
                .bankName("ING")
                .build();

        ua1.setBankAccounts(List.of(ba1,ba2));
    }

    @Test
    @DisplayName("Search bank accounts by Id.")
    private void test_getUserBankAccountById_BankAccount(){
        when(mockRepository.findById(any(UUID.class))).thenReturn(Optional.of(ba1));
        assertEquals(ba1,accountService.findById(any(UUID.class)));
    }

    @Test
    @DisplayName("Search bank accounts by Id fails.")
    private void test_getUserBankAccountById_EntityNotFoundException(){
        when(mockRepository.findById(any(UUID.class))).thenReturn(Optional.of(ba1));
        assertThrows(EntityNotFoundException.class,()->accountService.findById(any(UUID.class)));
    }

    @Test
    @DisplayName("Search bank accounts from a user success.")
    private void test_getUserBankAccounts_returnUserBankAccounts(){
        when(mockUserRepository.findById(any(UUID.class))).thenReturn(Optional.of(ua1));
        assertEquals(ua1.getBankAccounts(),accountService.getAccountsByUserId(any(UUID.class)));
    }

    @Test
    @DisplayName("Create bank accounts.")
    private void test_createBankAccount_returnCreatedBankAccounts(){
        when(mockRepository.save(ba1)).thenReturn(ba1);
        assertEquals(ba1,accountService.save(ba1));
    }


}
