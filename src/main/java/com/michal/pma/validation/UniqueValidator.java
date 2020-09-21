package com.michal.pma.validation;

import com.michal.pma.dao.EmployeeRepository;
import com.michal.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator <UniqueValue, String>{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Entered validation method....");
        Employee emp = employeeRepository.findByEmail(s);
        if (emp != null){
            return false;
        } else {
            return  true;
        }
    }
}
