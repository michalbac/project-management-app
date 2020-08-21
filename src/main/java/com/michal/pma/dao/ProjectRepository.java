package com.michal.pma.dao;

import com.michal.pma.dto.ChartData;
import com.michal.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT p.stage, COUNT (*) as count " +
            "from project p " +
            "GROUP BY p.stage")
    List<ChartData> getProjectsStatus();
}
