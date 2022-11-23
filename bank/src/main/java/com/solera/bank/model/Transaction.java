package com.solera.bank.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String userOrigin;
    private String userDestiny;
    private String money;
}
