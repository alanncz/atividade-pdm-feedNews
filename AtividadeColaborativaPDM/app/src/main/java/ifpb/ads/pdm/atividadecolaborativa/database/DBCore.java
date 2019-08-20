package ifpb.ads.pdm.atividadecolaborativa.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

//classe de acesso ao SQLite
public class DataBase extends SQLiteOpenHelper {

    private static final String NOME_DB = "banco";
    private static final int VERSAO_BD = 1;

    public DataBase(@Nullable Context context) {
        super(context, NOME_DB, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqldb());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table feed;");
        db.execSQL("drop table post;");
        onCreate(db);

    }

    public String sqldb(){
        return "create table feed(\n" +
                "\tid autoincremet primary key,\n" +
                "\ttitle varchar,\n" +
                "\tlink varchar,\n" +
                "\tdescription varchar,\n" +
                "\tpubDate varchar\n" +
                "\t\n" +
                ");\n" +
                "\n" +

                "create table post(\n" +
                "\tid_feed int,\n" +
                "\ttitle varchar,\n" +
                "\tdescription varchar,\n" +
                "\tlink varchar,\n" +
                "\tauthor varchar,\n" +
                "\tguid varchar,\n" +
                "\tpubDate varchar,\n" +
                "\tcotendEncoded text,\n" +
                "\tCONSTRAINT post_id_feed_fkey FOREIGN KEY (id_feed) REFERENCES feed (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE\n" +
                ");";
    }
}
