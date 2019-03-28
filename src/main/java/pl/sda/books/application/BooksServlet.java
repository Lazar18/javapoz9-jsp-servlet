package pl.sda.books.application;

import org.apache.commons.lang3.StringUtils;
import pl.sda.books.domain.BooksService;
import pl.sda.books.domain.model.Book;
import pl.sda.books.infrastructure.memory.InMemoryBooksRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BooksServlet extends HttpServlet {

    private BooksService booksService;
    private BooksViews booksViews;

    @Override
    public void init() throws ServletException {
        List<Book> books = Arrays.asList(new Book(1, "12345", "Quo Vadis", "rrrrrrr", "Henryk Sienkiewicz", LocalDate.of(1895, 5, 25)),
                new Book(2, "67890", "W Pustyni i w puszy", "aaaaaa", "Henryk Sienkiewicz", LocalDate.of(1911, 5, 25)),
                new Book(3, "15465", "Dziady", "wwwwwww", "Adam Mickiewicz", LocalDate.of(1822, 5, 25)));
        InMemoryBooksRepository booksRepository = new InMemoryBooksRepository(books);
        booksService = new BooksService(booksRepository);
        booksViews = new BooksViews();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (StringUtils.isNotEmpty(id)) {
            showBook(req, resp);
        } else {
            showListView(req, resp);
        }
    }

    private void showBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Book> book = booksService.findById(Integer.parseInt(req.getParameter("id")));
        if (book.isPresent()){
            req.setAttribute("book", book.get());
        }
        req.getRequestDispatcher("WEB-INF/jsp/book.jsp").forward(req, resp);
    }

    private void showListView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author");
        List<Book> books = StringUtils.isEmpty(author) ?
                booksService.findAll() :
                booksService.findByAuthor(author);
//        booksViews.printBooks(resp.getWriter(), books);
//        resp.setContentType("text/html");

        req.setAttribute("authorFilter", StringUtils.isNotEmpty(author));
        req.setAttribute("books", books);
        req.getRequestDispatcher("WEB-INF/jsp/bookList.jsp").forward(req, resp);
    }

//    private void showListViewById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Optional<Book> books = null;
//        String id = req.getParameter("id");
//        if (StringUtils.isEmpty(id)) {
//            booksService.findAll();
//        } else {
//            books = booksService.findById(Integer.parseInt(id));
//        }
//
//        req.setAttribute("idFilter", StringUtils.isNotEmpty(id));
//        req.setAttribute("books", books);
//        req.getRequestDispatcher("WEB-INF/jsp/bookList.jsp").forward(req, resp);
//    }
}
