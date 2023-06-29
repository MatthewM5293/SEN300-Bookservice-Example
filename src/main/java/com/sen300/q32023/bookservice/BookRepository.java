package com.sen300.q32023.bookservice;

import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;
//allows rest controller to talk to MongoDB (JSON)
public interface BookRepository extends MongoRepository<Book, UUID> {
    public List<Book> findByTitleContainingOrDescriptionContaining(String txt, String txt2);

}