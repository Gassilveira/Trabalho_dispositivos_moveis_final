package com.example.trabalhodispositivosmoveis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int questao;

    private List<Questao> questoes;

    private TextView txtPergunta;

    private ListView lvAlternativas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questoes = QuestaoDAO.getQuestao(this, getIntent().getExtras().getInt("Materia"));//Integer.parseInt(getIntent().getExtras().getString("Materia")));

        if(questoes.size() == 0){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Atenção!");
            alertDialog.setMessage("Não existem questões a serem respondidas para a matéria selecionada.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
            alertDialog.show();
        }
        else{
            questao = 0;

            txtPergunta = (TextView)findViewById(R.id.txtPergunta);

            lvAlternativas = findViewById(R.id.lvAlternativas);

            montaQuestao();
        }
    }

    protected void montaQuestao() {
        Questao q = questoes.get(questao);

        q.setAlternativas(this);

        if(q.getIndSituacao() == "E"){
            txtPergunta.setText("Nova Tentativa - " + q.getEnunciado());
        }else{
            txtPergunta.setText(q.getEnunciado());
        }


        lvAlternativas.setEnabled( true );

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, q.getAlternativas());
        lvAlternativas.setAdapter( adapter );

        lvAlternativas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                verificaQuestao(position);
            }
        });
    }

    protected void verificaQuestao(int pos){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        Questao q = new Questao();
        q.setIdQuestao(questoes.get(questao).getIdQuestao());

        String indCerto = questoes.get(questao).getAlternativas().get(pos).getIndCerta();

        if(indCerto.equals("S")){
            q.setIndSituacao("C");
            QuestaoDAO.update(this, q);

            alertDialog.setTitle("Parabéns");
            alertDialog.setMessage("Esta é a resposta correta.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            if(questoes.size() < questao + 1){
                                finish();
                            } else{
                                questao++;
                                montaQuestao();
                            }
                        }
                    });
        } else {
            q.setIndSituacao("E");
            QuestaoDAO.update(this, q);

            alertDialog.setTitle("ERRRRRROOOOOOOOOOOOOOOOOOOOOOU");
            alertDialog.setMessage("Esta alternativa irá para o final da fila para ser respondida novamente.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            questoes.add(questoes.get(questao));
                            questao++;
                            montaQuestao();
                            dialog.dismiss();
                        }
                    });
        }
        alertDialog.show();

    }




}
