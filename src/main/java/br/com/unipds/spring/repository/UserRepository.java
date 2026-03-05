package br.com.unipds.spring.repository;

import br.com.unipds.spring.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User,Integer> {

    Optional<User> findByUsername(String username);
}
