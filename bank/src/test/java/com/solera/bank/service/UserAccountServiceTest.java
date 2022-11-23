package com.solera.bank.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solera.bank.model.UserAccount;

import com.solera.bank.service.impl.UserAccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAccountServiceTest {

    @InjectMocks
    private UserAccountServiceImpl accountService;

    public UserAccount userTest_1;
    public UserAccount userTest_1_edited;
    @BeforeEach
    void initTest(){

        userTest_1 = UserAccount.builder()
                .id(1L)
                .userName("UsuarioPrueba1")
                .name("usuario")
                .lastName("test")
                .password("qwerty")
                .build();

        userTest_1_edited = UserAccount.builder()
                .id(1L)
                .userName("UsuarioPrueba1_edited")
                .name("usuario_edited")
                .lastName("test")
                .password("qwerty")
                .build();

    }

    @Test
    @DisplayName("GET user/{id}")
    void test_getUser_returnRequestedUser() throws Exception {

        assertEquals(userTest_1,accountService.getById(1L));

    }


    //Testeable al añadir la base de datos
    /*@Test
    @DisplayName("POST user/add")
    void test_addUserSuccess() throws Exception {



    }*/


    @Test
    @DisplayName("PUT user/edit/{id}")
    void test_updateUserSuccess() throws Exception {

        assertEquals(userTest_1_edited,
                accountService.editUser(1L,new UserAccount().builder()
                        .id(1L)
                        .userName("UsuarioPrueba1_edited")
                        .name("usuario_edited")
                        .lastName("test")
                        .password("qwerty")
                        .build()));

    }

    @Test
    @DisplayName("POST user/login")
    void test_LoginSuccess() throws Exception {

        assertEquals(true,
                accountService.login("UsuarioPrueba1_edited","password"));

    }


    //Testeable con la base de datos.
    /*@Test
    @DisplayName("POST user/add")
    void test_addUserFail() throws Exception {


    }*/
}
