package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {
    public static List<InventoryBook> inventoryBookList=new ArrayList<>();

    @GetMapping("newInventoryBook")
    public String addInventoryBook(@RequestParam int id, @RequestParam String name, @RequestParam double price, @RequestParam int stockCount){}
}
