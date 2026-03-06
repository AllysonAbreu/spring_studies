package br.com.unipds.spring.service;

import br.com.unipds.spring.dto.MyToken;
import br.com.unipds.spring.dto.UserLoginDTO;
import br.com.unipds.spring.model.UserD;

public interface IUserService {
    UserD addUser(UserLoginDTO user);
    UserD getByUsername(String username);
    MyToken userLogin(UserLoginDTO user);
}
