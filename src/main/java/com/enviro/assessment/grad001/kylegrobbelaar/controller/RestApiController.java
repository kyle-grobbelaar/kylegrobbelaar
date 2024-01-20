package com.enviro.assessment.grad001.kylegrobbelaar.controller;

import com.enviro.assessment.grad001.kylegrobbelaar.model.Person;
import com.enviro.assessment.grad001.kylegrobbelaar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@Controller
public class RestApiController {

    private final String baseUrl = "http://localhost:8080";
    @Autowired
    private UserService userService;

    @PostMapping("/login.action")
    public String savePerson(@RequestParam String name,
                                     @RequestParam String email,
                                     Model model) {
        Person person = new Person();
        person.setName( name );
        person.setEmail( email );
        model.addAttribute("person", person);
        System.out.println(person.getName());
        return "redirect:/investments.html";
    }

//    @GetMapping("/investments")
//    public String getInvestement(){
//        return "i am the investments";
//    }
}
