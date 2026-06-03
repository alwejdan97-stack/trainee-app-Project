package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {
    private static List<Author> authorList=new ArrayList<>();
    private static List<Book> bookList=new ArrayList<>();

    @GetMapping("add-author")
    public String addAuthors(@RequestParam int id, @RequestParam String name, @RequestParam String biography){
        Author newAuthor= new Author(id,name,biography);
        authorList.add(newAuthor);
        return name + " Author ADDED Successfully";
    }

    @GetMapping("all-authors")
    public List<Author> viewAuthors(){
        return authorList;
    }
}
