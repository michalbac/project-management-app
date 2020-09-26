package com.michal.pma.dao;

import com.michal.pma.dto.ChartData;
import com.michal.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "apiprojects", path = "apiprojects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT p.stage, COUNT (*) as count " +
            "from project p " +
            "GROUP BY p.stage")
    List<ChartData> getProjectsStatus();
}
