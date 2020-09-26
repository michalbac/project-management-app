package com.michal.pma.controllers;

import com.michal.pma.entities.Employee;
import com.michal.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String createEmployee(@ModelAttribute("employee") @Valid Employee employee,  Errors errors){
        if(errors.hasErrors()){
             return "employees/new-employee";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/all-employees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam long id){
        employeeService.deleteById(id);
        return"redirect:/employees";

    }

    @GetMapping("/update")
    public String displayEmployeeUpdateForm(@RequestParam long id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employees/new-employee";
    }

}
