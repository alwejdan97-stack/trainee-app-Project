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
    public String addBooks(@RequestParam int id, @RequestParam String name, @RequestParam int authorId){
        Book newBook=new Book(id,name,authorId);
        boolean authorExists = false;
        for(Author a:authorList){
            if(a.getId()==authorId){
                authorExists= true;
                bookList.add(newBook);
                return name+ " Book ADDED Successfully";
            }
        }
            return "ERROR: Author with ID " + authorId + " is NOT Exists";
    }

    @GetMapping("allBooks")
    public List<Book> viewBooks(){
        return bookList;
    }

    @GetMapping("authorReport")
    public String userFriendly(@RequestParam String authorName){
        Author authorExists = null;
        for(Author a:authorList){
            if(a.getName().equalsIgnoreCase(authorName)){
                authorExists=a;
                break;
            }
        }
        if(authorExists==null){
            return "ERROR: Author with Name " + authorName + " is NOT Exists";
        }
        String authorBooks= " ";
        for(Book b:bookList){
            if(b.getAuthorId()==authorExists.getId()){
                authorBooks = authorBooks+ b.getName()+" | ";
            }
        }
        if(!authorBooks.isEmpty()){
            authorBooks=authorBooks.substring(0,authorBooks.length()-3);
        }else{
            authorBooks="NONE";
        }
        return "*** Author Report ***"+ " "+
                "ID: "+authorExists.getId()+" "+
                "Name: "+authorExists.getName()+" "+
                "Biography: "+authorExists.getBiography()+" "+
                "Books Written: "+authorBooks;
    }
}
