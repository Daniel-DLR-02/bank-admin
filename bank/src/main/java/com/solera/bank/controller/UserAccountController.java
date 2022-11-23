package com.solera.bank.controller;

import com.solera.bank.model.UserAccount;
import com.solera.bank.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAccountController {

    UserAccountService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneUser(@RequestParam Long id){
        UserAccount userToReturn = userService.getById(id);
        if(userToReturn != null) {
            return ResponseEntity.ok(userToReturn);
        }
        else{
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }
}
