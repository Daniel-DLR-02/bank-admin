package com.solera.bank.model.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionDto {

    private String userOrigin;
    private String userDestiny;
    private String money;

}
