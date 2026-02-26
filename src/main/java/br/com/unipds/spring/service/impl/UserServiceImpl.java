package br.com.unipds.spring.service.impl;

import br.com.unipds.spring.exception.NotFoundException;
import br.com.unipds.spring.model.User;
import br.com.unipds.spring.repository.UserRepository;
import br.com.unipds.spring.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User %d not found", id)));
    }

    @Override
    public User getUserByEmail(String email) {
        return repository
                .findByEmail(email)
                .orElseThrow(() -> new NotFoundException(String.format("User email (%s) not found", email)));
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
