package br.com.unipds.spring.repository;

import br.com.unipds.spring.model.Session;
import org.springframework.data.repository.ListCrudRepository;

public interface SessionRepository extends ListCrudRepository<Session,Integer> {
}
