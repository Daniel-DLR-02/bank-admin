package com.solera.bank.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solera.bank.model.UserAccount;
import com.solera.bank.repository.AccountRepos;
import com.solera.bank.repository.UserRepos;
import com.solera.bank.service.impl.UserAccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

public class UserAccountServiceTest {

    @InjectMocks
    private UserAccountServiceImpl userService;

    @Mock
    private AccountRepos accountRepos;

    @Mock
    private UserRepos userRepository;


    @BeforeEach
    void initTest(){

        UserAccount userTest_1 = UserAccount.builder()
                .userName("UsuarioPrueba1")
                .name("usuario")
                .lastName("test")
                .password("qwerty")
                .build();

    }

    @Test
    @DisplayName("GET user/{id}")
    void test_getUser_returnRequestedUser() throws Exception {

        assertEquals(usuarioPrueas);

    }


    @Test
    @DisplayName("POST user/add")
    void test_addUserSuccess() throws Exception {




    }


    @Test
    @DisplayName("PUT user/edit/{id}")
    void test_updateAlbumSuccess() throws Exception {



    }

    @Test
    @DisplayName("POST user/add")
    void test_addUserFail() throws Exception {


    }
}
