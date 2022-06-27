package com.example.trabalhodispositivosmoveis;

public class Alternativa {
    private int idAlternativa;
    private int idQuestao;
    private String texto;
    private String indCerta;


    public int getIdAlternativa() {
        return idAlternativa;
    }

    public void setIdAlternativa(int idAlternativa) {
        this.idAlternativa = idAlternativa;
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getIndCerta() {
        return indCerta;
    }

    public void setIndCerta(String indCerta) {
        this.indCerta = indCerta;
    }
}
