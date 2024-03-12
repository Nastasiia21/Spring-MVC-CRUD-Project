package com.code.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

// Employee entity class representing an employee in the database
@Entity
@Table(name="employee") // Specifies the table in the database with which this entity is mapped.
public class Employee {

    // Fields represent the columns in the employee table.

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Configures the way of increment of the specified column(field).
    @Column(name="id") // Maps this field with the column named "id" in the table.
    private int id;

    @Column(name="first_name") // Maps this field with the column named "first_name" in the table.
    private String firstName;

    @Column(name="last_name") // Maps this field with the column named "last_name" in the table.
    private String lastName;

    @Column(name="email") // Maps this field with the column named "email" in the table.
    private String email;

    // Default constructor required by JPA
    public Employee() {

    }

    // Constructor with all fields, used for initializing Employee objects.
    public Employee(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Constructor without id, used for creating new Employee objects before saving to the database.
    // The database generates the id.
    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and setters for accessing and updating the fields of Employee objects.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method to provide a string representation of an Employee object,
    // useful for logging and debugging purposes.
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }

}
