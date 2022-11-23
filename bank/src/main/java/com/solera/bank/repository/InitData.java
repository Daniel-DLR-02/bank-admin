package com.solera.bank.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class InitData {

    @PostConstruct
    public void initData() {

    }

}