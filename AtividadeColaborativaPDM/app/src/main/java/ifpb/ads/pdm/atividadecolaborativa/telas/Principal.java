package ifpb.ads.pdm.atividadecolaborativa.telas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;


import ifpb.ads.pdm.atividadecolaborativa.component.ButtonComponent;
import ifpb.ads.pdm.atividadecolaborativa.component.RefreshNoticesComponent;
import ifpb.ads.pdm.atividadecolaborativa.control.Control;


public class Principal extends AppCompatActivity {

    private RefreshNoticesComponent rnc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layoutMain = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        );
        layoutMain.setLayoutParams(layoutParams);
        layoutMain.setOrientation(LinearLayout.VERTICAL);


        LinearLayout layoutForm = new LinearLayout(this);
        layoutForm.setOrientation(LinearLayout.VERTICAL);
        layoutForm.setGravity(Gravity.RIGHT);
        layoutForm.setPadding(10, 0, 10, 10);

        ButtonComponent bc = new ButtonComponent(this, "Sair");
        bc.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Control control = new Control(getApplicationContext());
                control.logout();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        layoutForm.addView(bc);

        setContentView(layoutMain);
        layoutMain.addView(layoutForm);


        rnc = new RefreshNoticesComponent(this);
        layoutMain.addView(rnc);
    }
}
