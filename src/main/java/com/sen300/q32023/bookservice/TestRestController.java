package com.sen300.q32023.bookservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {
    // http://localhost:8080/test
    @GetMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    public String getTest() {
        return "hello there from TestRestController GET";
    }
}
