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
        tab.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));

        tab.setColumnStretchable(1, true);
        tab.setBackgroundColor(Color.WHITE);

        TableRow linha = new TableRow(this);
        linha.setGravity(Gravity.TOP);
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.images);
        linha.addView(img);

        TableRow linha1 = new TableRow(this);
        TextView email = new TextView(this);
        email.setText("Email: ");
        linha1.addView(email);

        EditText temail = new EditText(this);
        temail.requestFocus();
        linha1.addView(temail);

        TableRow linha2 = new TableRow(this);
        TextView senha = new TextView(this);
        senha.setText("Senha");
        linha2.addView(senha);

        EditText tsenha = new EditText(this);
        tsenha.setTransformationMethod(new PasswordTransformationMethod());
        linha2.addView(tsenha);

        TableRow linha3 = new TableRow(this);
        linha3.setGravity(Gravity.CENTER);
        Button bt = new Button(this);
        bt.setText("Entrar");
        linha3.addView(bt);

        TableRow linha4 = new TableRow(this);
        linha4.setGravity(Gravity.CENTER);
        TextView cadastrar = new TextView(this);
        cadastrar.setText("Cadastre-se");
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(intent);
            }
        });
        linha4.addView(cadastrar);

        tab.addView(linha);//Não tava pegando pq faltou adicionar essa linha na tabela
        tab.addView(linha1);
        tab.addView(linha2);
        tab.addView(linha3);
        tab.addView(linha4);

        setContentView(tab);

    }
}
