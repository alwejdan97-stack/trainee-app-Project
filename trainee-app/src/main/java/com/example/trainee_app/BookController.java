package com.example.trainee_app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private static List<Book> books=new ArrayList<>();

    @GetMapping("add-book")
    public String addBook(@RequestParam int ID, @RequestParam String name){
        Book book=new Book(ID,name);
        books.add(book);
        return name+ " Book ADDED Successfully";
    }

    @GetMapping("all-books")
    public List<Book> viewBooks(){
        return books;
    }

    @GetMapping("find-by-id")
    public Book searchById(@RequestParam int ID){
        for(Book b:books){
            if(b.getID()==ID){
                return b;
            }
        }
        return null;
    }

    @GetMapping("find-by-name")
    public Book searchByName(@RequestParam String name){
        for(Book b:books){
            if(b.getName().equalsIgnoreCase(name)){
                return b;
            }
        }
        return null;
    }

    @GetMapping("search-msg")
    public String searchBook(@RequestParam int ID){
        for(Book b:books){
            if(b.getID()==ID){
                return "Found: " + b.getName();
            }
        }
        return "Sorry, that book ID is not available.";
    }
}
