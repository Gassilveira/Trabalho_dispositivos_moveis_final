package com.example.trabalhodispositivosmoveis;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Questao {
    private int idQuestao;
    private String enunciado;
    private String indSituacao;
    private int idMateria;
    private List<Alternativa> alternativas;

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getIndSituacao() {
        return indSituacao;
    }

    public void setIndSituacao(String indSituacao) {
        this.indSituacao = indSituacao;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public void setAlternativas(Context context){
        this.alternativas = AlternativaDAO.getAlternartivas(context, idQuestao);
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }
}
