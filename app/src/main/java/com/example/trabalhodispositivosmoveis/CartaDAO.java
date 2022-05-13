package com.example.trabalhodispositivosmoveis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CartaDAO {
    public static void insert(Context context, Carta carta){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", carta.getNome());
        valores.put("qtdOwnded", carta.getQtdOwned());
        valores.put("cmc", carta.getCmc());
        valores.put("indFoil", carta.getInfFoil());

        db.insert("carta", null, valores);

        db.close();
    }

    public static void update(Context context, Carta carta){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", carta.getNome());
        valores.put("cmc", carta.getCmc());
        valores.put("qtdOwned", carta.getQtdOwned());
        valores.put("indFoil", carta.getInfFoil());

        db.update("carta", valores, " id = " + carta.getId(), null);

        db.close();
    }

    public static void delete(Context context, int idCarta){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.delete("carta", " id = " + idCarta, null);

        db.close();
    }

    public static List<Carta> getCartas(Context context){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        List<Carta> lista = new ArrayList<>();

        Cursor cursor = db.rawQuery(
                "SELECT id, nome, cmc, qtdOwnded, indFoil " +
                        "FROM carta " +
                        "ORDER BY nome",
                null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{

                Carta c = new Carta();
                c.setId(cursor.getInt(0));
                c.setNome(cursor.getString(1));
                c.setCmc(cursor.getInt(2));
                c.setQtdOwned(cursor.getInt(3));
                c.setInfFoil(cursor.getString(4));

                lista.add(c);
            }while (cursor.moveToNext());
        }

        cursor.close();

        return lista;
    }
}
