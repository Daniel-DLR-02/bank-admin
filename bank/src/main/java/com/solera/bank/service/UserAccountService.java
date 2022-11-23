package com.solera.bank.service;

import com.solera.bank.model.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserAccountService {

    public UserAccount getById(Long id);

    public UserAccount editUser(Long id,UserAccount userToEdit);

    public UserAccount login(String username,String password);

    public List<UserAccount> getAll();


    public void changeVisibility(Long id);


}
