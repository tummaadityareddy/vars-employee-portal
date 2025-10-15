package com.varsemployeeportal.employee_service.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    private String email;
    private String department;
    private double salary;
}
