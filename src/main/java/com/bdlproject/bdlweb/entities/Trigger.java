package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_trigger")
public class Trigger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate triggerDate;
    private EcLevelType ecLevelType;

    // No lado muitos convém já deixar criado o atributo do lado Um, neste caso é o mapEdition
    // Seguindo as boas práticas, o nome atribuido deve respeitar o que está indicado na associação
    @ManyToOne
    @JoinColumn(name = "map_edition_id")
    private MapEdition mapEdition;

    @OneToMany(mappedBy = "trigger")
    private List<Expense> expenses = new ArrayList<>();

    public Trigger(){
    }

    public Trigger(Long id, LocalDate triggerDate, EcLevelType ecLevelType) {
        this.id = id;
        this.triggerDate = triggerDate;
        this.ecLevelType = ecLevelType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTriggerDate() {
        return triggerDate;
    }

    public void setTriggerDate(LocalDate triggerDate) {
        this.triggerDate = triggerDate;
    }

    public EcLevelType getEcLevelType() {
        return ecLevelType;
    }

    public void setEcLevelType(EcLevelType ecLevelType) {
        this.ecLevelType = ecLevelType;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
