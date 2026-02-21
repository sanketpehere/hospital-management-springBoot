
package com.jpahibernate.hospital_management_db;

import com.jpahibernate.hospital_management_db.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalManagementDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementDbApplication.class, args);
		System.out.println("Application is running at port no: 7799" );
	}
}
