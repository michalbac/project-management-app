package com.michal.pma.controllers;

import com.michal.pma.dao.EmployeeRepository;
import com.michal.pma.dao.ProjectRepository;
import com.michal.pma.entities.Employee;
import com.michal.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return"main/home";
    }
}
