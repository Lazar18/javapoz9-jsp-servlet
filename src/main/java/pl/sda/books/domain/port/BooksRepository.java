package pl.sda.books.domain.port;

import pl.sda.books.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BooksRepository {
    List<Book> findAll();
    List<Book> findByAuthor(String author);
    Optional<Book> findById(int id);
}
