package com.enviro.assessment.grad001.kylegrobbelaar.persistence;

import com.enviro.assessment.grad001.kylegrobbelaar.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Person Data Access Object - stores in memory every Person Entity.
 */
@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail( String email );
    Optional<Person> findByName(String name );
}
