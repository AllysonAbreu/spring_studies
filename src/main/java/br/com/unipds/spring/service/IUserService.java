package br.com.unipds.spring.service;

import br.com.unipds.spring.dto.UserDTO;
import br.com.unipds.spring.model.User;

public interface IUserService {
    User addUser(UserDTO user);
    User getByUsername(String username);
}
