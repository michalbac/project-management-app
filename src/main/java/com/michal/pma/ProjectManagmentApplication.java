package com.michal.pma;

import com.michal.pma.dao.EmployeeRepository;
import com.michal.pma.dao.ProjectRepository;
import com.michal.pma.entities.Employee;
import com.michal.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ProjectManagmentApplication {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagmentApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Employee emp1 = new Employee("John", "Warton", "warton@gmail.com", new ArrayList<>());
            Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com", new ArrayList<>());
            Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com", new ArrayList<>());

            Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com", new ArrayList<>());
            Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com", new ArrayList<>());
            Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com", new ArrayList<>());

            Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com", new ArrayList<>());
            Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com", new ArrayList<>());
            Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com", new ArrayList<>());


            Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
                    + "the final deployment of the software into production", new ArrayList<>());
            Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
                    + "for the year and figureout who will be promoted", new ArrayList<>());
            Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
                    + "been damaged due to hurricane in the region. This needs to be reconstructed", new ArrayList<>());
            Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
                    + "security needs to be improved and proper security team needs to be hired for "
                    + "implementation", new ArrayList<>());



            // need to set both sides of the relationship manually

            pro1.getEmployees().add(emp1);
            pro1.getEmployees().add(emp2);
            pro2.getEmployees().add(emp3);
            pro3.getEmployees().add(emp1);
            pro4.getEmployees().add(emp1);
            pro4.getEmployees().add(emp3);


            // need to set both sides of the relationship manually

            emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
            emp2.setProjects(Arrays.asList(pro1));
            emp3.setProjects(Arrays.asList(pro2, pro4));

            // save employees in database

            employeeRepository.save(emp1);
            employeeRepository.save(emp2);
            employeeRepository.save(emp3);
            employeeRepository.save(emp4);
            employeeRepository.save(emp5);
            employeeRepository.save(emp6);
            employeeRepository.save(emp7);
            employeeRepository.save(emp8);
            employeeRepository.save(emp9);


            // save projects in database

            projectRepository.save(pro1);
            projectRepository.save(pro2);
            projectRepository.save(pro3);
            projectRepository.save(pro4);


        };
    }

}
