package ifpb.ads.pdm.atividadecolaborativa.telas;


import android.content.Intent;
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

//import androidx.annotation.NonNull;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.Toast;
import com.ifpb.atividadecolaborativa_pdm.R;


public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText temail;
    private EditText tsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

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
                mAuth.signInWithEmailAndPassword(temail.getText().toString(), tsenha.getText().toString())
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Intent intent = new Intent(Login.this, Principal.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }


                            }
                        });
            }
        });
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
