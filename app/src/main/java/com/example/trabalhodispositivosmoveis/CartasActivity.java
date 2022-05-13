package com.example.trabalhodispositivosmoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class CartasActivity extends AppCompatActivity {

    private ListView lvCartas;
    private Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartas);

        lvCartas = findViewById(R.id.lvCartas);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartasActivity.this, MainActivity.class);
                intent.putExtra("acao", "inserir");
                startActivity( intent );
            }
        });
        }
        @Override
        protected void onStart(){
            super.onStart();
            CartaDAO.insert(this, new Carta("Nenhuma carta", 2, 2, "N"));
            carregarCartas();
        }

    protected void carregarCartas() {
        List<Carta> lista = CartaDAO.getCartas(this);

        if(lista.size() == 0){
            Carta fake = new Carta("Nenhuma carta encontrada", 0, 0, "N");
            lista.add(fake);
            lvCartas.setEnabled( false );
        } else {
            lvCartas.setEnabled( true );
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lista);
        lvCartas.setAdapter( adapter );
    }
}
