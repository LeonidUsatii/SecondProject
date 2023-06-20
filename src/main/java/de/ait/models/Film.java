package de.ait.models;

public class Film extends Product {
    private String releaseYear;
    private GenreForFilms genreForFilms;

    public Film(String id, String title, double price, String releaseYear, GenreForFilms genreForFilms) {
        super(id, title, price);
        this.releaseYear = releaseYear;
        this.genreForFilms = genreForFilms;
    }

    public Film(String releaseYear, GenreForFilms genreForFilms) {
        this.releaseYear = releaseYear;
        this.genreForFilms = genreForFilms;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public GenreForFilms getGenreForFilms() {
        return genreForFilms;
    }

    @Override
    public String toString() {
        return "Film{" +
                "releaseYear='" + releaseYear + '\'' +
                ", genreForFilms=" + genreForFilms +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
