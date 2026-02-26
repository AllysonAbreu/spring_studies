package br.com.unipds.spring.repository;

import br.com.unipds.spring.model.Transaction;
import org.springframework.data.repository.ListCrudRepository;

public interface TransactionRepository extends ListCrudRepository<Transaction,Integer> {
}
