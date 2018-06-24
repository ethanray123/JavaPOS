/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posinterface;

/**
 *
 * @author user
 */
public class Inventory {
    private String product;
    private double price;
    private int quantity;
    
    public Inventory(String Prodname,double Price,int Quantity){
        this.product = Prodname;
        this.price = Price;
        this.quantity = Quantity;
        
    }
    
    public String getProdname()
    {
        return product;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
}
