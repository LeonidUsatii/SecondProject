package de.ait.services;

import de.ait.models.Book;
import de.ait.models.GenreForBooks;
import de.ait.repositories.BooksRepository;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BooksService{

    private final BooksRepository booksRepository;

    public BookServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void addBook(String title, String author, double price,
                        String releaseYear, GenreForBooks genreForBooks) {

        booksRepository.writeBookToFile(new Book(title, author, price, releaseYear, genreForBooks));
    }

    @Override
    public List<String> getNames() {
            List<Book> books = booksRepository.findAll();
            List<String> names = new ArrayList<>();

            for (Book book : books) {
                names.add(book.getTitle());
            }
            return names;

    }
}
