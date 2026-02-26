package br.com.unipds.spring.service;

import br.com.unipds.spring.model.User;

import java.util.List;

public interface IUserService {
    User addUser(User user);
    User getUserById(Integer id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
