package ifpb.ads.pdm.atividadecolaborativa.control;

import android.content.Context;
import android.content.SharedPreferences;

import ifpb.ads.pdm.atividadecolaborativa.database.DB;
import ifpb.ads.pdm.atividadecolaborativa.model.User;

public class Control {

    private Context context;
    private DB db;

    public Control(Context context){
        this.context = context;
        db = new DB(context);
    }

    public User login(String email, String password){

            User user = db.getUser(email,password);
            if(user!= null) {
                    SharedPreferences.Editor editor = context.getSharedPreferences("authenticatedUser", Context.MODE_PRIVATE).edit();
                    editor.putBoolean("logado", true);
                    editor.putString("name", user.getName());
                    editor.putString("email", user.getEmail());
                    editor.putString("password", user.getPassword());
                    editor.apply();
                    return user;
            }

        return null;
    }

    public void logout(){
        SharedPreferences mySPrefs = context.getSharedPreferences("authenticatedUser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySPrefs.edit();
        editor.remove("logado");
        editor.remove("name");
        editor.remove("email");
        editor.remove("password");
        editor.apply();
    }
}
