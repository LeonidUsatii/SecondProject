package de.ait.repositories;

import de.ait.models.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryTextFileImpl implements BooksRepository {

    private String fileName;

    public BooksRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                Book book = parseLine(line); // преобразуем пользователя в строку
                books.add(book); // положили пользователя в список
                line = bufferedReader.readLine(); // считали следующую строку
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return books;
    }

    @Override
    public void writeBookToFile(Book book) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String bookObject = "";

            bookObject = book.getTitle() + "|" + book.getAuthor()
                    + "|" + book.getPrice() + "|" + book.getReleaseYear()
                    + "|" + book.getGenre();

            bufferedWriter.write(bookObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
    }

    private static Book parseLine(String line) {
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String lastName = parsed[1];
        int age = Integer.parseInt(parsed[2]);
        double height = Double.parseDouble(parsed[3]);

        //return new Book();
        return null;

    }
}
