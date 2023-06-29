package com.sen300.q32023.bookservice;

import java.time.*;
import java.util.*;
import org.springframework.data.annotation.*;
//POJO (PLAIN OLD JAVA OBJECT)
public class Book {
    @Id
    private UUID bookGuid;
    private String Title;
    private String Description;
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
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
