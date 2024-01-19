package com.enviro.assessment.grad001.kylegrobbelaar.Controllers;

import com.enviro.assessment.grad001.kylegrobbelaar.Common.Product;
import com.enviro.assessment.grad001.kylegrobbelaar.Common.ProductType;
import com.enviro.assessment.grad001.kylegrobbelaar.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutesController {

    @Autowired
    UserService userService;

    @GetMapping("/HelloUser")
    public String getHelloUser() {
        return "Helllo User";
    }

    @PostMapping("/save")
    public Product saveProduct() {
        return userService.saveProductToPerson( new Product( ProductType.SAVINGS,
                "Kyle",
                Long.parseLong("400"),
                Long.valueOf( "21" ),
                "Kyle@email.com",
                "123 street bigZone") );
    }
}
