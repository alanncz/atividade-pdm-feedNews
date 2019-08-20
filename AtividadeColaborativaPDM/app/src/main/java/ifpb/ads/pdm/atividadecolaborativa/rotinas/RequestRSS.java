package ifpb.ads.pdm.atividadecolaborativa.rotinas;


import java.net.MalformedURLException;

import ifpb.ads.pdm.atividadecolaborativa.database.DB;
import ifpb.ads.pdm.atividadecolaborativa.rss.Feed;
import ifpb.ads.pdm.atividadecolaborativa.rss.RSSFeedParser;
import ifpb.ads.pdm.atividadecolaborativa.servicos.ServiceRequest;

public class RequestRSS implements Runnable {

    private ServiceRequest service;

    public RequestRSS(ServiceRequest service){

        this.service = service;
    }

    @Override
    public void run() {
        try {

            Feed feed0 = getNews("https://www.wscom.com.br/feed/");
            Feed feed1 = getNews("https://portalcorreio.com.br/feed/");
            Feed feed2 =  getNews("http://aquiconectados.com.br/feed/");

            DB db = new DB(service);
            db.inserir(feed0);
            db.inserir(feed1);
            db.inserir(feed2);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        service.agendaAbertura();
        service.stopSelf();
    }

    private Feed getNews(String url) throws MalformedURLException {
        RSSFeedParser parser = new RSSFeedParser(url);
        Feed feed = parser.readFeed();
        return feed;
    }
}
