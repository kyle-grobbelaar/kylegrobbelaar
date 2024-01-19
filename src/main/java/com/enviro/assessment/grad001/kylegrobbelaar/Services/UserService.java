package com.enviro.assessment.grad001.kylegrobbelaar.Services;

import com.enviro.assessment.grad001.kylegrobbelaar.Persistence.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ProductDAO productDAO;

}
