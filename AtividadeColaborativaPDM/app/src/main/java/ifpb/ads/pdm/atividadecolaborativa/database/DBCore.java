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
        db.execSQL(sqldb());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    private String sqldb(){
        return " create table post(\n" +
                "\ttitle text,\n" +
                "\tdescription text,\n" +
                "\tlink text,\n" +
                "\tauthor text,\n" +
                "\tguid text primary key,\n" +
                "\tpubDate text,\n" +
                "\tcontentEncoded text\n" +
                ");";
    }
}
