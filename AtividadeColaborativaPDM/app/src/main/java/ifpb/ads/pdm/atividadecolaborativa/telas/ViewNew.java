package ifpb.ads.pdm.atividadecolaborativa.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import ifpb.ads.pdm.atividadecolaborativa.component.ButtonComponent;
import ifpb.ads.pdm.atividadecolaborativa.component.NewsUniqueComponent;
import ifpb.ads.pdm.atividadecolaborativa.control.Control;
import ifpb.ads.pdm.atividadecolaborativa.model.FeedMessage;

public class ViewNew extends AppCompatActivity {

    private FeedMessage post;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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



        Intent intent = getIntent();
        post = (FeedMessage) intent.getSerializableExtra("post");
        imageView = new ImageView(this);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(layoutParams);

        NewsUniqueComponent newsDetailsComponent = new NewsUniqueComponent(this,
                post.getTitle(), post.getContentEncoded(), post.getPubDate(), getWindowManager(),imageView);
        scrollView.addView(newsDetailsComponent);
        layoutMain.addView(scrollView);

    }
}
