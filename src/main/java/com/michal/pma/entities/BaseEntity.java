package com.michal.pma.entities;

import lombok.Getter;

import javax.persistence.*;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
