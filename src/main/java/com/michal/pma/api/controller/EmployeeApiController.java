package com.michal.pma.api.controller;

import com.michal.pma.dao.EmployeeRepository;
import com.michal.pma.entities.Employee;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app-api/employees")
public class EmployeeApiController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employeeRepository.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){
        return employeeRepository.save(employee);

    }

    @PutMapping(consumes ="application/json" )
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody Employee employee){
        return employeeRepository.save(employee);

    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Employee partialUpdate(@PathVariable long id, @RequestBody Employee employee){
        Employee emp = employeeRepository.findById(id).get();
        if( employee.getEmail() != null){
            emp.setEmail(employee.getEmail());
        }
        if( employee.getFirstName() != null){
            emp.setFirstName(employee.getEmail());
        }
        if( employee.getLastName() != null){
            emp.setLastName(employee.getEmail());
        }
        return employeeRepository.save(emp);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        try {
            employeeRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }
    }
}
