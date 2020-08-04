package com.michal.pma.controllers;

import com.michal.pma.dao.ProjectRepository;
import com.michal.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        return "new-project";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createProject(Project project, Model model){
        projectRepository.save(project);
        return "redirect:/projects/new";
    }
}
