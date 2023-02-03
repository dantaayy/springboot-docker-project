package com.pluralsight.psdemo.controllers;
import com.pluralsight.psdemo.models.Session;
import com.pluralsight.psdemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    // All sessions
    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    // Specific Session
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getReferenceById(id);
    }

    // Create a session
    @PostMapping
    public Session create(@RequestBody final Session session) {
        // Save object and commit using flush
        return sessionRepository.saveAndFlush(session);
    }

    // Delete a session
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Check for children records for deleting
        sessionRepository.deleteById(id);
    }

    // Update a session
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        Session foundSession = sessionRepository.getReferenceById(id);
        // Take foundSession and copy the incoming session data onto it & ignore the id property
        BeanUtils.copyProperties(session, foundSession, "session_id");
        // Save the new foundSession details
        return sessionRepository.saveAndFlush(foundSession);
    }

}
