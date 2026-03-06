package br.com.unipds.spring.repository;

import br.com.unipds.spring.model.UserD;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<UserD,Integer> {

    Optional<UserD> findByUsername(String username);
}
