package ifpb.ads.pdm.atividadecolaborativa.telas;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import com.ifpb.atividadecolaborativa_pdm.R;

import ifpb.ads.pdm.atividadecolaborativa.control.Control;
import ifpb.ads.pdm.atividadecolaborativa.model.User;


public class Login extends AppCompatActivity {

    private EditText temail;
    private EditText tsenha;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;

        SharedPreferences sharedPreferences = getSharedPreferences("authenticatedUser", MODE_PRIVATE);
        boolean autenticado = sharedPreferences.getBoolean("logado", false);
        if(autenticado){
            startActivity(new Intent(this, Principal.class));
        }

        TableLayout tab = new TableLayout(this);
        tab.setLayoutParams(
                new LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT
                )
        );

        tab.setColumnStretchable(1, true);
        tab.setBackgroundColor(Color.WHITE);

        TableRow linha0 = new TableRow(this);
        linha0.setGravity(Gravity.CENTER);
        TextView login = new TextView(this);
        login.setGravity(Gravity.CENTER);
        login.setText("Login");
        login.setTextSize(40f);
        linha0.addView(login);

        TableRow linha1 = new TableRow(this);
        linha1.setGravity(Gravity.CENTER);
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.images);
        linha1.addView(img);

        TableRow linha2 = new TableRow(this);
        TextView email = new TextView(this);
        email.setText("Email:");
        linha2.addView(email);

        TableRow linha3 = new TableRow(this);
        temail = new EditText(this);
        temail.requestFocus();
        linha3.addView(temail);

        TableRow linha4 = new TableRow(this);
        TextView senha = new TextView(this);
        senha.setText("Senha");
        linha4.addView(senha);

        TableRow linha5 = new TableRow(this);
        tsenha = new EditText(this);
        tsenha.setTransformationMethod(new PasswordTransformationMethod());
        linha5.addView(tsenha);

        TableRow linha6 = new TableRow(this);
        linha6.setGravity(Gravity.CENTER);
        Button bt = new Button(this);
        bt.setText("Entrar");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Control control = new Control(context);

                String email = temail.getText().toString();
                String password = tsenha.getText().toString();

                System.out.println(email);
                System.out.println(password);

                if(email!= null & password!= null) {
                    User user = control.login(email, password);
                    if(user != null) {
                        Intent intent = new Intent(getApplicationContext(), Principal.class);
                        startActivity(intent);
                    }
                }
            }
        });

        linha6.addView(bt);

        tab.addView(linha0);
        tab.addView(linha1);
        tab.addView(linha2);
        tab.addView(linha3);
        tab.addView(linha4);
        tab.addView(linha5);
        tab.addView(linha6);



        setContentView(tab);

    }
}
