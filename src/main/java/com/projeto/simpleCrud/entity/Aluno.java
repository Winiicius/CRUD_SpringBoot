package com.projeto.simpleCrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CURSO")
    private String curso;

    @Column(name = "PERIODO")
    private int periodo;

    public Aluno(){};

    public Aluno(String nome, String email, String curso, int periodo) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    };

    @Override
    public String toString() {
        return "\nId: " + this.id +
               "\nNome Aluno: " + this.nome +
               "\nEmail: " + this.email +
               "\nCurso: " + this.curso +
               "\nPeríodo: " + this.periodo;
    }

    public boolean equals(Aluno aluno) {
        if(aluno.getEmail().equals(this.email)) return true;
        return false;
    }
    
}
