/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.registradora.objects;

/**
 *
 * @author mendoza
 */
public abstract class Product implements Cloneable{
    
    private String name;
    private int amount;
    private double price;
    
    public Product () {
    }
    
    public Product (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        
        if (amount < 0) {
            
            System.out.println("No se puede asignar una cantidad negtiva");
            return;
        
        }
        
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        
        if (price < 0 ){
            System.out.println("No se puede asignar un precio negativo");
            return;
        }
        
        
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", amount=" + amount + ", price=" + price + '}';
    }
    
    // se clona el objeto para dar un paso por valor y no por referencia
    @Override
    public Product clone () throws CloneNotSupportedException {
        return (Product) super.clone();
    }
    
    
}
