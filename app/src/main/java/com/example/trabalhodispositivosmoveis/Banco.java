package com.example.trabalhodispositivosmoveis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO = 2;
    private static final String NOME = "Questionario";

    public Banco(Context context){
        super(context, NOME, null, VERSAO);
        onCreate(this.getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS materia (" +
                   "idMateria INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                   "nome TEXT);");

        db.execSQL("CREATE TABLE IF NOT EXISTS questao (" +
                "idQuestao INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "enunciado TEXT," +
                "indSituacao TEXT," +
                "idMateria INT);");

        db.execSQL("CREATE TABLE IF NOT EXISTS alternativa (" +
                "idAlternativa INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "idQuestao INTEGER," +
                "texto TEXT," +
                "indCerta TEXT);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }
}
