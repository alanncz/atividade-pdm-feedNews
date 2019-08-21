package ifpb.ads.pdm.atividadecolaborativa.telas;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

import ifpb.ads.pdm.atividadecolaborativa.layout.BoxNoticia;
import ifpb.ads.pdm.atividadecolaborativa.database.DB;

public class Principal extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String titulo = "caio";
    private String descricao = "ola";
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        //<Relative LAYOUT>
        RelativeLayout root = new RelativeLayout(this);
        root.setLayoutParams(
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT
                )
        );

        root.setBackgroundColor(Color.WHITE);
        root.setGravity(Gravity.CENTER);
        setContentView(root);

        Button sair = new Button(this);
        sair.setWidth(200);
        sair.setText("Sair");
        sair.setOnClickListener(view -> {
            mAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        root.addView(sair);



        BoxNoticia box01 = new BoxNoticia(this,titulo,descricao,uri);

        root.addView(box01);



    }
}