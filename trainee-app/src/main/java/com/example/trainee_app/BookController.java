package com.example.trainee_app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    private static List<Book> books=new ArrayList<>();

    @GetMapping("add-book")
    public String addBook(@RequestParam int ID, @RequestParam String name){
        Book book=new Book(ID,name);
        books.add(book);
        return "Book ADD Successfully";
    }
}
