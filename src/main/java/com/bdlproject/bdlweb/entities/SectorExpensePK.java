package com.bdlproject.bdlweb.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SectorExpensePK {

    // Classe auxiliar para compor a chave primária da tabela associativa tb_sector_expense contendo as chaves das classes relacionadas
    // importante: é necessário incluir a annotation @Embeddable sobre o nome da classe...

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    public SectorExpensePK() {
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}
