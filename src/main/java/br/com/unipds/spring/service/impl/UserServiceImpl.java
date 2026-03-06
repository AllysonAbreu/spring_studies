package br.com.unipds.spring.service.impl;

import br.com.unipds.spring.dto.MyToken;
import br.com.unipds.spring.dto.UserLoginDTO;
import br.com.unipds.spring.model.UserD;
import br.com.unipds.spring.repository.UserRepository;
import br.com.unipds.spring.security.TokenUtill;
import br.com.unipds.spring.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    private UserRepository repository;
    private BCryptPasswordEncoder encoder;


    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    @Transactional
    public UserD addUser(UserLoginDTO dto) {
        UserD user = new UserD();
        user.setUsername(dto.login());
        user.setPassword(encoder.encode(dto.password()));

        return repository.save(user);
    }

    @Override
    public UserD getByUsername(String username) {
        return null;
    }

    @Override
    public MyToken userLogin(UserLoginDTO dto) {
        UserD user = new UserD();
        user.setPassword(dto.password());
        user.setUsername(dto.login());

        UserD storedUser = repository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(encoder.matches(dto.password(), storedUser.getPassword()) ) {
            return TokenUtill.enconder(user);
        }

        throw new RuntimeException("Unauthorized user");
    }
}
