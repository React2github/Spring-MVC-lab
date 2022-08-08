package com.example.demo.service;

import com.example.demo.model.Camper;
import com.example.demo.repository.CamperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We will be using the @Service annotation to indicate a service class. It’s a specialization of the @Component class.
@Service
public class CamperService {

    @Autowired
    CamperRepository camperRepository;

    public Camper createCamper(Camper camper) {
        return camperRepository.save(camper);
    }

    public List<Camper> getCampers() {
        return camperRepository.findAll();
    }

    public Camper getCamper(Integer id) {
        return camperRepository.findById(id).get();
    }

    public Camper updateCamper(Integer id, Camper camperData) {
        Camper camper = camperRepository.findById(id).get();
//        camper.setName(camperData.getName());
        return camperRepository.save(camper);
    }

    public void deleteCamper(Integer id) {
        camperRepository.deleteById(id);
    }
}


