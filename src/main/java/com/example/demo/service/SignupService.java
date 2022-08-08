package com.example.demo.service;

import com.example.demo.model.Signup;
import com.example.demo.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class SignupService {

    @Autowired
    SignupRepository signupRepository;

    public Signup createSignup(Signup signup) {
        return signupRepository.save(signup);
    }

    public List<Signup> getSignups() {
        return signupRepository.findAll();
    }

    public Signup getSignup(Integer id) {
        return signupRepository.findById(id).get();
    }

    public Signup updateSignup(Integer id, Signup signupData) {
        Signup signup = signupRepository.findById(id).get();
//        signup.setName(signupData.getName());
//        signup.setEmail(signupData.getEmail());
        return signupRepository.save(signup);
    }

    public void deleteSignup(Integer id) {
        signupRepository.deleteById(id);
    }
}


