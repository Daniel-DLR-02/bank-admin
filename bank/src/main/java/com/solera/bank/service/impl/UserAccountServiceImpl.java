package com.solera.bank.service.impl;

import com.solera.bank.model.UserAccount;
import com.solera.bank.model.dto.CreateUserAccountDto;
import com.solera.bank.repository.UserAccountRepos;
import com.solera.bank.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService, UserDetailsService {

    private final UserAccountRepos userAccountRepos;



    @Override
    public UserAccount getById(UUID id) {
        Optional<UserAccount> usuarioBuscado = userAccountRepos.findById(id);
        if(usuarioBuscado.isEmpty()){
            throw new EntityNotFoundException("User not found exception");
        }
        else{
            return usuarioBuscado.get();
        }
    }

    @Override
    public UserAccount editUser(UUID id, CreateUserAccountDto userToEdit) {

        UserAccount userAccount = getById(id);

        userAccount.setUserName(userToEdit.getUserName());
        userAccount.setName(userAccount.getName());
        userAccount.setLastName(userToEdit.getLastName());
        userAccount.setPassword(userAccount.getPassword());

        return userAccount;
    }

    @Override
    public UserAccount login(String username, String password) {
        return UserAccount.builder().build();
    }

    @Override
    public List<UserAccount> getAll() {
        return userAccountRepos.findAll();
    }

    @Override
    public void deleteAccount(UUID id) {
        userAccountRepos.deleteById(id);
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepos.save(userAccount);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountRepos.getByUserName(username);
    }
}
