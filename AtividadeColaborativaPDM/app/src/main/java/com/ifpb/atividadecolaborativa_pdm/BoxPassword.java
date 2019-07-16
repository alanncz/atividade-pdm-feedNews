package com.ifpb.atividadecolaborativa_pdm;

import android.content.Context;
import android.graphics.Color;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BoxPassword extends LinearLayout{

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
        et.setTransformationMethod(new PasswordTransformationMethod());
        addView(et);
    }

    public BoxPassword(Context context, String name) {
        super(context);
        this.name = name;
        init();
    }

    public String getValor(){
        return et.getText().toString();
    }
}
