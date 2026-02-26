package br.com.unipds.spring.repository;

import br.com.unipds.spring.model.Account;
import org.springframework.data.repository.ListCrudRepository;

public interface AccountRepository extends ListCrudRepository<Account,Integer> {
}
