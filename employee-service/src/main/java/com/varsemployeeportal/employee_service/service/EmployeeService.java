package com.varsemployeeportal.employee_service.service;

import com.varsemployeeportal.employee_service.entity.Employee;

import java.util.List;


public interface EmployeeService {

    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
