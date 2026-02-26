package br.com.unipds.spring.service.impl;

import br.com.unipds.spring.exception.NotFoundException;
import br.com.unipds.spring.model.Session;
import br.com.unipds.spring.repository.SessionRepository;
import br.com.unipds.spring.service.ISessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService {

    private SessionRepository repository;

    public SessionServiceImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Session addSession(Session session) {
        return repository.save(session);
    }

    @Override
    public Session getSessionById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Session %d not found", id)));
    }

    @Override
    public List<Session> getAllSessions() {
        return repository.findAll();
    }
}
