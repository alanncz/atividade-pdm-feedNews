package ifpb.ads.pdm.atividadecolaborativa.telas;

import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import ifpb.ads.pdm.atividadecolaborativa.layout.BoxNoticia;
import ifpb.ads.pdm.atividadecolaborativa.database.DB;
import ifpb.ads.pdm.atividadecolaborativa.rss.FeedMessage;

public class Principal extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String titulo = "caio";
    private String descricao = "ola";
    private String src;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        db = new DB(this);

        //<Relative LAYOUT>
        RelativeLayout root = new RelativeLayout(this);
        root.setLayoutParams(
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT
                )
        );

        root.setBackgroundColor(Color.WHITE);
        setContentView(root);

        RelativeLayout root2 = new RelativeLayout(this);
        root2.setLayoutParams(
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT
                )
        );

        root2.setBackgroundColor(Color.WHITE);
        root2.setGravity(Gravity.CENTER);

        Button sair = new Button(this);
        sair.setWidth(200);
        sair.setText("Sair");
        sair.setOnClickListener(view -> {
            mAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        root.addView(sair);

        List<FeedMessage> list = db.listar();

        String src = "srs";

        ListAdapter listAdapter = new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int i) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                return null;
            }

            @Override
            public int getItemViewType(int i) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };

        ListView listView = new ListView(this);
        listView.setAdapter(listAdapter);

        LinearLayout rootB = new LinearLayout(this);
        rootB.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                )
        );
        rootB.setBackgroundColor(Color.WHITE);
        rootB.setOrientation(LinearLayout.VERTICAL);

        for (FeedMessage feed : list){
        //    root2.addView(new BoxNoticia(this,feed.getTitle(),feed.getDescription(),src));
            //root2.setOnClickListener(new View.OnClickListener() {
            //    @Override
            //    public void onClick(View view) {
            //        Intent intent = new Intent(getApplicationContext(), Noticia.class);
            //        startActivity(intent);
            //    }
            //});

        //    root.addView(root2);

            TextView titulo = new TextView(this);
            titulo.setTextSize(20);
            titulo.setText(feed.getTitle());
            rootB.addView(titulo);

        }

        root.addView(rootB);

    }
}
