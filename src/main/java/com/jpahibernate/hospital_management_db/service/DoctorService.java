package com.jpahibernate.hospital_management_db.service;

import com.jpahibernate.hospital_management_db.model.Doctor;
import com.jpahibernate.hospital_management_db.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // contains buisness logic
public class DoctorService {
    @Autowired // creates beans
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor)
    {
        doctorRepository.save(doctor);
        return "Doctor Saved Successfully";
    }

    public Doctor findDoctorById(int id)
    {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);

        if(doctorOptional.isPresent())
        {
            return doctorOptional.get();
        }
        else
        {
            return null;
        }
    }

    public List<Doctor> getAllDoctors()
    {
        List<Doctor> list = doctorRepository.findAll();
        return list;
    }

    public String deleteDoctorById(int id)
    {
        doctorRepository.deleteById(id);
        return "Doctor with id: "+ id + " Deleted!";
    }

    public String getCount()
    {
        long count =  doctorRepository.count();
        return Long.toString(count);
    }

    // update using PUT - PUT updates whole object
    public String updateDoctorUsingPut(int doctorId,  Doctor newDoctorInfo)
    {
        Doctor existing = findDoctorById(doctorId);

        if(existing != null)
        {
            doctorRepository.save(newDoctorInfo);
            return "Doctor updated successfully using PUT";
        }
        else
        {
            return "Doctor with id: " + doctorId + " Not Found";
        }
    }

    // Update using PATCH - it is used to update specific fields in the object
    public String updateUsingPatch(int id,  String newName, String newEmail)
    {
        Doctor existing = findDoctorById(id);

        if(existing != null)
        {
            existing.setName((newName));
            existing.setEmail(newEmail);

            doctorRepository.save(existing);
            return "Doctor Updated Successfully using PATCH";
        }
        else
        {
            return "Doctor with id: " + id + " Not Found";
        }
    }
}
