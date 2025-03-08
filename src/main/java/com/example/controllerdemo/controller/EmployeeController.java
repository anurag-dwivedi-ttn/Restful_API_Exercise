package com.example.controllerdemo.controller;

import com.example.controllerdemo.exception.EmployeeNotFoundException;
import com.example.controllerdemo.service.EmployeeDaoService;
import com.example.controllerdemo.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDaoService service;

    // Get all employees
    // Q3)- Implement GET http request for Employee to get list of employees.
    @GetMapping("/employees")
    public List<Employee> retrieveAll() {
        return service.findAll();
    }

    // Get an employee by ID (throws exception if not found)
    // Q4)-Implement GET http request using path variable top get one employee
    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> retrieveOne(@PathVariable int id) {
        Employee employee = service.findOne(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee with id " + id + " not found");
        }
        return ResponseEntity.ok(employee);
    }

    // Add a new employee
//    Q5)-Implement POST http request for Employee to create a new employee.
    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = service.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    // Q8)- Implement PUT to Update an existing employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Employee existingEmployee = service.findOne(id);
        if (existingEmployee == null) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setAge(updatedEmployee.getAge());
        return ResponseEntity.ok(existingEmployee);
    }

    // Q7)- Implement DELETE http request for Employee to delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
        boolean isDeleted = service.deleteById(id);
        if (!isDeleted) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        return ResponseEntity.noContent().build();
    }
}
