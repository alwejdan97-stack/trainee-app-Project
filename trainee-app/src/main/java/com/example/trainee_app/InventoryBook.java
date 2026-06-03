package com.example.trainee_app;

public class InventoryBook {
    private int bookID;
    private String title;
    private double price;
    private int stockCount;

    public InventoryBook(int bookID, String title, double price, int stockCount) {
        this.bookID = bookID;
        this.title = title;
        this.price = price;
        this.stockCount = stockCount;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
