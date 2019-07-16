package com.ifpb.atividadecolaborativa_pdm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //<LINEAR LAYOUT>
        LinearLayout root = new LinearLayout(this);
        root.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                )
        );

        root.setBackgroundColor(Color.WHITE);
        root.setOrientation(LinearLayout.VERTICAL);
        setContentView(root);
        //</LINEAR LAYOUT>


        BoxPadrao box01 = new BoxPadrao(this, "Nome");
        BoxPadrao box02 = new BoxPadrao (this, "Data de Nascimento");
        BoxPadrao box03 = new BoxPadrao (this, "Email");
        BoxPassword box04 = new BoxPassword (this, "Senha");
        BoxPassword box05 = new BoxPassword (this, "Confirmar Senha");

        root.addView(box01);
        root.addView(box02);
        root.addView(box03);
        root.addView(box04);
        root.addView(box05);

        Button botao = new Button(this);
        botao.setText("Cadastrar");

        root.addView(botao);


    }
}
