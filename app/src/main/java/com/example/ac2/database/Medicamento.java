package com.example.ac2.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@com.example.ac2.database.Entity(tableName = "medicamentos")
public class Medicamento {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome;
    private String descricao;
    private String horario;
    private boolean consumido;


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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isConsumido() {
        return consumido;
    }

    public void setConsumido(boolean consumido) {
        this.consumido = consumido;
    }
}