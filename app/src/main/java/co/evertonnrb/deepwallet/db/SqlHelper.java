package co.evertonnrb.deepwallet.db;/*
    @author everton.nrb@gmail.com
*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db.deep";
    private static final int VERSAO = 1;

    public static final String NOME_TABELA_DESPESA = "despesa";

    public static final String COLUNA_ID_DESPESA = "id";
    public static final String COLUNA_DESC_DESPESA = "desc";
    public static final String COLUNA_VALOR_DESPESA = "valor";
    public static final String COLUNA_DATA_DESPESA = "data";
    public static final String COLUNA_TIPO_DESPESA = "tipo";


    public SqlHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE "+ NOME_TABELA_DESPESA +"("+
                        COLUNA_ID_DESPESA+" INTEGER PRIMARY KEY,"+
                        COLUNA_DESC_DESPESA+"TEXT NOT NULL,"+
                        COLUNA_VALOR_DESPESA+"REAL NOT NULL,"+
                        COLUNA_DATA_DESPESA +"TEXT, "+
                        COLUNA_TIPO_DESPESA +"TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
