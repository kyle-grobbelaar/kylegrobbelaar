package com.enviro.assessment.grad001.kylegrobbelaar.service;

import com.enviro.assessment.grad001.kylegrobbelaar.model.Product;
import com.enviro.assessment.grad001.kylegrobbelaar.model.TestEntity;
import com.enviro.assessment.grad001.kylegrobbelaar.persistence.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ProductDAO productDAO;

    public Product saveTestEntity( Product testEntity) {
        return productDAO.save( testEntity );
    }

    public List<Product> getAllTestEntities() {
        return productDAO.findAll();
    }

}
