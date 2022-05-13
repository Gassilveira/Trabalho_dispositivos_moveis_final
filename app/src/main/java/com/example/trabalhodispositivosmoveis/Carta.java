package com.example.trabalhodispositivosmoveis;

public class Carta {
    private int id;
    private String nome;
    private int qtdOwned;
    private int cmc;
    private String infFoil;

    public Carta(){
    }

    public Carta(String nome, int qtdOwned, int cmc, String indFoil){
        this.nome = nome;
        this.qtdOwned = qtdOwned;
        this.cmc = cmc;
        this.infFoil = indFoil;
    }

    public String toString(){
        return nome + "    " + cmc + '\n' + qtdOwned + "      " + "Foil: " + infFoil;
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

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    public String getInfFoil() {
        return infFoil;
    }

    public void setInfFoil(String infFoil) {
        this.infFoil = infFoil;
    }

    public int getQtdOwned() {
        return qtdOwned;
    }

    public void setQtdOwned(int qtdOwned) {
        this.qtdOwned = qtdOwned;
    }
}
