package ifpb.ads.pdm.atividadecolaborativa.telas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ifpb.atividadecolaborativa_pdm.R;

public class MainActivity extends Activity {

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
        root.setGravity(Gravity.CENTER);
        setContentView(root);
        //</LINEAR LAYOUT>

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.androids);
        img.setAdjustViewBounds(true);
        img.setMaxHeight(500);
        root.addView(img);

        LinearLayout rootT = new LinearLayout(this);
        rootT.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        300
                )
        );
        rootT.setBackgroundColor(Color.WHITE);
        rootT.setOrientation(LinearLayout.HORIZONTAL);
        rootT.setGravity(Gravity.CENTER);

        TextView nomeAplicativo = new TextView(this);
        nomeAplicativo.setTextSize(20);
        nomeAplicativo.setPaintFlags(Paint.FAKE_BOLD_TEXT_FLAG);
        //nomeAplicativo.setMaxHeight(24);
        nomeAplicativo.setText("Nome do Aplicativo");
        rootT.addView(nomeAplicativo);
        root.addView(rootT);

        LinearLayout rootB = new LinearLayout(this);
        rootB.setLayoutParams(
                new LinearLayout.LayoutParams(
                        400,
                        400
                )
        );
        rootB.setBackgroundColor(Color.WHITE);
        rootB.setOrientation(LinearLayout.VERTICAL);
        //rootB.setGravity(Gravity.CENTER);

        Button login = new Button(this);
        //login.setWidth(200);
        //login.setMaxWidth(100);
        login.setText("Login");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        //root.addView(login);

        Button cadastro = new Button(this);
        cadastro.setText("Cadastro");
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(intent);
            }
        });
        //root.addView(cadastro);

        rootB.addView(login);
        rootB.addView(cadastro);
        root.addView(rootB);

    }

}
