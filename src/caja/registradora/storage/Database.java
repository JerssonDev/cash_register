/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.registradora.storage;

import caja.registradora.objects.Meat;
import caja.registradora.objects.Potato;
import caja.registradora.objects.Product;
import caja.registradora.objects.Rice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mendoza
 */
public class Database {
    
    private final Product[] products;
    private final List<Product> purchases;
    private final List<Product> sales;
    
    public Database () {
        
        this.products = new Product[3];
        this.purchases = new ArrayList<>();
        this.sales = new ArrayList<>();
        
        Product potato = new Potato("Amarilla");
        Product rice = new Rice("El molino");
        Product meat = new Meat("Res");
        
        this.products[0] = potato;
        this.products[1] = rice;
        this.products[2] = meat;
        
    }
    
    public Product getByIndex (int i) {
    
        if (i < 0 || i > 2){
            System.out.println("Indice fuera de Limite");
            return null;
        }
        
        Product result = null;
        
        try {
            
            result = this.products[i].clone();
        
        } catch (CloneNotSupportedException cnse) {
        
            System.out.println(cnse);
            
        }
        
        return result;
        
    }
    
    public Product[] getAll () {
        
        Product[] result = new Product[3];
        
        try {
            
            for (int i = 0; i < result.length; i++) {
                result[i]= products[i].clone();
            }
        
        } catch (CloneNotSupportedException cnse) {
            System.out.println(cnse);
        }
        
        return result;

        
    }
    
    public void buy (Product product) {
    
        Product tmp;
        
        switch(product.getClass().getSimpleName()){
        
            case "Potato":
                tmp = this.products[0];
                break;
            case "Rice":
                tmp = this.products[1];
                break;
            case "Meat":
                tmp = this.products[2];
                break;
            default:
                System.out.println("No valido!");
                return;
                
        }
        
        tmp.setAmount(tmp.getAmount() + product.getAmount());
        tmp.setPrice(product.getPrice());
        
        purchases.add(product);
        
    }
    
    public void sale (Product product) {
    
        Product tmp;
        
        switch(product.getClass().getSimpleName()){
        
            case "Potato":
                tmp = this.products[0];
                break;
            case "Rice":
                tmp = this.products[1];
                break;
            case "Meat":
                tmp = this.products[2];
                break;
            default:
                System.out.println("No valido!");
                return;
                
        }
        
        tmp.setAmount(tmp.getAmount() - product.getAmount());
        product.setPrice(tmp.getPrice() * 1.25); 
        sales.add(product);
        
    }
    
    public List<Product> getPurchases () {
        return this.purchases;
    }
    
    public List<Product> getSales () {
        return this.sales;
    }
    
}
