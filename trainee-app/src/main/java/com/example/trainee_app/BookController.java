package com.example.trainee_app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private static List<Book> books=new ArrayList<>();

    @GetMapping("addBook")
    public String addBook(@RequestParam int id, @RequestParam String name, @RequestParam int authorId){
        Book book=new Book(id,name,authorId);
        books.add(book);
        return name+ " Book ADDED Successfully";
    }

    @GetMapping("allBooks")
    public List<Book> viewBooks(){
        return books;
    }

    @GetMapping("findById")
    public Book searchById(@RequestParam int id){
        for(Book b:books){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }

    @GetMapping("findByName")
    public Book searchByName(@RequestParam String name){
        for(Book b:books){
            if(b.getName().equalsIgnoreCase(name)){
                return b;
            }
        }
        return null;
    }

    @GetMapping("searchMsg")
    public String searchBook(@RequestParam int id){
        for(Book b:books){
            if(b.getId()==id){
                return "Found: " + b.getName();
            }
        }
        return "Sorry, that book ID is not available.";
    }
}
