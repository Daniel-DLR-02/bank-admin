package com.solera.bank.service.impl;

import com.solera.bank.model.UserAccount;
import com.solera.bank.service.UserAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<UserAccount> requestedUser = new ArrayList<>();
        for(UserAccount u : mockUserDB)
            if(u.getId().equals(id))
                requestedUser.add(u);

        if (requestedUser.size() != 1) {
            return null;
        }
        else
            return requestedUser.get(0);
    }

    @Override
    public UserAccount editUser(Long id, UserAccount userToEdit) {
        return null;
    }

    @Override
    public UserAccount login(String username, String password) {
        List<UserAccount> requestedUser = new ArrayList<>();
        for(UserAccount u : mockUserDB)
            if(u.getUserName().equals(username))
                requestedUser.add(u);

        if (requestedUser.size() != 1) {
            return null;
        }
        else{
            if(requestedUser.get(0).getPassword().equals(password))
                return requestedUser.get(0);
            else
                return null;
        }
    }

    @Override
    public List<UserAccount> getAll() {
        return mockUserDB;
    }
}
