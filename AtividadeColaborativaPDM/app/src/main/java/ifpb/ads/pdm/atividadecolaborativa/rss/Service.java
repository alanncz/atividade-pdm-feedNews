package ifpb.ads.pdm.atividadecolaborativa.rss;

import java.net.MalformedURLException;
import javax.xml.stream.XMLStreamException;

public class Service {

    public static Feed getNews(String url) throws XMLStreamException, MalformedURLException {
        RSSFeedParser parser = new RSSFeedParser(url);
        Feed feed = parser.readFeed();
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message.getPubDate());
            System.out.println(message);
        }

        return feed;
    }

    public static void main(String args[]) throws MalformedURLException, XMLStreamException {
        getNews("https://www.diariodosertao.com.br/feed");
    }

}
