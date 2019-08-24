package ifpb.ads.pdm.atividadecolaborativa.until;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

import ifpb.ads.pdm.atividadecolaborativa.component.PostComponent;
import ifpb.ads.pdm.atividadecolaborativa.model.FeedMessage;

public class AdapterNotice extends BaseAdapter {

    private final List<FeedMessage> posts;
    private final Activity activity;

    public AdapterNotice(Activity activity, List<FeedMessage> posts) {
        this.posts = posts;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int i) {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FeedMessage post = posts.get(i);
        return new PostComponent(activity,post);
    }




}
