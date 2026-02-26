package br.com.unipds.spring.controller;

import br.com.unipds.spring.model.Session;
import br.com.unipds.spring.model.Subscription;
import br.com.unipds.spring.model.User;
import br.com.unipds.spring.service.ISubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private ISubscriptionService service;

    public SubscriptionController(ISubscriptionService service) {
        this.service = service;
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Subscription> addSubscription(
            @RequestBody Subscription subscription
    ) {
        return ResponseEntity.status(201).body(service.addSubscription(subscription));
    }

    @GetMapping("/subscriptions/user/{userId}")
    public ResponseEntity<List<Subscription>> getByUser(
            @PathVariable(name = "userId") Integer id
    ) {
        User user = new User();
        user.setUserId(id);
        return ResponseEntity.ok(service.getAllByUser(user));
    }

    @GetMapping("subscriptions/session/{sessionId}")
    public ResponseEntity<List<Subscription>> getBySession(
            @PathVariable(name = "sessionId") Integer id
    ) {
        Session session = new Session();
        session.setIdSession(id);
        return ResponseEntity.ok(service.getAllBySession(session));
    }
}
