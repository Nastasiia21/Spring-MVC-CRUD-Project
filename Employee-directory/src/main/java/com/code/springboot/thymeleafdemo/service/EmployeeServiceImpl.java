package com.code.springboot.thymeleafdemo.service;

import com.code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // Constructor injection of the EmployeeRepository dependency.
    // This enables the service to perform CRUD operations on Employee entities.
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    // Finds all Employee entities, sorted by last name in ascending order.
    @Override
    public List<Employee> findAll() {
        // Delegates the call to the repository's custom method to retrieve sorted list of employees.
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    // Finds a single Employee entity by its ID.
    @Override
    public Employee findById(int theId) {
        // Attempts to find the employee by ID. If not found, throws an exception.
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            // If the employee is found, returns the employee.
            theEmployee = result.get();
        }
        else {
            // If the employee is not found, throws a RuntimeException.
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    // Saves or updates an Employee entity in the database.
    @Override
    public void save(Employee theEmployee) {
        // Delegates the call to the repository's save method.
        employeeRepository.save(theEmployee);
    }

    // Deletes an Employee entity by its ID.
    @Override
    public void deleteById(int theId) {
        // Delegates the call to the repository's deleteById method.
        employeeRepository.deleteById(theId);
    }

}

