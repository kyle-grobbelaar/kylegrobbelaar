package com.enviro.assessment.grad001.kylegrobbelaar.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    @GetMapping
    public String Hello () {
        return "Hello";
    }

}
