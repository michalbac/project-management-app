package com.michal.pma.dao;

import com.michal.pma.dto.EmployeeProject;
import com.michal.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.annotation.Validated;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT first_name as firstName, last_name as lastName, COUNT (pe.employee_id) as projectCount " +
            "FROM employee e left join project_employee pe ON pe.employee_id=e.employee_id " +
            "GROUP BY e.first_name, e.last_name ORDER BY 3 desc")
    public List<EmployeeProject> employeeProjects();

    public Employee findByEmail(String email);
}
