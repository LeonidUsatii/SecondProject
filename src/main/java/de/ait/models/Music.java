package de.ait.models;

public class Music extends Product{
    private String performer;
    private String albumTitle;

    public Music(String id, String title, double price, String performer, String albumTitle) {
        super(id, title, price);
        this.performer = performer;
        this.albumTitle = albumTitle;
    }

    public Music(String performer, String albumTitle) {
        this.performer = performer;
        this.albumTitle = albumTitle;
    }

    public String getPerformer() {
        return performer;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    @Override
    public String toString() {
        return "Music{" +
                "performer='" + performer + '\'' +
                ", albumTitle='" + albumTitle + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
