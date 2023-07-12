package com.sen300.q32023.bookservice;

import java.time.*;
import java.util.*;
import org.springframework.data.annotation.*;
//POJO (PLAIN OLD JAVA OBJECT)
public class Book {
    @Id
    private UUID bookGuid;
    private String title;
    private String description;
    private LocalDate PublishedDate;
    private LocalDate CreatedDate;

    //alt + shift + f to format code in VS Code
    public UUID getBookGuid() {
        return bookGuid;
    }

    public void setBookGuid(UUID bookGuid) {
        this.bookGuid = bookGuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        title = _title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String _description) {
        description = _description;
    }

    public LocalDate getPublishedDate() {
        return PublishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        PublishedDate = publishedDate;
    }

    public LocalDate getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        CreatedDate = createdDate;
    }

}
