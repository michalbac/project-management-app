package com.michal.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michal.pma.dao.EmployeeRepository;
import com.michal.pma.dao.ProjectRepository;
import com.michal.pma.dto.ChartData;
import com.michal.pma.dto.EmployeeProject;
import com.michal.pma.entities.Project;
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
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        model.addAttribute("versionNumber", version);
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = projectRepository.getProjectsStatus();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatus", jsonString);

        List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
        model.addAttribute("employeesProjectCount", employeesProjectCount);
        return"main/home";
    }
}
