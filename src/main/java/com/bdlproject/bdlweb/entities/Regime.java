package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_regime")
public class Regime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortName;
    private String description;

    @OneToMany(mappedBy = "regime")
    private List<Employee> employees = new ArrayList<>();

    public Regime() {
    }

    public Regime(Long id, String shortName, String description) {
        this.id = id;
        this.shortName = shortName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
