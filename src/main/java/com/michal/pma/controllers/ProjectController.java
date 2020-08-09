package com.michal.pma.controllers;

import com.michal.pma.dao.EmployeeRepository;
import com.michal.pma.dao.ProjectRepository;
import com.michal.pma.entities.Employee;
import com.michal.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("project", aProject);
        return "projects/new-project";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createProject(Project project, Model model){
        projectRepository.save(project);

        return "redirect:/projects";
    }

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return"projects/all-projects";

    }
}
