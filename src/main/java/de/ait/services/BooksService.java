package de.ait.services;

import de.ait.models.GenreForBooks;

import java.util.List;

public interface BooksService {
    void addBook(String title, String author, double price,
                 String releaseYear, GenreForBooks genreForBooks);
    List<String> getNames();

}
