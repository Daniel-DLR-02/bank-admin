package com.solera.bank.service;

import com.solera.bank.model.UserAccount;
import com.solera.bank.model.dto.CreateUserAccountDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserAccountService {

    public UserAccount getById(UUID id);

    public UserAccount editUser(UUID id, CreateUserAccountDto userToEdit);

    public UserAccount login(String username,String password);

    public List<UserAccount> getAll();

    public void deleteAccount(UUID id);

    public UserAccount save(UserAccount userAccount);


}
