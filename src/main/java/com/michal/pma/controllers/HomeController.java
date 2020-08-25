package com.michal.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michal.pma.dto.ChartData;
import com.michal.pma.dto.EmployeeProject;
import com.michal.pma.entities.Project;
import com.michal.pma.services.EmployeeService;
import com.michal.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Value("${version}")
    private String version;

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        model.addAttribute("versionNumber", version);
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = projectService.getProjectsStatus();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatus", jsonString);

        List<EmployeeProject> employeesProjectCount = employeeService.getEmployeeProjects();
        model.addAttribute("employeesProjectCount", employeesProjectCount);
        return"main/home";
    }
}
