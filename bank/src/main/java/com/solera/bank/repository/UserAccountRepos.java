package com.solera.bank.repository;

import com.solera.bank.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAccountRepos extends JpaRepository<UserAccount, UUID> {

    UserAccount getByUserName(String username);
}
