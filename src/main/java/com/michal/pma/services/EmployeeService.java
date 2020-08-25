package com.michal.pma.services;

import com.michal.pma.dao.EmployeeRepository;
import com.michal.pma.dto.EmployeeProject;
import com.michal.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public List<EmployeeProject> getEmployeeProjects(){
        return employeeRepository.employeeProjects();
    }
}
