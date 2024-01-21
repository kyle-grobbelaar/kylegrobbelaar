package com.enviro.assessment.grad001.kylegrobbelaar.persistence;

import com.enviro.assessment.grad001.kylegrobbelaar.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {
    public Optional<Person> findByEmail( String email );
    public Optional<Person> findByName(String name );
}
