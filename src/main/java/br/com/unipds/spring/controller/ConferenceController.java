package br.com.unipds.spring.controller;

import br.com.unipds.spring.model.Conference;
import br.com.unipds.spring.service.IConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConferenceController {

    private IConferenceService service;

    public ConferenceController(IConferenceService service) {
        this.service = service;
    }

    @PostMapping("/conferences")
    public ResponseEntity<Conference> addConference(Conference conference) {
        return ResponseEntity.status(201).body(service.addConference(conference));
    }

    @GetMapping("/conferences/{id}")
    public ResponseEntity<Conference> getById(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(service.getConferenceById(id));
    }

    @GetMapping("/conferences")
    public ResponseEntity<List<Conference>> getAllConferences() {
        return ResponseEntity.ok(service.getAllConferences());
    }
}
