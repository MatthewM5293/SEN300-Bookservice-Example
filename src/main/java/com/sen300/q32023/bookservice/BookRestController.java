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

    @GetMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping(path = "/search/{searchText}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Book> searchBooks(@PathVariable(required = true) String searchText) {
        return bookRepo.findByTitleContainingOrDescriptionContaining(searchText, searchText);
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
