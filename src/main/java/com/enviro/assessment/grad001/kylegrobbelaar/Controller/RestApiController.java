package com.enviro.assessment.grad001.kylegrobbelaar.Controller;

import com.enviro.assessment.grad001.kylegrobbelaar.Entities.TestEntity;
import com.enviro.assessment.grad001.kylegrobbelaar.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String Hello () {
        return "Hello";
    }

    @GetMapping("/save")
    public TestEntity saveTestEntity() {

        TestEntity testEntity = new TestEntity();
        testEntity.setAuthor("K.Grobbelaar");
        testEntity.setTitle("Life's tough");
        return userService.saveTestEntity( testEntity );
    }


}
