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
                "SELECT materia.idMateria, MAX(materia.nome), COUNT(*) as qtdQuestoes, SUM(CASE WHEN questao.indSituacao = 'C' THEN 1 ELSE 0 END) as qtdCertas, SUM(CASE WHEN questao.indSituacao = 'E' THEN 1 ELSE 0 END) as qtdErradas " +
                        "FROM materia INNER JOIN questao ON materia.idMateria = questao.idMateria " +
                        "GROUP BY materia.idMateria " +
                        "ORDER BY materia.idMateria",
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

    public static void criaMaterias(Context context){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

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
}
