package com.bdlproject.bdlweb.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sector_expense")
public class SectorExpense {

    @EmbeddedId
    private SectorExpensePK id = new SectorExpensePK();
    private MapStatus mapStatus;


    // construtor vazio
    public SectorExpense() {
    }

    // construtor adaptado para receber a pk das duas classes.
    public SectorExpense(Sector sector, Expense expense, MapStatus mapStatus) {
        // this.id = id; foi substituido por sector e expense definidos na classe auxiliar
        id.setSector(sector);
        id.setExpense(expense);
        this.mapStatus = mapStatus;
    }

    public Sector getSector() {
        return id.getSector();
    }

    public void setSector(Sector sector) {
        id.setSector(sector);
    }

    public Expense getExpense() {
        return id.getExpense();
    }

    public void setExpense(Expense expense) {
        id.setExpense(expense);
    }

    public MapStatus getMapStatus() {
        return mapStatus;
    }

    public void setMapStatus(MapStatus mapStatus) {
        this.mapStatus = mapStatus;
    }
}
