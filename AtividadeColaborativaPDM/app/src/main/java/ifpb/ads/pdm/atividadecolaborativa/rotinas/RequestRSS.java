package ifpb.ads.pdm.atividadecolaborativa.threads;

import android.app.Service;

import java.net.MalformedURLException;

import ifpb.ads.pdm.atividadecolaborativa.rss.Feed;
import ifpb.ads.pdm.atividadecolaborativa.rss.FeedMessage;
import ifpb.ads.pdm.atividadecolaborativa.rss.RSSFeedParser;

public class RequestRSS implements Runnable {

    private Service service;

    public RequestRSS(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        try {
            getNews("https://www.diariodosertao.com.br/feed");
            getNews("http://aquiconectados.com.br/feed/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        service.stopSelf();
    }

    public Feed getNews(String url) throws MalformedURLException {
        RSSFeedParser parser = new RSSFeedParser(url);
        Feed feed = parser.readFeed();
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message.getPubDate());
            System.out.println(message);
        }

        return feed;
    }
}
