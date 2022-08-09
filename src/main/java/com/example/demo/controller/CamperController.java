package com.example.demo.controller;

import com.example.demo.model.Camper;
import com.example.demo.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//The controller is where we will define which methods a client request is routed to and what should be sent back as a response. Spring provides several annotations to make it easy to manage requests, responses, and client parameters.

@RestController //The @RestController combines the following annotations: @Controller: Indicates to Spring that the class represents a controller.@ResponseBody: Configures Spring to return JSON response from controller methods instead of view templates which is the default.
@RequestMapping("/api") //This annotation defines the base URL for the API
public class CamperController {
    @Autowired
    CamperService camperService;

    @PostMapping("/campers")
    public ResponseEntity<Camper> createCamper(@Valid @RequestBody Camper camper) {
        Camper newCamper =  camperService.createCamper(camper);
        return ResponseEntity.ok(newCamper);
    }


    @GetMapping("/campers")
    public List<Camper> readCampers() {
        return camperService.getCampers();
    }

    @GetMapping("/campers/{camperId}")
    public Camper readCamper(@PathVariable(value = "camperId") Integer id) {
        return camperService.getCamper(id);
    }

    @PutMapping("/campers/{camperId}")
    public Camper updateCamper(@PathVariable(value = "camperId") Integer id, @RequestBody Camper camperData) {
        return camperService.updateCamper(id, camperData);
    }

    @DeleteMapping("/campers/{camperId}")
    public void deleteCamper(@PathVariable(value = "camperId") Integer id) {
        camperService.deleteCamper(id);
    }
}

