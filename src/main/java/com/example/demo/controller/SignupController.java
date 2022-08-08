package com.example.demo.controller;

import com.example.demo.model.Signup;
import com.example.demo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//The controller is where we will define which methods a client request is routed to and what should be sent back as a response. Spring provides several annotations to make it easy to manage requests, responses, and client parameters.

@RestController //The @RestController combines the following annotations: @Controller: Indicates to Spring that the class represents a controller.@ResponseBody: Configures Spring to return JSON response from controller methods instead of view templates which is the default.
@RequestMapping("/api") //This annotation defines the base URL for the API
public class SignupController {
    @Autowired
    SignupService signupService;

    @PostMapping("/signups")
    public ResponseEntity<Signup> createSignup(@Valid @RequestBody Signup signup) {
        Signup newSignup =  signupService.createSignup(signup);
        return ResponseEntity.ok(newSignup);
    }

    @GetMapping("/signups")
    public List<Signup> readSignups() {
        return signupService.getSignups();
    }

    @GetMapping("/signups/{signupId}")
    public Signup readSignup(@PathVariable(value = "signupId") Integer id) {
        return signupService.getSignup(id);
    }

    @PutMapping("/signups/{signupId}")
    public Signup updateSignup(@PathVariable(value = "signupId") Integer id, @RequestBody Signup signupData) {
        return signupService.updateSignup(id, signupData);
    }

    @DeleteMapping("/signups/{signupId}")
    public void deleteSignup(@PathVariable(value = "signupId") Integer id) {
        signupService.deleteSignup(id);
    }
}

