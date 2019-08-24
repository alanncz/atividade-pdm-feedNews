package ifpb.ads.pdm.atividadecolaborativa.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ifpb.ads.pdm.atividadecolaborativa.model.FeedMessage;

public class PostComponent extends LinearLayout {

    private TextView title;
    private TextView description;
    private TextView data;
    private LinearLayout layoutInfo;
    private LinearLayout layoutImg;

    public PostComponent(Activity screen, FeedMessage post) {
        super(screen);
        this.init(screen, post);

        if(post.getImgDrawable() != null){
            this.noticeWithLayoutImage(screen, post.getImgDrawable());
        }else{
            this.noticeWithoutLayoutImage(screen);
        }
    }

    private void init(Activity screen, FeedMessage post) {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);

        this.title = new TextView(screen);
        this.title.setText(post.getTitle());
        this.title.setTextSize(20);

        this.description = new TextView(screen);
        this.description.setText(post.getDescription());
        this.description.setTextSize(14);
        this.description.setPadding(0,10,0,0);

        this.data = new TextView(screen);
        this.data.setText(post.getPubDate());
        this.data.setTextSize(16);
        this.data.setPadding(0,10,0,0);
    }

    private void noticeWithoutLayoutImage(Context context){
        this.layoutInfo = new LinearLayout(context);
        this.layoutInfo.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.layoutInfo.setOrientation(VERTICAL);
        addView(this.layoutInfo);
        this.layoutInfo.addView(this.title);
        this.layoutInfo.addView(this.description);
        this.layoutInfo.addView(this.data);
    }

    private void noticeWithLayoutImage(Context context, Drawable imgNotice){
        this.layoutImg = new LinearLayout(context);
        this.layoutImg.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.layoutImg.setOrientation(HORIZONTAL);
        this.layoutImg.setPadding(20,20,20,20);
        addView(this.layoutImg);

        LinearLayout columInfo = new LinearLayout(this.layoutImg.getContext());
        columInfo.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        columInfo.setOrientation(VERTICAL);

        columInfo.addView(this.title);
        columInfo.addView(this.description);
        columInfo.addView(this.data);

        LinearLayout columImg = new LinearLayout(this.layoutImg.getContext());
        columImg.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        columImg.setOrientation(VERTICAL);
        columImg.setGravity(Gravity.CENTER_VERTICAL);

        ImageView postCover = new ImageView(context);
        postCover.setImageDrawable(imgNotice);

        postCover.setAdjustViewBounds(true);
        postCover.setMaxWidth(300);
        postCover.setMaxHeight(300);

        columImg.addView(postCover);

        this.layoutImg.addView(columInfo);
        this.layoutImg.addView(columImg);
    }
}
