package com.example.trabalhodispositivosmoveis;

public class Materia {
    private int idMateria;
    private String nome;
    private float qtdQuestoes;
    private float qtdCertas;
    private float qtdErradas;

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getQtdQuestoes() {
        return qtdQuestoes;
    }

    public void setQtdQuestoes(float qtdQuestoes) {
        this.qtdQuestoes = qtdQuestoes;
    }

    public float getQtdCertas() {
        return qtdCertas;
    }

    public void setQtdCertas(float qtdCertas) {
        this.qtdCertas = qtdCertas;
    }

    public float getQtdErradas() {
        return qtdErradas;
    }

    public void setQtdErradas(float qtdErradas) {
        this.qtdErradas = qtdErradas;
    }

    @Override
    public String toString() {
        if ((qtdCertas + qtdErradas) == 0) {
            return nome + " - " + (qtdCertas + qtdErradas) + "/" + qtdQuestoes + " " + "0%";
        } else {
            return nome + " - " + (qtdCertas + qtdErradas) + "/" + qtdQuestoes + " " + ((qtdCertas / (qtdCertas + qtdErradas)) * 100)+ "%";
        }
    }
}
