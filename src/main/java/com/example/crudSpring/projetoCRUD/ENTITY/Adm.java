package com.example.crudSpring.projetoCRUD.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_adm")
@NoArgsConstructor
@Getter
@Setter
public class Adm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adm", nullable = false, unique=true)
    private Long id_adm;

    @Column(name = "nome_adm", nullable = false, length=100)
    private String nome_adm;

    @Column(name = "senha", nullable = false, length=20, unique=true)
    private String senha;

    @Column(name = "telefone", nullable = false, length=20, unique=true)
    private int telefone;

    @Column(name = "login", nullable = false, length=100)
    private String login;

    public Adm(String nome_adm, String senha, String login, int telefone) {
        this.nome_adm = nome_adm;
        this.senha = senha;
        this.login = login;
        this.telefone = telefone;
    }
    
}
