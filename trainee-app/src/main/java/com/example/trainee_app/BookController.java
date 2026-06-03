package com.example.trainee_app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    private static ArrayList<Book> books=new ArrayList<>();

    @GetMapping("add-book")
    public String book(){
        return Arrays.asList(
                new Book(1,"Arabic"),
                new Book(2,"Islamic"),
                new Book(4,"Mathematics"),
                new Book(5,"Since"),
                new Book(6,"Information Technology")
        );
    }
}
