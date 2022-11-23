package com.solera.bank.service.impl;

import com.solera.bank.model.UserAccount;
import com.solera.bank.service.UserAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    List<UserAccount> mockUserDB = new ArrayList<>();

    @PostConstruct
    public void initData() {
        UserAccount adminUser = UserAccount.builder()
                .id(1L)
                .name("Admin")
                .lastName("bank")
                .userName("solera@solera.com")
                .password("bootcamp4")
                .build();

        mockUserDB.add(adminUser);
    }

    @Override
    public UserAccount getById(Long id) {
        UserAccount requestedUser = mockUserDB.stream()
                .filter(searchUser -> searchUser.getId() == id)
                .reduce((a, b) -> {
                    throw new IllegalStateException("Two elements with same id: " + a + ", " + b);
                })
                .get();
        return null;
    }

    @Override
    public UserAccount editUser(Long id, UserAccount userToEdit) {
        return null;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }
}
