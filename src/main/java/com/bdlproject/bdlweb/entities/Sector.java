package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_sector")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dimension;
    private Double energyUsage;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sectors;

    @ManyToOne
    @JoinColumn(name = "cluster_id")
    private Cluster cluster;

    @OneToMany(mappedBy = "id.sector")
    private Set<SectorExpense> expenses = new HashSet<>();

    @OneToMany(mappedBy = "sector")
    private List<Asset> assets = new ArrayList<>();

    @OneToMany(mappedBy = "sector")
    private List<Employee> employees = new ArrayList<>();

    public Sector(Long id, String name, Double dimension, Double energyUsage, Sector sectors, Cluster cluster, Set<SectorExpense> expenses) {
        this.id = id;
        this.name = name;
        this.dimension = dimension;
        this.energyUsage = energyUsage;
        this.sectors = sectors;
        this.cluster = cluster;
        this.expenses = expenses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDimension() {
        return dimension;
    }

    public void setDimension(Double dimension) {
        this.dimension = dimension;
    }

    public Double getEnergyUsage() {
        return energyUsage;
    }

    public void setEnergyUsage(Double energyUsage) {
        this.energyUsage = energyUsage;
    }

    public Sector getSectors() {
        return sectors;
    }

    public void setSectors(Sector sectors) {
        this.sectors = sectors;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public Set<SectorExpense> getExpenses() {
        return expenses;
    }

    // Getter da lista de Assets
    public List<Asset> getAssets() {
        return assets;
    }

    // Getter da lista de Employees
    public List<Employee> getEmployees() {
        return employees;
    }
}
