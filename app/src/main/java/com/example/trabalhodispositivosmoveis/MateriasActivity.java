package com.example.trabalhodispositivosmoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MateriasActivity extends AppCompatActivity {

    private ListView lvMaterias;

    private List<Materia> listaMaterias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

        lvMaterias = findViewById(R.id.lvMaterias);

        }
        @Override
        protected void onStart(){
            super.onStart();
            listaMaterias = carregarMaterias();

            lvMaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MateriasActivity.this, MainActivity.class);
                    intent.putExtra("Materia", listaMaterias.get(position).getIdMateria());
                    startActivity( intent );
                }
            });
        }

    protected List<Materia> carregarMaterias(){
        List<Materia> lista = MateriaDAO.getMaterias(this);

        if(lista.size() == 0){
            MateriaDAO.criaMaterias(this);
            lista = MateriaDAO.getMaterias(this);
        }

        lvMaterias.setEnabled( true );

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lista);
        lvMaterias.setAdapter( adapter );

        return lista;
    }
}
