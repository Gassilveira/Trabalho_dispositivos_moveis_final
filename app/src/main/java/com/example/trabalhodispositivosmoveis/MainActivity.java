package com.example.trabalhodispositivosmoveis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                salvarLivro();
            }
        });
    }

    public void salvarLivro(){

        EditText txtNomeCarta = (EditText) findViewById(R.id.txtNomeCarta);
        EditText txtCmcCarta = (EditText) findViewById(R.id.txtCmcCarta);
        EditText txtQtdOwnedCarta = (EditText) findViewById(R.id.txtQtdOwnedCarta);
        RadioButton optFoil = (RadioButton) findViewById(R.id.optFoil);

        Carta carta = new Carta();

        String nome = txtNomeCarta.getText().toString();
        int cmc = 0;
        int qtdOwned = 0;

        if(!txtCmcCarta.getText().toString().isEmpty())
            cmc = Integer.parseInt(txtCmcCarta.getText().toString());

        if(!txtQtdOwnedCarta.getText().toString().isEmpty())
            qtdOwned = Integer.parseInt(txtQtdOwnedCarta.getText().toString());

        if(!nome.isEmpty()){
            carta.setNome(nome);
            carta.setCmc(cmc);
            carta.setQtdOwned(qtdOwned);
            if(optFoil.isChecked()){
                carta.setInfFoil("S");
            }
            else carta.setInfFoil("N");

            CartaDAO.insert(MainActivity.this, carta);

        }

        Intent intent = new Intent(MainActivity.this, CartasActivity.class);
        startActivity( intent );
    }
}