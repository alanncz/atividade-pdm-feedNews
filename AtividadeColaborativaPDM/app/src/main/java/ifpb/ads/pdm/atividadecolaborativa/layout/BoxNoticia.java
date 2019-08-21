package ifpb.ads.pdm.atividadecolaborativa.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.URL;

public class BoxNoticia extends RelativeLayout {

    private ImageView img;
    private String src;
    private final String tituloname;
    private final String descricaoname;
    private TextView titulo;
    private TextView descricao;

    private void init(){

        LayoutParams parametrosLayout = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );

        setLayoutParams(parametrosLayout);
        setBackgroundColor(Color.WHITE);
        setGravity(Gravity.CENTER);

        img = new ImageView(getContext());

        img.setImageURI();
        addView(img);

        titulo = new TextView(getContext());
        titulo.setText(tituloname);
        addView(titulo);

        descricao = new TextView(getContext());
        descricao.setText(descricaoname);
        addView(descricao);

    }

    public BoxNoticia(Context context, String tituloname , String descricaoname, String src) {
        super(context);
        this.tituloname = tituloname;
        this.descricaoname = descricaoname;
        this.src = src;
        init();
    }
}
