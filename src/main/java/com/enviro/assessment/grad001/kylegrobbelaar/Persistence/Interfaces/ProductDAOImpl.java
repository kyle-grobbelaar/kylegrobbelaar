package com.enviro.assessment.grad001.kylegrobbelaar.Persistence.Interfaces;

import com.enviro.assessment.grad001.kylegrobbelaar.Common.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Override
    public List<Product> findProductByEmail(String email) {
        return null;
    }
}
