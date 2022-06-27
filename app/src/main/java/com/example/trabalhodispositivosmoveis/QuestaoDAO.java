package com.example.trabalhodispositivosmoveis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class QuestaoDAO {

    public static void update(Context context, Questao questao){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("indSituacao", questao.getIndSituacao());

        db.update("questao", valores, " idQuestao = " + questao.getIdQuestao(), null);

        db.close();
    }

    public static List<Questao> getQuestao(Context context, int materia){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        List<Questao> lista = new ArrayList<>();

        Cursor cursor = db.rawQuery(
                "SELECT idQuestao, enunciado, indSituacao, idMateria " +
                        "FROM questao " +
                        "WHERE idMateria = " + Integer.toString(materia) + " and indSituacao <> 'C' " +
                        "ORDER BY idQuestao",
                null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{

                Questao q = new Questao();
                q.setIdQuestao(cursor.getInt(0));
                q.setEnunciado(cursor.getString(1));
                q.setIndSituacao(cursor.getString(2));
                q.setIdMateria(cursor.getInt(3));

                lista.add(q);
            }while (cursor.moveToNext());
        }

        cursor.close();

        return lista;
    }
}
