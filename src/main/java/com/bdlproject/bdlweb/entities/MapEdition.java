package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_map_edition")
public class MapEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String editionNumber;
    private String productionShift;
    private LocalDate moment;
    private String description;

    // Coleção de triggers por MapEdition
    @OneToMany(mappedBy = "mapEdition")
    private List<Trigger> triggers = new ArrayList<>();

    public MapEdition() {
    }

    public MapEdition(Long id, String editionNumber, String productionShift, LocalDate moment, String description) {
        this.id = id;
        this.editionNumber = editionNumber;
        this.productionShift = productionShift;
        this.moment = moment;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(String editionNumber) {
        this.editionNumber = editionNumber;
    }

    public String getProductionShift() {
        return productionShift;
    }

    public void setProductionShift(String productionShift) {
        this.productionShift = productionShift;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // A inclusão da coleção de triggers nesta classe, requer também o seu respectivo Getter
    // Vale ressaltar que Listas (coleções) não possuem Setter...
    public List<Trigger> getTriggers() {
        return triggers;
    }
}
