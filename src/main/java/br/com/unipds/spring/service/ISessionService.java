package br.com.unipds.spring.service;

import br.com.unipds.spring.model.Session;

import java.util.List;

public interface ISessionService {
    Session addSession(Session session);
    Session getSessionById(Integer id);
    List<Session> getAllSessions();

}
