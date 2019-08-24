package ifpb.ads.pdm.atividadecolaborativa.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImgComponent extends LinearLayout {

    private ImageView imageView;
    private Drawable drawable;

    public ImgComponent(Context context, Drawable drawable){
        super(context);
        this.drawable = drawable;
        init();
    }

    private void init() {
        int width = LayoutParams.WRAP_CONTENT;
        int heigth = LayoutParams.WRAP_CONTENT;
        setLayoutParams(new LayoutParams(width,heigth));
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_HORIZONTAL);

        imageView = new ImageView(getContext());
        imageView.setImageDrawable(drawable);

        addView(imageView);
    }
}
