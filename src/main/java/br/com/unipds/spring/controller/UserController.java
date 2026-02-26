package br.com.unipds.spring.controller;

import br.com.unipds.spring.model.User;
import br.com.unipds.spring.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(
            @RequestBody User user
    ) {
        return ResponseEntity.status(201).body(service.addUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(
            @RequestParam(name = "userId", required = false) Integer id,
            @RequestParam(name = "email", required = false) String email
    ) {
        if(StringUtils.isNotBlank(email)) {
            return ResponseEntity.ok(service.getUserByEmail(email));
        }

        return ResponseEntity.ok(service.getUserById(id));
    }

}
