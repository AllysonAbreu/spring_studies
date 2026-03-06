package br.com.unipds.spring.controller;

import br.com.unipds.spring.dto.MyToken;
import br.com.unipds.spring.dto.UserLoginDTO;
import br.com.unipds.spring.model.UserD;
import br.com.unipds.spring.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<UserD> addUSer(
            @RequestBody UserLoginDTO dto
    ) {
        return ResponseEntity.status(201).body(service.addUser(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<MyToken> loging(
            @RequestBody UserLoginDTO dto
    ) {
     return ResponseEntity.ok(service.userLogin(dto));
    }
}
