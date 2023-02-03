package com.pluralsight.psdemo.repositories;
import com.pluralsight.psdemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
