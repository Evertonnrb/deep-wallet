package co.evertonnrb.deepwallet.db;/*
    @author everton.nrb@gmail.com
*/

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import co.evertonnrb.deepwallet.model.Despeda;

public class DespesaRepository {

    private SqlHelper helper;

    public DespesaRepository(Context context) {
        helper = new SqlHelper(context);
    }

    public long save(Despeda despeda) {

        SQLiteDatabase writrDb = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(SqlHelper.COLUNA_TIPO_DESPESA, despeda.getTipo());
        values.put(SqlHelper.COLUNA_DESC_DESPESA, despeda.getDesc());
        values.put(SqlHelper.COLUNA_DATA_DESPESA, String.valueOf(despeda.getData()));
        values.put(SqlHelper.COLUNA_VALOR_DESPESA, String.valueOf(despeda.getValor()));
        long id = writrDb.insert(SqlHelper.NOME_TABELA_DESPESA, null, values);
        writrDb.close();
        return id;
    }

    public boolean update(Despeda despeda) {
        SQLiteDatabase readDb = helper.getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put(SqlHelper.COLUNA_ID_DESPESA, despeda.getId());
        values.put(SqlHelper.COLUNA_TIPO_DESPESA, despeda.getTipo());
        values.put(SqlHelper.COLUNA_DESC_DESPESA, despeda.getDesc());
        values.put(SqlHelper.COLUNA_DATA_DESPESA, String.valueOf(despeda.getData()));
        values.put(SqlHelper.COLUNA_VALOR_DESPESA, String.valueOf(despeda.getValor()));
        int rowsAffected = readDb.update(
                SqlHelper.NOME_TABELA_DESPESA,
                values,
                SqlHelper.COLUNA_ID_DESPESA + "=?",
                new String[]{String.valueOf(despeda.getId())});
        readDb.close();
        return rowsAffected > 0;
    }

    public boolean delete(Despeda despeda) {
        SQLiteDatabase writrDb = helper.getWritableDatabase();
        int rowsAffected = writrDb.delete(
                SqlHelper.NOME_TABELA_DESPESA,
                SqlHelper.COLUNA_ID_DESPESA + "=?",
                new String[]{String.valueOf(despeda.getId())});
        writrDb.close();
        return rowsAffected > 0;
    }

    public List<Despeda> findAll() {
        SQLiteDatabase readDb = helper.getReadableDatabase();
        List<Despeda> despedas = new ArrayList<>();
        String sql = "SELECT * FROM " + SqlHelper.NOME_TABELA_DESPESA;
        Cursor cursor = readDb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(SqlHelper.COLUNA_ID_DESPESA));
            String desc = cursor.getString(cursor.getColumnIndex(SqlHelper.COLUNA_DESC_DESPESA));
            double valor = cursor.getDouble(cursor.getColumnIndex(SqlHelper.COLUNA_VALOR_DESPESA));
            String data = cursor.getString(cursor.getColumnIndex(SqlHelper.COLUNA_DATA_DESPESA));
            String tipo = cursor.getString(cursor.getColumnIndex(SqlHelper.COLUNA_TIPO_DESPESA));
            Despeda despeda = new Despeda(id, desc, valor, data, tipo);
            despedas.add(despeda);
        }
        return despedas;
    }


}
