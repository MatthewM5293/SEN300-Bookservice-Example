package com.sen300.q32023.bookservice;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

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
