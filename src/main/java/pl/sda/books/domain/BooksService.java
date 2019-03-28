package pl.sda.books.domain;

import pl.sda.books.domain.model.Book;
import pl.sda.books.domain.port.BooksRepository;

import java.util.List;
import java.util.Optional;

public class BooksService {

    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public List<Book> findByAuthor(String author){
        return booksRepository.findByAuthor(author);
    }

    public Optional<Book> findById(int id){
        return booksRepository.findById(id);
    }
}
