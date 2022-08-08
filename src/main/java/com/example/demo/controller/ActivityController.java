package com.example.demo.controller;

import com.example.demo.model.Activity;
import com.example.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//The controller is where we will define which methods a client request is routed to and what should be sent back as a response. Spring provides several annotations to make it easy to manage requests, responses, and client parameters.

@RestController //The @RestController combines the following annotations: @Controller: Indicates to Spring that the class represents a controller.@ResponseBody: Configures Spring to return JSON response from controller methods instead of view templates which is the default.
@RequestMapping("/api") //This annotation defines the base URL for the API
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @PostMapping("/activities")
    public ResponseEntity<Activity> createActivity(@Valid @RequestBody Activity activity) {
        Activity newActivity =  activityService.createActivity(activity);
        return ResponseEntity.ok(newActivity);
    }

    @GetMapping("/activities")
    public List<Activity> readActivities() {
        return activityService.getActivities();
    }

    @GetMapping("/activities/{activityId}")
    public Activity readActivity(@PathVariable(value = "activityId") Integer id) {
        return activityService.getActivity(id);
    }

    @PutMapping("/activities/{activityId}")
    public Activity updateActivity(@PathVariable(value = "activityId") Integer id, @RequestBody Activity activityData) {
        return activityService.updateActivity(id, activityData);
    }

    @DeleteMapping("/activities/{activityId}")
    public void deleteActivity(@PathVariable(value = "activityId") Integer id) {
        activityService.deleteActivity(id);
    }
}

