package com.pluralsight.psdemo.controllers;
import com.pluralsight.psdemo.models.Speaker;
import com.pluralsight.psdemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    // Return all Speakers
    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    // Return Speaker by id
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepository.getReferenceById(id);
    }

    // Create a Speaker
    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    // Delete a Speaker
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    // Update a Speaker
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        Speaker foundSpeaker = speakerRepository.getReferenceById(id);
        // Take foundSpeaker and copy the incoming speaker data onto it & ignore the id property
        BeanUtils.copyProperties(speaker, foundSpeaker, "speaker_id");
        // Save the new foundSpeaker details
        return speakerRepository.saveAndFlush(foundSpeaker);
    }

}
