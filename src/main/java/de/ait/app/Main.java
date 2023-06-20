package de.ait.app;

import de.ait.models.GenreForBooks;
import de.ait.repositories.BooksRepository;
import de.ait.repositories.BooksRepositoryTextFileImpl;
import de.ait.services.BookServiceImpl;
import de.ait.services.BooksService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BooksRepository booksRepository = new BooksRepositoryTextFileImpl("files/books.txt");
        BooksService booksService = new BookServiceImpl(booksRepository);

        while (true) {
            System.out.println("1. Вывести названия книг");
            System.out.println("2. Добавить новую книгу");
            System.out.println("0. Выход");
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    System.out.println("Выводим название книг...");

                    List<String> names = booksService.getNames();

                    for (String name : names) {
                        System.out.println(name);
                    }
                    break;
                case 2:
                   System.out.println("Добавляем новую книгу");

                    System.out.println("Введите название книги: ");
                    String title = scanner.nextLine();

                    System.out.println("Введите автора: ");
                    String author = scanner.nextLine();

                    System.out.println("Введите стоимость книги: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Введите дату издания: ");
                    String releaseYear = scanner.nextLine();

                    System.out.println("Введите жанр книги: ");

                    System.out.println("1. DETECTIVE");
                    System.out.println("2. NOVEL");
                    System.out.println("3. POETRY");
                    System.out.println("4. FANTASY");
                    System.out.println("5. EDUCATION");
                    System.out.println("6. KIDS");

                    command = scanner.nextInt();
                    scanner.nextLine();
                    GenreForBooks genreForBooks = GenreForBooks.DETECTIVE;

                    switch (command) {
                        case 1:
                            genreForBooks = GenreForBooks.DETECTIVE;
                            break;
                        case 2:
                            genreForBooks = GenreForBooks.NOVEL;
                            break;
                        case 3:
                            genreForBooks = GenreForBooks.POETRY;
                            break;
                        case 4:
                            genreForBooks = GenreForBooks.FANTASY;
                            break;
                        case 5:
                            genreForBooks = GenreForBooks.EDUCATION;
                            break;
                        case 6:
                            genreForBooks = GenreForBooks.KIDS;
                            break;
                    }

                    booksService.addBook(title, author, price, releaseYear, genreForBooks);
                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }
        }
    }
}
