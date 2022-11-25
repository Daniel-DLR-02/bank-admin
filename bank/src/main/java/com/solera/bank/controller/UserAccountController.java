package com.solera.bank.controller;

import com.solera.bank.model.UserAccount;
import com.solera.bank.model.dto.CreateUserAccountDto;
import com.solera.bank.model.dto.LoginDto;
import com.solera.bank.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneUser(@PathVariable UUID id){
        Optional<UserAccount> userToReturn = Optional.ofNullable(userService.getById(id));
        if(userToReturn == null || userToReturn.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.ok(userToReturn);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAccount>> getAll(){
        return ResponseEntity.ok(userService.getAll());

    }

    @PostMapping("/login")
    public ResponseEntity<UserAccount> login(@RequestBody LoginDto login){
        Optional<UserAccount> userToLogin = Optional.ofNullable(userService.login(login.getUsername(), login.getPassword()));
        if(userToLogin == null || userToLogin.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        else{
            return ResponseEntity.ok(userToLogin.get());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccount> editUser(@PathVariable UUID id,@RequestBody CreateUserAccountDto userData){
        Optional<UserAccount> userToEdit = Optional.ofNullable(userService.editUser(id, userData));
        if(userToEdit == null || userToEdit.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.ok(userToEdit.get());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> disableUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
