package com.michal.pma.services;

import com.michal.pma.dao.ProjectRepository;
import com.michal.pma.dto.ChartData;
import com.michal.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public void delete(Project project){
        projectRepository.delete(project);
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public List<ChartData> getProjectsStatus(){
        return projectRepository.getProjectsStatus();
    }

}
