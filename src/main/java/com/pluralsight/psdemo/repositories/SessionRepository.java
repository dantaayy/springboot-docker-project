package com.pluralsight.psdemo.repositories;
import com.pluralsight.psdemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
