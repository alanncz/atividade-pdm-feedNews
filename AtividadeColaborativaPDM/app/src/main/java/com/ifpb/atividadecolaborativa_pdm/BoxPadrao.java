package com.ifpb.atividadecolaborativa_pdm;

import android.content.Context;
import android.graphics.Color;
import android.text.method.PasswordTransformationMethod;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.PasswordAuthentication;

public class BoxPadrao extends LinearLayout {

    private final String name;
    private TextView tv;
    private EditText et;

    private void init(){
        LayoutParams parametrosLayout = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        setLayoutParams(parametrosLayout);
        setBackgroundColor(Color.WHITE);
        setOrientation(LinearLayout.VERTICAL);

        //LABEL
        tv = new TextView(getContext());
        tv.setText(name);
        addView(tv);

        //INPUT
        et = new EditText(getContext());
        addView(et);
    }

    public BoxPadrao(Context ctx, String name) {
        super(ctx);
        this.name = name;
        init();
    }


    public String getValor(){
        return et.getText().toString();
    }
}
