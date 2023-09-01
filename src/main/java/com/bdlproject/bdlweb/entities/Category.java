package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer timeframe_month;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;

    @OneToMany(mappedBy = "category")
    private List<Expense> expenses = new ArrayList<>();

    public Category() {
    }

    public Category(Long id, String name, Integer timeframe_month, Category categories, List<Expense> expenses) {
        this.id = id;
        this.name = name;
        this.timeframe_month = timeframe_month;
        this.categories = categories;
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

    public Integer getTimeframe_month() {
        return timeframe_month;
    }

    public void setTimeframe_month(Integer timeframe_month) {
        this.timeframe_month = timeframe_month;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

}
