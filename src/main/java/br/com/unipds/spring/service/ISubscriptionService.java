package br.com.unipds.spring.service;

import br.com.unipds.spring.model.Session;
import br.com.unipds.spring.model.Subscription;
import br.com.unipds.spring.model.User;

import java.util.List;

public interface ISubscriptionService {
    Subscription addSubscription(Subscription subscription);
    List<Subscription> getAllByUser(User user);
    List<Subscription> getAllBySession(Session session);
}
