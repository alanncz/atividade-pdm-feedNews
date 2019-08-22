package ifpb.ads.pdm.atividadecolaborativa.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ifpb.ads.pdm.atividadecolaborativa.model.Feed;
import ifpb.ads.pdm.atividadecolaborativa.model.FeedMessage;
import ifpb.ads.pdm.atividadecolaborativa.model.User;

public class DB {

    private SQLiteDatabase db;

    public DB(Context context){
        DBCore db = new DBCore(context);
        this.db = db.getWritableDatabase();
    }

    public void inserir(User user){
            ContentValues values = new ContentValues();
            values.put("name", user.getName());
            values.put("email", user.getEmail());
            values.put("password", user.getPassword());
            db.insert("usuario", null, values);

            System.out.println(user.getName() + " foi cadastrado com sucesso");

    }

    public User getUser(String email, String password){

        if(email != null & password!= null) {
            String[] coluns = new String[]{"name", "email", "password"};
            String selection = "email = ? and password = ?";
            String[] arguments = new String[]{email, password};

            Cursor cursor = db.query("usuario", coluns, selection, arguments, null, null, "name DESC");

            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    User user = new User();
                    user.setName(cursor.getString(0));
                    user.setEmail(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    return user;
                }
            }
        }

        return null;
    }

    public void inserir(Feed feed){

        ContentValues values = new ContentValues();

        List<String> ids = listarIds();
        int cont = 0;

        for (FeedMessage fm : feed.getEntries()){
            if(!isId(ids, fm.getGuid())){
                values.put("title", fm.getTitle());
                values.put("description", fm.getDescription());
                values.put("link", fm.getLink());
                values.put("author", fm.getAuthor());
                values.put("guid", fm.getGuid());
                values.put("pubDate", fm.getPubDate());
                values.put("contentEncoded", fm.getContentEncoded());
                db.insert("post", null, values);
                values.clear();
                cont++;
            }

        }
        System.out.println("Foram inseridos - " + cont + " posts de " + feed.getTitle());

    }

    public List<FeedMessage> listar(){
        List<FeedMessage> list = new ArrayList<>();
        String[] colunas = new String[]{"title", "description", "link", "author", "guid", "pubDate", "contentEncoded"};

        Cursor cursor = db.query("post",colunas,null ,null,null,null, "pubDate DESC");

        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                FeedMessage fm = new FeedMessage();
                fm.setTitle(cursor.getString(0));
                fm.setDescription(cursor.getString(1));
                fm.setLink(cursor.getString(2));
                fm.setAuthor(cursor.getString(3));
                fm.setGuid(cursor.getString(4));
                fm.setPubDate(cursor.getString(5));
                fm.setContentEncoded(cursor.getString(6));
                list.add(fm);
            }
        }

        return list;
    }

    public List<String> listarIds(){
        List<String> list = new ArrayList<>();
        String[] colunas = new String[]{"guid"};

        Cursor cursor = db.query("post",colunas,null ,null,null,null, "pubDate DESC");

        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                list.add(cursor.getString(0));
            }
        }

        return list;
    }

    private boolean isId(List<String> ids, String id){
        for(String idaux : ids){
            if (idaux.compareTo(id) == 0) return true;
        }

        return false;

    }
}
