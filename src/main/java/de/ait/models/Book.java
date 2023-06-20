package de.ait.models;

public class Book extends Product{
    private String author;
    private String releaseYear;
    private GenreForBooks genreForBooks;
    public Book( String title, String author,double price,
                String releaseYear, GenreForBooks genreForBooks) {
        super();

        if(author != null) {
            this.author = author;
        } else {
            System.err.println("Введите автора книги");
        }

        if(releaseYear != null) {
            this.releaseYear = releaseYear;
        } else {
            System.err.println("Введите корректную дату");
        }
        this.genreForBooks = genreForBooks;
    }
    public Book(String title){
        this.title = title;
    }

    public String getAuthor() {

        return author;
    }

    public String getReleaseYear() {
        return releaseYear;
    }
    public GenreForBooks getGenre() {
        return genreForBooks;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", releaseYear=" + releaseYear +
                ", genre=" + genreForBooks +
                '}';
    }
}
