package com.enviro.assessment.grad001.kylegrobbelaar.persistence;

import com.enviro.assessment.grad001.kylegrobbelaar.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {
    public Person findByEmail( String email );
    public Person findByName( String name );
}
