package com.enviro.assessment.grad001.kylegrobbelaar.Persistence;

import com.enviro.assessment.grad001.kylegrobbelaar.Entities.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<TestEntity, Long> {
}
