package com.jpahibernate.hospital_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity // represents that this class is entity or model class
@Table (name = "doctor") // this creates the table with the same name, if name is not provided it takes the name of the class
@Data // this adds getters and setter internally
@Getter
@Setter
@AllArgsConstructor // this is parametrized constructor
@NoArgsConstructor // this is default constructor

public class Doctor {

    @Column(name = "id") // this created the col with the name provided in the tables in db
    @Id // this indicates that id is primary key (unique and not null)
    private int id;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "dob", nullable = false)
    private  String dob;
    // we ran the application


    // then we added following,
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
// after adding this we ran application again, springBoot automatically update those changes
}
