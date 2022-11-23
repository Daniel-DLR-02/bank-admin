package com.solera.bank.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    private Long id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    @Builder.Default
    private List<String> bankAccounts = new ArrayList<>();
}
