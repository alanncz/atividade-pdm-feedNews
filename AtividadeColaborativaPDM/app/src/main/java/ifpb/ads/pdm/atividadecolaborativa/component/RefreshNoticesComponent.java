package ifpb.ads.pdm.atividadecolaborativa.component;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ifpb.ads.pdm.atividadecolaborativa.database.DB;
import ifpb.ads.pdm.atividadecolaborativa.model.FeedMessage;
import ifpb.ads.pdm.atividadecolaborativa.telas.ViewNew;
import ifpb.ads.pdm.atividadecolaborativa.until.AdapterNotice;

public class RefreshNoticesComponent extends SwipeRefreshLayout {

    private List<FeedMessage> posts;
    private AdapterNotice adapterNotice;
    private ListView listView;
    private SwipeRefreshLayout.LayoutParams layoutParams;
    private Activity activity;

    public RefreshNoticesComponent(Activity activity){
        super(activity);
        this.activity = activity;
        this.layoutParams = new SwipeRefreshLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT
        );
        super.setLayoutParams(layoutParams);

        DB db = new DB(getContext());
        posts = db.listar();

        adapterNotice = new AdapterNotice(activity,posts);
        listView = new ListView(getContext());
        listView.setAdapter(adapterNotice);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FeedMessage post = posts.get(position);
                Intent intent = new Intent(getContext(), ViewNew.class);
                intent.putExtra("post",post);
                getContext().startActivity(intent);
            }
        });
        addView(listView);
    }

}
