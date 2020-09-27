package com.michal.pma.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.michal.pma.validation.CorrectDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Project{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
    private Long projectId;

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    private String stage;

    @NotBlank
    @Size(min = 1, max = 2000)
    private String description;

    @CorrectDate(message = "Date cannot be empty")
    private Date startDate;

    @CorrectDate(message = "Date cannot be empty")
    private Date endDate;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    @JsonIgnore
    private List<Employee> employees;
    }
