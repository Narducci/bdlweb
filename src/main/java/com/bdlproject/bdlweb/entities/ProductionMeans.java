package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_production_means")
public class ProductionMeans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String assetNumber;
    private UsageType usageType;
    private Double currentPrice;
    private Double energyUsage;
    private String consumpUnit;
    private Double footprint;
    private Double surroundArea;
    private String manufacturer;
    private String operator;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @OneToOne
    @MapsId // pega o campo id da tabela tb_employee...
    private Employee indirectEmployee;

    // CONSTRUTORES
    public ProductionMeans() { }
    public ProductionMeans(Long id, String name, String assetNumber, UsageType usageType, Double currentPrice, Double energyUsage, String consumpUnit, Double footprint, Double surroundArea, String manufacturer, String operator, Sector sector, Employee indirectEmployee) {
        this.id = id;
        this.name = name;
        this.assetNumber = assetNumber;
        this.usageType = usageType;
        this.currentPrice = currentPrice;
        this.energyUsage = energyUsage;
        this.consumpUnit = consumpUnit;
        this.footprint = footprint;
        this.surroundArea = surroundArea;
        this.manufacturer = manufacturer;
        this.operator = operator;
        this.sector = sector;
        this.indirectEmployee = indirectEmployee;
    }

    // GETTER AND SETTER
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

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public UsageType getUsageType() { return usageType; }

    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getEnergyUsage() {
        return energyUsage;
    }

    public void setEnergyUsage(Double energyUsage) {
        this.energyUsage = energyUsage;
    }

    public String getConsumpUnit() {
        return consumpUnit;
    }

    public void setConsumpUnit(String consumpUnit) {
        this.consumpUnit = consumpUnit;
    }

    public Double getFootprint() {
        return footprint;
    }

    public void setFootprint(Double footprint) {
        this.footprint = footprint;
    }

    public Double getSurroundArea() {
        return surroundArea;
    }

    public void setSurroundArea(Double surroundArea) {
        this.surroundArea = surroundArea;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Employee getIndirectEmployee() {
        return indirectEmployee;
    }

    public void setIndirectEmployee(Employee indirectEmployee) {
        this.indirectEmployee = indirectEmployee;
    }

}
