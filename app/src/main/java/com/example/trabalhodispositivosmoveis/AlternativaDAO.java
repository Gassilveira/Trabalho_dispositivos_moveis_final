package com.example.trabalhodispositivosmoveis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AlternativaDAO {
    public static List<Alternativa> getAlternartivas(Context context, int Questao){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        List<Alternativa> lista = new ArrayList<>();

        Cursor cursor = db.rawQuery(
                "SELECT idAlternativa, idQuestao, texto, indCerta " +
                        "FROM alternativa " +
                        "WHERE idQuestao =  " + Questao +
                        " ORDER BY idAlternativa",
                null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{

                Alternativa a = new Alternativa();
                a.setIdAlternativa(cursor.getInt(0));
                a.setIdQuestao(cursor.getInt(1));
                a.setTexto(cursor.getString(2));
                a.setIndCerta(cursor.getString(3));

                lista.add(a);
            }while (cursor.moveToNext());
        }

        cursor.close();

        return lista;
    }
}
