package com.code.springboot.thymeleafdemo.service;

import com.code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

// EmployeeService interface defines the operations available for managing Employee entities.
public interface EmployeeService {

    // Method to retrieve all Employee entities from the database.
    // Returns a list of all employees.
    List<Employee> findAll();

    // Method to find a single Employee entity by its ID.
    // @param theId The ID of the employee to be found.
    // @return The Employee entity if found, otherwise null.
    Employee findById(int theId);

    // Method to save or update an Employee entity in the database.
    // If the employee's ID is null or zero, a new entity will be saved,
    // otherwise, the existing entity will be updated.
    // @param theEmployee The Employee entity to save or update.
    void save(Employee theEmployee);

    // Method to delete an Employee entity from the database by its ID.
    // @param theId The ID of the employee to be deleted.
    void deleteById(int theId);

}
