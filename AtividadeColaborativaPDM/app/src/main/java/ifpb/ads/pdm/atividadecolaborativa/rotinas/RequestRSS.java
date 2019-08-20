package ifpb.ads.pdm.atividadecolaborativa.rotinas;

import android.app.Service;

import java.net.MalformedURLException;

import ifpb.ads.pdm.atividadecolaborativa.rss.Feed;
import ifpb.ads.pdm.atividadecolaborativa.rss.FeedMessage;
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

            Feed feed0 = getNews("https://www.wscom.com.br/feed/"); //funcionando
            //Feed feed1 = getNews("https://portalcorreio.com.br/feed/"); //funcionando
            //Feed feed2 =  getNews("http://aquiconectados.com.br/feed/"); //funcionando
            //Feed feed3 = getNews("http://www.jornaldaparaiba.com.br/feed");

            for(int k = 0; k < 10; k++){
                System.out.println("imprimindo - " + k);
            }
            

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
