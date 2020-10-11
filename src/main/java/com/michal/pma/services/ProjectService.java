package com.michal.pma.services;

import com.michal.pma.dao.ProjectRepository;
import com.michal.pma.dto.ChartData;
import com.michal.pma.dto.TimelineData;
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

    public List<TimelineData> getTimelineData(){
        return projectRepository.getProjectTimeline();
    }

    public Project getProjectById(long id){
        return projectRepository.findById(id).get();
    }

    public void deleteById(long id){
        projectRepository.deleteById(id);
    }

}
