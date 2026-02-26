package br.com.unipds.spring.repository;

import br.com.unipds.spring.model.Conference;
import org.springframework.data.repository.ListCrudRepository;

public interface ConferenceRepository extends ListCrudRepository<Conference,Integer> {
}
