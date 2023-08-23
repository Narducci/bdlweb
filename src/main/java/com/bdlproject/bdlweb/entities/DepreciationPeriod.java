package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_depreciation_period")
public class DepreciationPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String assetType;
    private Integer timeframeMonth;

    // Coleção de categorias por depreciação
    @OneToMany(mappedBy = "depreciationPeriod")
    private List<Category> categories = new ArrayList<>();

    // Construtor vazio
    public DepreciationPeriod() {
    }

    public DepreciationPeriod(Long id, String assetType, Integer timeframeMonth) {
        this.id = id;
        this.assetType = assetType;
        this.timeframeMonth = timeframeMonth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Integer getTimeframeMonth() {
        return timeframeMonth;
    }

    public void setTimeframeMonth(Integer timeframeMonth) {
        this.timeframeMonth = timeframeMonth;
    }

    // Acrescentar o construtor Getter para a coleção...
    public List<Category> getCategories() {
        return categories;
    }
}
