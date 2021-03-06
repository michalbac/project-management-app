package com.michal.pma.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.michal.pma.validation.UniqueValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    private Long employeeId;

    @NotBlank(message = "*Must give a first name")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank(message = "*Must give a last name")
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @Email(message = "*Must be a valid email address")
    @UniqueValue
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
                fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    @JsonIgnore
    private List<Project> projects;

}
