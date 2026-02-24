package com.jpahibernate.hospital_management_db.controller;

import com.jpahibernate.hospital_management_db.model.Doctor;
import com.jpahibernate.hospital_management_db.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

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

    @GetMapping("/findById/{id}")
    public Doctor findDoctorById(@PathVariable int id)
    {
        Doctor doctor = doctorService.findDoctorById(id);

        return doctor;
    }

    // api call look like: http://localhost:7799/doctor/apis/findById/1

    @GetMapping("/getAll")
    public List<Doctor> getAll()
    {
        List<Doctor> doctorList = doctorService.getAllDoctors();

        return doctorList;
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteDoctorById(@PathVariable int id)
    {
        String res = doctorService.deleteDoctorById(id);
        return res;
    }

    // @PathVariable notation is used to take the input in url

    @GetMapping("/count")
    public  String getCount()
    {
        return "No. of Doctors: " + doctorService.getCount();
    }

    @PutMapping("/updatePut/{id}")
    public String updateDoctorUsingPut(@PathVariable int id, @RequestBody Doctor newDoctorInfo)
    {
        String res = doctorService.updateDoctorUsingPut(id, newDoctorInfo);
        return res;
    }

    // while Testing we send the new object details in the Body->raw->json

    @PatchMapping("/updatePatch/{id}")
    public String updateDoctorUsingPatch(@PathVariable int id,  @RequestParam String newName, @RequestParam String newEmail)
    {
        String res = doctorService.updateUsingPatch(id, newName, newEmail);
        return  res;
    }
    // while testing this, we pass @RequestParams
    // like: http://localhost:7799/doctor/apis/updatePatch/1?newName=AdeshUpdated&newEmail=adeshupdated@gmail.com
    // check the params name, they are as same as the params we wrote in method

    // @RequestParam takes the input in the parameter query
    @GetMapping("/test")
    public String test() {
        return "Working";
    }
}
