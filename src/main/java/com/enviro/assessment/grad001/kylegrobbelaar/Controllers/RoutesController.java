package com.enviro.assessment.grad001.kylegrobbelaar.Controllers;

//import com.enviro.assessment.grad001.kylegrobbelaar.Common.Product;
//import com.enviro.assessment.grad001.kylegrobbelaar.Common.ProductType;
import com.enviro.assessment.grad001.kylegrobbelaar.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutesController {

    @Autowired
    UserService userService;

    @GetMapping("/Hello/{name}")
    public String getHelloUser(@PathVariable String name) {
        return "Helllo "+ name;
    }

//    @PostMapping("/save")
//    public Product saveProduct() {
//        return userService.saveProductToPerson( new Product());
//    }
}
