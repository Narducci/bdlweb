package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_regime")
public class Regime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortName;
    private String description;

    // Construtor vazio
    public Regime() {
    }

    // Construtor de todos os atributos
    public Regime(Long id, String shortName, String description) {
        this.id = id;
        this.shortName = shortName;
        this.description = description;
    }

    // Getter and Setter de todos os atributos
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
