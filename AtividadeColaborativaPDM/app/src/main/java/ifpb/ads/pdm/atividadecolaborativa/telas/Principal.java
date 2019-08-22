package ifpb.ads.pdm.atividadecolaborativa.telas;


import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.common.util.DeviceProperties;

import ifpb.ads.pdm.atividadecolaborativa.component.ButtonComponent;
import ifpb.ads.pdm.atividadecolaborativa.control.Control;


public class Principal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layoutMain = new LinearLayout(this);
        layoutMain.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        );
        layoutMain.setGravity(Gravity.CENTER_HORIZONTAL);
        layoutMain.setPadding(0,0,0,0);
        layoutMain.setOrientation(LinearLayout.VERTICAL);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;


        LinearLayout layoutForm = new LinearLayout(this);
        layoutForm.setOrientation(LinearLayout.VERTICAL);
        layoutForm.setGravity(Gravity.CENTER_HORIZONTAL);
        layoutForm.setPadding(10,0,10,10);

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
    }
}
