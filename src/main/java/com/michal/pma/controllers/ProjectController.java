package com.michal.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michal.pma.dto.TimelineData;
import com.michal.pma.entities.Employee;
import com.michal.pma.entities.Project;
import com.michal.pma.services.EmployeeService;
import com.michal.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("project", aProject);
        return "projects/new-project";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createProject(@ModelAttribute("project") @Valid Project project, Errors errors, Model model){
        if(errors.hasErrors()){
            List<Employee> employees = employeeService.findAll();
            model.addAttribute("allEmployees", employees);
            return "projects/new-project";
        }
        projectService.save(project);
        return "redirect:/projects";
    }

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return"projects/all-projects";
    }

    @GetMapping("/update")
    public String displayProjectUpdateForm(@RequestParam long id, Model model){
        Project project = projectService.getProjectById(id);
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("project", project);
        return "projects/new-project";
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam long id){
        projectService.deleteById(id);
        return "redirect:/projects";
    }

    @GetMapping("/timelines")
    public String displayProjectTimelines(Model model) throws JsonProcessingException {
        List<TimelineData> timelineData = projectService.getTimelineData();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStringTimeline = objectMapper.writeValueAsString(timelineData);
        model.addAttribute("timelineData", jsonStringTimeline);
        return "projects/project-timelines";
    }

}
