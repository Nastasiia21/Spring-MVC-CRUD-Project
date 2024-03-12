package com.code.springboot.thymeleafdemo.dao;

import com.code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// EmployeeRepository interface extending JpaRepository to handle CRUD operations for Employee entities
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

   // Inherits default CRUD operations from JpaRepository (e.g., save, findById, findAll, deleteById, etc.)
   // No additional implementation code is required, Spring Data JPA generates the implementation automatically.

   // Custom method to find all Employee entities sorted by their last name in ascending order.
   // Spring Data JPA will automatically generate the implementation based on the method name.
   public List<Employee> findAllByOrderByLastNameAsc();

}
