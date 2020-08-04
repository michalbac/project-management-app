package com.michal.pma.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Project extends BaseEntity {
    private String name;
    private String stage;
    private String description;
    }
