package com.solera.bank.model.dto;

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
public class EditUserDto {
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    @Builder.Default
    public boolean visible = true;
    @Builder.Default
    private List<String> bankAccounts = new ArrayList<>();
}
