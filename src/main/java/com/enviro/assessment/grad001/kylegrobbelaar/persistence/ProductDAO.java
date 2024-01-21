package com.enviro.assessment.grad001.kylegrobbelaar.persistence;

import com.enviro.assessment.grad001.kylegrobbelaar.model.Product;
import com.enviro.assessment.grad001.kylegrobbelaar.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Product Data Access Object - stores in memory every Product Entity
 */
@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    List<Product> findAllByEmail( String email );
    List<Product> findAllByName( String name );

}
