package com.solera.bank.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private boolean visibility;
    @Builder.Default
    private List<String> bankAccounts = new ArrayList<>();


    public void toggleVisibility(){
        this.visibility=!this.visibility;
    }
}


