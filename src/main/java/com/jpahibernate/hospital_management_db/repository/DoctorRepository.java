package com.jpahibernate.hospital_management_db.repository;

import com.jpahibernate.hospital_management_db.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // performs database related ops - this has to an interface
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    // this has inbuilt methods
}
