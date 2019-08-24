package ifpb.ads.pdm.atividadecolaborativa.component;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewsUniqueComponent extends LinearLayout {

    private String title;
    private String contentEncoded;
    private String data;
    private ImageView imgNews;
    private WindowManager windowManager;

    public NewsUniqueComponent(Context context, String title, String contentEncoded, String data, WindowManager windowManager) {
        super(context);
        this.title = title;
        this.contentEncoded = contentEncoded;
        this.data = data;
        this.windowManager = windowManager;
        init();
    }

    public NewsUniqueComponent(Context context, String title, String contentEncoded, String data, WindowManager windowManager, ImageView imgNews) {
        super(context);
        this.title = title;
        this.contentEncoded = contentEncoded;
        this.data = data;
        this.windowManager = windowManager;
        this.imgNews = imgNews;
        init();
    }


    public void init(){
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int height = size.x;
        int width = size.y;


        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        setOrientation(VERTICAL);
        setPadding(30, 30, 30, 30);

        if(imgNews!=null){
            imgNews.setAdjustViewBounds(true);
            imgNews.setMaxHeight(height);
            imgNews.setMaxWidth(width);
            addView(imgNews);
        }
        TextView textViewTitulo = new TextView(getContext());
        textViewTitulo.setText("\n"+title);
        textViewTitulo.setTextSize(21);
        textViewTitulo.setWidth(width);


        TextView textViewConteudo = new TextView(getContext());
        textViewConteudo.setText("\n"+contentEncoded);
        textViewConteudo.setTextSize(17);
        textViewConteudo.setWidth(width);

        addView(textViewTitulo);
        addView(textViewConteudo);

    }
}
