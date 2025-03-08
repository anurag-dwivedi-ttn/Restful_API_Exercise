package com.example.controllerdemo.service;

import com.example.controllerdemo.employee.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDaoService {
    private static List<Employee> employees = new ArrayList<>();

    // Static block to initialize sample employees
    static {
        employees.add(new Employee(1, "Anurag", 25));
        employees.add(new Employee(2, "Rohit", 30));
        employees.add(new Employee(3, "Anant", 28));
    }

    // Retrieve all employees
    public List<Employee> findAll() {
        return employees;
    }

    // Find an employee by ID
    public Employee findOne(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Save a new employee
    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }

    // Delete an employee by ID
    public boolean deleteById(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }
}
