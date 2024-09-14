/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author jorda
 */
public class Coffe {
    private int id;
    private String name;
    private float price;
    private String image;
    
    public Coffe(int id, String name, float price, String image){
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }
    
    public Coffe(){
        
    }
    
    // getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public String getImage(){
        return image;
    }
    
    //setters
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public void setImage(String image){
        this.image = image;
    }
    
    public void addCoffe(){
        
    }
    public void editCoffe(){
        
    }
}
