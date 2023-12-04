/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriatornillo.Logic;

/**
 *
 * @author migue
 */
public class Product {
    private String id;
    private String title;
    private String description;
    private int stock;
    private double price;
    private String imgName;

    public Product() {
    }
    
    public Product(String id, String title, String description, int stock, double price, String imgName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.imgName = imgName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
        
    
}
