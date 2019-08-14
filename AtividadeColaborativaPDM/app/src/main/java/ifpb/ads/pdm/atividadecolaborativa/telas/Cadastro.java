package ifpb.ads.pdm.atividadecolaborativa.telas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import ifpb.ads.pdm.atividadecolaborativa.layout.BoxPadrao;
import ifpb.ads.pdm.atividadecolaborativa.layout.BoxPassword;

public class Cadastro extends AppCompatActivity {

    private TextView tv;

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

        tv = new TextView(this);
        tv.setTextSize(40f);
        tv.setText("Cadastro");
        tv.setGravity(Gravity.CENTER);


        BoxPadrao box01 = new BoxPadrao(this, "Nome");
        //BoxPadrao box02 = new BoxPadrao (this, "Data de Nascimento");
        BoxPadrao box03 = new BoxPadrao (this, "Email");
        BoxPassword box04 = new BoxPassword (this, "Senha");
        BoxPassword box05 = new BoxPassword (this, "Confirmar Senha");

        root.addView(tv);
        root.addView(box01);
        //root.addView(box02);
        root.addView(box03);
        root.addView(box04);
        root.addView(box05);

        Button botao = new Button(this);
        botao.setText("Confirme");
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        root.addView(botao);


    }
}
