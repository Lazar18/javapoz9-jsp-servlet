package pl.sda.books.infrastructure.memory;

import org.apache.commons.lang3.StringUtils;
import pl.sda.books.domain.model.Book;
import pl.sda.books.domain.port.BooksRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryBooksRepository implements BooksRepository {
    private List<Book> books;

    public InMemoryBooksRepository(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<Book>(books);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(e -> StringUtils.containsIgnoreCase(e.getAuthor(), author))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(int id) {
        return books.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }
}
