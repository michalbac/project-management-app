package com.michal.pma.api.controller;

import com.michal.pma.entities.Project;
import com.michal.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app-api/projects")
public class ProjectApiController {
    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> getProjects(){
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById (@PathVariable long id){
        return projectService.getProjectById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody Project project){
        return projectService.save(project);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Project updateProject(@RequestBody Project project){
        return projectService.save(project);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Project patchUpdateProject(@PathVariable long id, @RequestBody Project project){
       Project projectTemp = projectService.getProjectById(id);
       if(project.getName() != null){
           projectTemp.setName(project.getName());
       }
        if(project.getName() != null){
            projectTemp.setName(project.getName());
        }
        if(project.getDescription() != null){
            projectTemp.setDescription(project.getDescription());
        }
        if(project.getStage() != null){
            projectTemp.setStage(project.getStage());
        }
        return projectService.save(projectTemp);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable long id){
        try{
            projectService.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }
    }
}
