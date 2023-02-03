package com.pluralsight.psdemo.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
// Handle serialization problems with loading all of relational sql data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Speaker {

    // Primary key generation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Table attributes
    private Long speaker_id;

    private String first_name, last_name;
    private String title;
    private String company;
    private String speaker_bio;

    // Setup bidirectional relationship
    @ManyToMany(mappedBy = "speakers")
    // Prevent back serialization
    @JsonIgnore
    private List<Session> sessions;

    // Constructor
    public Speaker() {

    }

    // GETTERS AND SETTERS
    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Long speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
}
