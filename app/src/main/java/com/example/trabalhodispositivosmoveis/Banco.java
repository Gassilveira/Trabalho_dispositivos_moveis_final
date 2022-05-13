package com.example.trabalhodispositivosmoveis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME = "Colecao";

    public Banco(Context context){
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS carta(" +
                   "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                   "nome TEXT NOT NULL," +
                   "qtdOwnded INTEGER," +
                   "cmc INT," +
                   "indFoil TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }
}
