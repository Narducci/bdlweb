package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cluster")
public class Cluster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String description;

    @OneToMany(mappedBy = "cluster")
    private List<Sector> sectors = new ArrayList<>();

    // Construtor vazio
    public Cluster() {
    }

    // Construtor com todos os argumentos
    public Cluster(Long id, String nickname, String description) {
        this.id = id;
        this.nickname = nickname;
        this.description = description;
    }

    // Getter and Setter de todos os atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
