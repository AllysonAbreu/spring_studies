package br.com.unipds.spring.service.impl;

import br.com.unipds.spring.exception.NotFoundException;
import br.com.unipds.spring.model.Conference;
import br.com.unipds.spring.repository.ConferenceRepository;
import br.com.unipds.spring.service.IConferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceServiceImpl implements IConferenceService {

    private ConferenceRepository repository;

    public ConferenceServiceImpl(ConferenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Conference addConference(Conference conference) {
        return repository.save(conference);
    }

    @Override
    public Conference getConferenceById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Conference %d not found", id)));
    }

    @Override
    public List<Conference> getAllConferences() {
        return repository.findAll();
    }
}
