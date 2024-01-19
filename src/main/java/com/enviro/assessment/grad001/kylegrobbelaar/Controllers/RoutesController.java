package com.enviro.assessment.grad001.kylegrobbelaar.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutesController {

    @GetMapping("/HelloUser")
    public String getHelloUser() {
        return "Helllo User";
    }

}
