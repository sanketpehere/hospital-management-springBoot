package com.jpahibernate.hospital_management_db.controller;

import com.jpahibernate.hospital_management_db.model.Doctor;
import com.jpahibernate.hospital_management_db.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/saveDoctor")
    public String saveDoctor(@RequestBody Doctor doctor) // here @RequestBody is used to take input
    // request from UI or postman and only used for complete class as input
    {

        String response = doctorService.saveDoctor(doctor);

        return response;


    }

    @GetMapping("/test")
    public String test() {
        return "Working";
    }
}
