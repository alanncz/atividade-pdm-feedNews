package com.ifpb.atividadecolaborativa_pdm;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

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
        EditText temail = new EditText(this);
        temail.requestFocus();
        linha3.addView(temail);

        TableRow linha4 = new TableRow(this);
        TextView senha = new TextView(this);
        senha.setText("Senha");
        linha4.addView(senha);

        TableRow linha5 = new TableRow(this);
        EditText tsenha = new EditText(this);
        tsenha.setTransformationMethod(new PasswordTransformationMethod());
        linha5.addView(tsenha);

        TableRow linha6 = new TableRow(this);
        linha6.setGravity(Gravity.CENTER);
        Button bt = new Button(this);
        bt.setText("Entrar");
        linha6.addView(bt);

        //TableRow linha7 = new TableRow(this);
        //linha7.setGravity(Gravity.CENTER);
        //TextView cadastrar = new TextView(this);
        //cadastrar.setText("Cadastre-se");
        //cadastrar.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Intent intent = new Intent(getApplicationContext(), Cadastro.class);
        //        startActivity(intent);
        //    }
        //});
        //linha7.addView(cadastrar);

        tab.addView(linha0);
        tab.addView(linha1);//Não tava pegando pq faltou adicionar essa linha na tabela
        tab.addView(linha2);
        tab.addView(linha3);
        tab.addView(linha4);
        tab.addView(linha5);
        tab.addView(linha6);



        setContentView(tab);

    }
}
