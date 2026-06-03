package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {
    public static List<InventoryBook> inventoryBookList=new ArrayList<>();

    @GetMapping("addInventoryBook")
    public String addInventoryBook(@RequestParam int id, @RequestParam String title, @RequestParam double price, @RequestParam int stockCount){
        InventoryBook newInventoryBook=new InventoryBook(id,title,price,stockCount);
        inventoryBookList.add(newInventoryBook);
        return newInventoryBook+" ADDED SUCCESSFULLY...";
    }

    @GetMapping("allInventoryBooks")
    public List<InventoryBook> viewInventoryBooks(){
        return inventoryBookList;
    }

    @GetMapping("checkStock")
    public String searchBook(@RequestParam int bookId){
            for(InventoryBook ib:inventoryBookList){
                if(ib.getBookID()==bookId && ib.getStockCount()>0){
                    return ib.getTitle()+" book is available | price is: "+ib.getPrice();
                }else if(ib.getBookID()==bookId && ib.getStockCount()<=0){
                    return ib.getTitle()+" book is sold-out...";
                }
            }
        return "NO Book with ID "+bookId;
    }

    @GetMapping("lowStockReport")
    public String lowStockReport(@RequestParam int threshold){
        String bookReport=" ";
        for(InventoryBook ib:inventoryBookList){
            if(ib.getStockCount()<= threshold){
                bookReport= bookReport+" Title: "+ib.getTitle()+" | Stock: "+ib.getStockCount();
            }
        }
        if(bookReport.isEmpty()){
            return "no books currently need reordering,...";
        }
        return bookReport;
    }
}
