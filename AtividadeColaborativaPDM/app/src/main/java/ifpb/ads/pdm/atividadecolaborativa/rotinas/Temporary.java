package ifpb.ads.pdm.atividadecolaborativa.rotinas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import ifpb.ads.pdm.atividadecolaborativa.model.FeedMessage;
import ifpb.ads.pdm.atividadecolaborativa.until.CreatorDrawable;

public class Temporary implements Runnable {

    private static LinkedBlockingQueue<FeedMessage> list = new LinkedBlockingQueue();
    public List<FeedMessage> listFeedMessage;

    public Temporary(List<FeedMessage> listFeedMessage){
        this.listFeedMessage = listFeedMessage;
    }

    @Override
    public void run() {
        try {
            for(int k = 0; k < listFeedMessage.size(); k++) {
                FeedMessage fm = listFeedMessage.get(k);
                if(fm.getImg()!= null){
                    URL url = new URL(fm.getImg());
                    fm.setImgDrawable(CreatorDrawable.getImg(url));
                }
                else fm.setImgDrawable(null);
                list.put(fm);
            }
        } catch (InterruptedException | MalformedURLException ex) {
            Logger.getLogger(Temporary.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public static FeedMessage get(){
        FeedMessage data = null;
        try {
            data = list.take();
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
