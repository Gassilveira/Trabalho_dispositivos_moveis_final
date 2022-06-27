package com.example.trabalhodispositivosmoveis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MateriaDAO {
    public static List<Materia> getMaterias(Context context){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        List<Materia> lista = new ArrayList<>();

        Cursor cursor = db.rawQuery(
                "SELECT idMateria, MAX(nome), COUNT(*) as qtdQuestoes, SUM(CASE WHEN questao.indSituacao = 'C' THEN 1 ELSE 0 END) as qtdCertas, SUM(CASE WHEN questao.indSituacao = 'E' THEN 1 ELSE 0 END) as qtdErradas " +
                        "FROM materia INNER JOIN questao ON materia.idMateria = questao.idMateria " +
                        "GROUP BY idMateria " +
                        "ORDER BY idMateria",
                null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{

                Materia m = new Materia();
                m.setIdMateria(cursor.getInt(0));
                m.setNome(cursor.getString(1));
                m.setQtdQuestoes(cursor.getFloat(2));
                m.setQtdCertas(cursor.getFloat(3));
                m.setQtdErradas(cursor.getFloat(4));

                lista.add(m);
            }while (cursor.moveToNext());
        }

        cursor.close();

        return lista;
    }
}
