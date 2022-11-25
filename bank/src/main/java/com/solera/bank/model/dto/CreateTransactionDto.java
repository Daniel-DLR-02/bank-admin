package com.solera.bank.model.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionDto {

    private UUID userOriginId;
    private UUID userDestinyId;
    private String money;

}
