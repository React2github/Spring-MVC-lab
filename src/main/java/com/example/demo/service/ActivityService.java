package com.example.demo.service;

import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivity(Integer id) {
        return activityRepository.findById(id).get();
    }

    public Activity updateActivity(Integer id, Activity activityData) {
        Activity activity = activityRepository.findById(id).get();
//        activity.setName(activityData.getName());
//        activity.setEmail(activityData.getEmail());
        return activityRepository.save(activity);
    }

    public void deleteActivity(Integer id) {
        activityRepository.deleteById(id);
    }
}


