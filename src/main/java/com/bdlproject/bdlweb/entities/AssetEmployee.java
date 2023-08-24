package com.bdlproject.bdlweb.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_asset_employee")
public class AssetEmployee {

    @EmbeddedId
    AssetEmployeePK id = new AssetEmployeePK(); //Requer seja instanciado por estar sendo usado classe auxiliar
    private Double allocationTime;

    public AssetEmployee() {
    }


    // O AssetEmployeePK_id deve ser substituido conforme nesta classe
    public AssetEmployee(Asset asset, Employee employee, Double allocationTime) {
        // obtém o asset_id e o employee_id contido na classe auxiliar
        id.setAsset(asset); //
        id.setEmployee(employee); // obtém o employee_id contido na classe auxiliar

        // atribuição natural do construtor
        this.allocationTime = allocationTime;
    }

    // Getter and Setter: montar os Getter and Setter manualmente
    public Asset getAsset() {
        return id.getAsset();
    }

    public void setAsset(Asset asset) {
        id.setAsset(asset);
    }

    public Employee getEmployee() {
        return id.getEmployee();
    }

    public void setEmployee(Employee employee) {
        id.setEmployee(employee);
    }

    public Double getAllocationTime() {
        return allocationTime;
    }

    public void setAllocationTime(Double allocationTime) {
        this.allocationTime = allocationTime;
    }
}
