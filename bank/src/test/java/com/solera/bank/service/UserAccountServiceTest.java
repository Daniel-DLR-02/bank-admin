package com.solera.bank.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solera.bank.model.UserAccount;

import com.solera.bank.model.dto.CreateUserAccountDto;
import com.solera.bank.repository.UserAccountRepos;
import com.solera.bank.service.impl.UserAccountServiceImpl;
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
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserAccountServiceTest {

    @InjectMocks
    private UserAccountServiceImpl accountService;

    @Mock
    private UserAccountRepos mockRepository;

    public UserAccount userTest_1;
    public UserAccount userTest_2;

    public UserAccount userTest_1_edited;

    public CreateUserAccountDto userTest_1_edited_dto;


    @BeforeEach
    void initTest(){

        userTest_1 = UserAccount.builder()
                .userName("UsuarioPrueba1")
                .name("usuario")
                .lastName("test")
                .password("qwerty")
                .build();

        userTest_2 = UserAccount.builder()
                .userName("UsuarioPrueba2")
                .name("usuario2")
                .lastName("test2")
                .password("qwerty")
                .build();

        userTest_1_edited = UserAccount.builder()
                .id(userTest_1.getId())
                .userName("UsuarioPrueba1_edited")
                .name("usuario_edited")
                .lastName("test")
                .password("qwerty")
                .build();
        userTest_1_edited_dto = CreateUserAccountDto.builder()
                .userName("UsuarioPrueba1_edited")
                .name("usuario_edited")
                .lastName("test")
                .password("qwerty")
                .build();

    }

    @Test
    @DisplayName("Get user by id success")
    void test_getUser_returnRequestedUser() {
        when(mockRepository.findById(userTest_1.getId())).thenReturn(Optional.ofNullable(userTest_1));
        assertEquals(userTest_1,accountService.getById(userTest_1.getId()));
    }

    @Test
    @DisplayName("Get user by id")
    void test_getUser_throwsNotFound() {
        assertThrows(EntityNotFoundException.class,()->accountService.getById(any(UUID.class)));
    }

    @Test
    @DisplayName("Create user succes")
    void test_saveUser_success(){
        when(mockRepository.save(userTest_1)).thenReturn(userTest_1);
        assertEquals(userTest_1,accountService.save(userTest_1));
    }

    // Hay que añadir validación

    /*@Test
    @DisplayName("Create user fails")
    void test_saveUser_throwsException(){
        when(mockRepository.save(userTest_1)).thenReturn(userTest_1);
        assertEquals(userTest_1,accountService.save(""));
    }*/



    @Test
    @DisplayName("Edit user success.")
    void test_updateUser_success() throws Exception {
        when(mockRepository.findById(userTest_1.getId())).thenReturn(Optional.ofNullable(userTest_1_edited));
        when(mockRepository.save(userTest_1)).thenReturn(userTest_1);

        assertEquals(userTest_1_edited,accountService.editUser(userTest_1.getId(),userTest_1_edited_dto));
    }


    //Añadir token jwt
    /*
    @Test
    @DisplayName("POST user/login")
    void test_LoginSuccess() throws Exception {

        assertEquals(true,
                accountService.login("UsuarioPrueba1_edited","password"));

    }*/



}
