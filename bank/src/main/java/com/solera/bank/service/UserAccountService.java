package com.solera.bank.service;

import com.solera.bank.model.UserAccount;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountService {

    public UserAccount getById(Long id);

    public UserAccount editUser(Long id,UserAccount userToEdit);

    public boolean login(String username,String password);

}
