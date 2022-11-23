package com.solera.bank.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {

    private Long id;
    private String userOrigin;
    private String userDestiny;
    private String money;
}
