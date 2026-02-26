package br.com.unipds.spring.repository;

import br.com.unipds.spring.model.Session;
import br.com.unipds.spring.model.Subscription;
import br.com.unipds.spring.model.SubscriptionID;
import br.com.unipds.spring.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SubscriptionRepository extends ListCrudRepository<Subscription, SubscriptionID> {
    List<Subscription> findByIdUser(User user);
    List<Subscription> findByIdSession(Session session);
}
