package com.michal.pma.controllers;

import com.michal.pma.entities.Employee;
import com.michal.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/employees")
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/new-employee";
    }

    @PostMapping("/create")
    public String createEmployee(Employee employee, Model model){
        employeeService.save(employee);
        return "redirect:/employees/new";
    }

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/all-employees";
    }

}
