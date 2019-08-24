package ifpb.ads.pdm.atividadecolaborativa.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.Objects;

public class FeedMessage implements Serializable {

    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;
    private String pubDate;
    private String contentEncoded;
    private String img;
    private transient Drawable imgDrawable;

    public FeedMessage() {

    }

    public Drawable getImgDrawable() {
        return imgDrawable;
    }

    public void setImgDrawable(Drawable imgDrawable) {
        this.imgDrawable = imgDrawable;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContentEncoded() {
        return contentEncoded;
    }

    public void setContentEncoded(String contentEncoded) {
        this.contentEncoded = contentEncoded;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedMessage that = (FeedMessage) o;
        return title.equals(that.title) &&
                description.equals(that.description) &&
                link.equals(that.link) &&
                author.equals(that.author) &&
                guid.equals(that.guid) &&
                pubDate.equals(that.pubDate) &&
                contentEncoded.equals(that.contentEncoded) &&
                img.equals(that.img) &&
                imgDrawable.equals(that.imgDrawable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, link, author, guid, pubDate, contentEncoded, img, imgDrawable);
    }

    @Override
    public String toString() {
        return "FeedMessage{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", author='" + author + '\'' +
                ", guid='" + guid + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", contentEncoded='" + contentEncoded + '\'' +
                ", img='" + img + '\'' +
                ", imgDrawable=" + imgDrawable +
                '}';
    }
}
