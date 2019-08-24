package ifpb.ads.pdm.atividadecolaborativa.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBCore extends SQLiteOpenHelper {

    private static final String NOME_DB = "banco";
    private static final int VERSAO_BD = 1;

    public DBCore(@Nullable Context context) {
        super(context, NOME_DB, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqldbPost());
        db.execSQL(sqldbUsuario());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    private String sqldbPost(){
        return "create table post( \n" +
                "                title text,\n" +
                "                description text,\n" +
                "                link text,\n" +
                "                author text,\n" +
                "                guid text primary key,\n" +
                "                pubDate text,\n" +
                "                img text,\n" +
                "                contentEncoded text\n" +
                "               );";

    }

    private String sqldbUsuario(){
        return "create table usuario(\n" +
                "                name text,\n" +
                "                email text primary key,\n" +
                "                password text\n" +
                "               );";
    }
}
