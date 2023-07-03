package com.sen300.q32023.bookservice;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/book")
public class BookRestController {
    @Autowired
    private BookRepository bookRepo;

    // show all books
    @GetMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    // search book
    @GetMapping(path = "/search/{searchText}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Book> searchBooks(@PathVariable(required = true) String searchText) {
        return bookRepo.findByTitleContainingOrDescriptionContaining(searchText, searchText);
    }

    // read book
    @GetMapping(path = "/{bookUUID}")
    @ResponseStatus(code = HttpStatus.OK)
    public Book getBook(@PathVariable UUID bookUUID) {
        return bookRepo.findById(bookUUID).orElseThrow(() -> new NoSuchElementException());
    }

    // update book
    @PutMapping(path = "/{bookUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@PathVariable(required = true) UUID bookUUID, @RequestBody Book book) {

        if (!book.getBookGuid().equals(bookUUID)) {
            throw new RuntimeException(
                    String.format("Path itemId %s did not match body itemId %s", bookUUID, book.getBookGuid()));
        }

        bookRepo.save(book);
    }

    // delete book
    @DeleteMapping(path = "/{bookUUID}")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteItem(@PathVariable(required = true) UUID bookUUID) {

        bookRepo.deleteById(bookUUID);
    }

    // Gets Json through MongoDB
    @PostMapping(path = "")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBook(@RequestBody Book book) {
        book.setBookGuid(UUID.randomUUID());
        book.setCreatedDate(LocalDate.now());
        book.setPublishedDate(createRandomDate(1900, 2023));

        bookRepo.save(book);
    }

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

}
