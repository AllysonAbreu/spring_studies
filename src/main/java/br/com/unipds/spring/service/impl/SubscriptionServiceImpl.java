package br.com.unipds.spring.service.impl;

import br.com.unipds.spring.model.Session;
import br.com.unipds.spring.model.Subscription;
import br.com.unipds.spring.model.User;
import br.com.unipds.spring.repository.SubscriptionRepository;
import br.com.unipds.spring.service.ISubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {

    private SubscriptionRepository repository;

    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setUniqueID(UUID.randomUUID().toString());
        return repository.save(subscription);
    }

    @Override
    public List<Subscription> getAllByUser(User user) {
        return repository.findByIdUser(user);
    }

    @Override
    public List<Subscription> getAllBySession(Session session) {
        return repository.findByIdSession(session);
    }
}
