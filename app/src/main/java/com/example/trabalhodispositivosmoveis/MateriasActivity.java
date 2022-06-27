package com.example.trabalhodispositivosmoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MateriasActivity extends AppCompatActivity {

    private ListView lvMaterias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

        lvMaterias = findViewById(R.id.lvMaterias);

        }
        @Override
        protected void onStart(){
            super.onStart();
            Banco conn = new Banco(this);
            carregarMaterias();
        }

    protected void carregarMaterias(){
        List<Materia> lista = MateriaDAO.getMaterias(this);

        lvMaterias.setEnabled( true );

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lista);
        lvMaterias.setAdapter( adapter );
    }
}
