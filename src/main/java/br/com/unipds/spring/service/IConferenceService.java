package br.com.unipds.spring.service;

import br.com.unipds.spring.model.Conference;

import java.util.List;

public interface IConferenceService {
    Conference addConference(Conference conference);
    Conference getConferenceById(Integer id);
    List<Conference> getAllConferences();
}
