package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;
import org.hibernate.boot.model.naming.ImplicitAnyDiscriminatorColumnNameSource;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double monthAmount;
    private String accountingCode;
    private String shortCode;
    private LocalDate releasedDate;
    private String origenCosts;

    // atributo do lado um
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "trigger_id")
    private Trigger trigger;

    @OneToMany(mappedBy = "id.expense")
    private Set<SectorExpense> sectors = new HashSet<>();

    public Expense() {
    }

    public Expense(Long id, String description, Double monthAmount, String accountingCode, String shortCode, LocalDate releasedDate, String origenCosts, Category category, Trigger trigger) {
        this.id = id;
        this.description = description;
        this.monthAmount = monthAmount;
        this.accountingCode = accountingCode;
        this.shortCode = shortCode;
        this.releasedDate = releasedDate;
        this.origenCosts = origenCosts;
        this.category = category;
        this.trigger = trigger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(Double monthAmount) {
        this.monthAmount = monthAmount;
    }

    public String getAccountingCode() {
        return accountingCode;
    }

    public void setAccountingCode(String accountingCode) {
        this.accountingCode = accountingCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getOrigenCosts() {
        return origenCosts;
    }

    public void setOrigenCosts(String origenCosts) {
        this.origenCosts = origenCosts;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }
}
