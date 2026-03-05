package br.com.unipds.spring.service.impl;

import br.com.unipds.spring.dto.UserDTO;
import br.com.unipds.spring.model.User;
import br.com.unipds.spring.service.IUserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {
    @Override
    public User addUser(UserDTO user) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }
}
