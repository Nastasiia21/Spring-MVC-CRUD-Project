package com.code.springboot.thymeleafdemo.controller;

import com.code.springboot.thymeleafdemo.entity.Employee;
import com.code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Constructor injection of the EmployeeService
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // Handler method to handle list request and return all employees
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // Retrieve all employees from the service
        List<Employee> theEmployees = employeeService.findAll();

        // Add retrieved employees to the model to make them available to the view template
        theModel.addAttribute("employees", theEmployees);

        // Return the view name (employees/list-employees) to display the list of employees
        return "employees/list-employees";
    }

    // Handler method to display the form for adding a new employee
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // Create a new Employee object to hold employee form data
        Employee theEmployee = new Employee();

        // Add the employee object to the model to bind form data
        theModel.addAttribute("employee", theEmployee);

        // Return the form view (employees/employee-form)
        return "employees/employee-form";
    }

    // Handler method to display the form for updating an existing employee
    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {

        // Retrieve the employee by id from the service
        Employee theEmployee = employeeService.findById(theId);

        // Add the employee to the model to pre-populate the form with the employee's current data
        theModel.addAttribute("employee", theEmployee);

        // Return the form view (employees/employee-form)
        return "employees/employee-form";
    }

    // Handler method to save an employee's data (new or updated)
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        // Save the employee using the service
        employeeService.save(theEmployee);

        // Redirect to the employee list to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    // Handler method to delete an employee by id
    @PostMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // Delete the employee using the service
        employeeService.deleteById(theId);

        // Redirect to the employee list page
        return "redirect:/employees/list";
    }
}
