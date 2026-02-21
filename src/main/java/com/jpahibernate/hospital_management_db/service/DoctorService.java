package com.jpahibernate.hospital_management_db.service;

import com.jpahibernate.hospital_management_db.model.Doctor;
import com.jpahibernate.hospital_management_db.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service // contains buisness logic
public class DoctorService {
    @Autowired // creates beans
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor)
    {
        System.out.println(doctor.getId());
        System.out.println(doctor.getName());
        System.out.println(doctor.getSpecialization());
        System.out.println(doctor.getPhone());
        System.out.println(doctor.getEmail());
        doctorRepository.save(doctor);
        return "Doctor Saved Successfully";
    }
}
