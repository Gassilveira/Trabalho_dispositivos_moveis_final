package com.example.trabalhodispositivosmoveis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO = 2;
    private static final String NOME = "Questionario";

    public Banco(Context context){
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE  materia (" +
                   "idMateria INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                   "nome TEXT);");

        db.execSQL("CREATE TABLE  questao (" +
                "idQuestao INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "enunciado TEXT," +
                "indSituacao TEXT," +
                "idMateria INT);");

        db.execSQL("CREATE TABLE  alternativa (" +
                "idAlternativa INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "idQuestao INTEGER," +
                "texto TEXT," +
                "indCerta TEXT);");

        db.execSQL("INSERT INTO materia(nome)" +
                "VALUES('Materia 1')," +
                "('Materia 2')," +
                "('Materia 3')");

        db.execSQL("INSERT INTO questao(enunciado, indSituacao, idMateria)" +
                "VALUES('Questao 1', 'N', 1)," +
                "('Questao 2', 'N', 2)," +
                "('Questao 3', 'N', 3)," +
                "('Questao 4', 'N', 1)," +
                "('Questao 5', 'N', 2)," +
                "('Questao 6', 'N', 3)," +
                "('Questao 7', 'N', 1)," +
                "('Questao 8', 'N', 2)," +
                "('Questao 9', 'N', 3)" );

        db.execSQL("INSERT INTO alternativa(idQuestao, texto, indCerta)" +
                "VALUES(1, 'Opcao 1', 'N')," +
                "(1, 'Opcao 2', 'S')," +
                "(1, 'Opcao 3', 'N')," +
                "(1, 'Opcao 4', 'N')," +
                "(2, 'Opcao 1', 'S')," +
                "(2, 'Opcao 2', 'N')," +
                "(2, 'Opcao 3', 'N')," +
                "(3, 'Opcao 1', 'N')," +
                "(3, 'Opcao 2', 'N')," +
                "(3, 'Opcao 3', 'N')," +
                "(3, 'Opcao 4', 'S')," +
                "(4, 'Opcao 1', 'S')," +
                "(4, 'Opcao 2', 'N')," +
                "(4, 'Opcao 3', 'N')," +
                "(4, 'Opcao 4', 'N')," +
                "(4, 'Opcao 5', 'N')," +
                "(5, 'Opcao 1', 'N')," +
                "(5, 'Opcao 2', 'N')," +
                "(5, 'Opcao 3', 'S')," +
                "(5, 'Opcao 4', 'N')," +
                "(6, 'Opcao 1', 'S')," +
                "(6, 'Opcao 2', 'N')," +
                "(6, 'Opcao 3', 'N')," +
                "(6, 'Opcao 4', 'N')," +
                "(7, 'Opcao 1', 'N')," +
                "(7, 'Opcao 2', 'S')," +
                "(7, 'Opcao 3', 'N')," +
                "(7, 'Opcao 4', 'N')," +
                "(8, 'Opcao 1', 'N')," +
                "(8, 'Opcao 2', 'S')," +
                "(8, 'Opcao 3', 'N')," +
                "(8, 'Opcao 4', 'N')," +
                "(9, 'Opcao 1', 'N')," +
                "(9, 'Opcao 2', 'S')," +
                "(9, 'Opcao 3', 'N')," +
                "(9, 'Opcao 4', 'N')," +
                "(9, 'Opcao 5', 'S')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }
}
