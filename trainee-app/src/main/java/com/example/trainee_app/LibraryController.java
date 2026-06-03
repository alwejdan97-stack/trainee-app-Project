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

    @GetMapping("addAuthor")
    public String addAuthors(@RequestParam int id, @RequestParam String name, @RequestParam String biography){
        Author newAuthor= new Author(id,name,biography);
        authorList.add(newAuthor);
        return name + " Author ADDED Successfully";
    }

    @GetMapping("allAuthors")
    public List<Author> viewAuthors(){
        return authorList;
    }

    @GetMapping("addRelationalBook")
    public String addBooks(@RequestParam int ID, @RequestParam String name, @RequestParam int authorId){
        boolean authorExists = false;
        for(Author a:authorList){
            if(a.getId()==authorId){
                authorExists= true;
                break;
            }
        }

        if(!authorExists){
            return "ERROR: Author with ID "+authorId+" is NOT Exists";
        }
        Book newBook=new Book(ID,name,authorId);
        bookList.add(newBook);
        return name+ " Book ADDED Successfully";
    }
}
