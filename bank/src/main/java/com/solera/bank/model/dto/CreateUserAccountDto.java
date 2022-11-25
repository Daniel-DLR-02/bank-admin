package com.solera.bank.model.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserAccountDto {

    private String name;

    private String lastName;

    private String userName;

    private String password;

}
