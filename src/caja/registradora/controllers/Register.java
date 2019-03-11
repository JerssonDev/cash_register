/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.registradora.controllers;

import caja.registradora.objects.Meat;
import caja.registradora.objects.Potato;
import caja.registradora.objects.Product;
import caja.registradora.objects.Rice;
import caja.registradora.storage.Database;
import caja.registradora.view.View;

/**
 *
 * @author mendoza
 */
public class Register {
    
    private Database database;
    
    public Register () {
        this.database = new Database();
    }
    
    // inicia el proceso
    public void register (){
        
        int opt;
        
        View.showHeaderPricipal();
        View.showMenuPrincipal();
        
        do {
            
            View.showGetOption();
            opt = View.getOption();
            showMenu(opt);
            
            
        } while (opt < 1 || opt > 6);
        
    }
    
    public void showMenu(int i){
        
        switch (i){
            case 1:
                buy();
                break;
            case 2:
                sale();
                break;
            case 3:
                showStock();
                break;
            case 4:
                showPurchases();
                break;
            case 5:
                showSales();
                break;
            case 6:
                View.showThanks();
                System.exit(0);
                break;
                
            default:
                View.showInvalidOption();
                break;              
        }  
    }
    
    private void buy () {
        
        int opt;
        
        View.showBuyHeader();
        
        do {
            
            View.showGetOption();
            opt = View.getOption();

            if (opt >=1 && opt <=3){
                
                buyProduct(opt);
                
            } else if (opt == 4){
                
                View.showGetBack("Compras");
                register();
                
            } else {
                View.showInvalidOption();
            }
            
        } while (opt < 1 || opt > 4);
    }
    
    // registra en la base de datos el producto comprado
    private void buyProduct (int code) {
        Product product = null;
        
        switch(code){        
            case 1:
                product = new Potato();
                break;
            case 2:
                product = new Rice();
                break;
            case 3:
                product = new Meat();
                break;
            default:
                View.showInvalidOption();
                return;
                
        }
        
        View.showGetAmount();
        int amount = View.getAmount();
        
        View.showGetPrice();
        double price = View.getPrice();
        
        product.setAmount(amount);
        product.setPrice(price);
        
        database.buy(product);
        
        register();
        
    }
    
    private void showStock () {
    
        View.showStockHeader();
        View.showItemsStock(database.getAll());
        View.showAnyKey();
        int opt = View.getOption();
        register();
        
    }
    
    private void sale () {
        
        int opt;
        
        View.showSaleHeader();
        
        do {
            
            View.showGetOption();
            opt = View.getOption();

            if (opt >=1 && opt <=3){
                
                saleProduct(opt);
                
            } else if (opt == 4){
                
                View.showGetBack("Ventas");
                register();
                
            } else {
                View.showInvalidOption();
            }
            
        } while (opt < 1 || opt > 4);
    }
    
    // registra en la base de datos el producto vendido
    private void saleProduct (int code) {
        
        Product product = null;
        
        product = database.getByIndex(code-1);
        View.showGetAmount();
        int amount = View.getAmount();
        
        if (product.getAmount() < amount) {
            View.showInvalidAmount();
            return;
        }
        
        product.setAmount(amount);      
        database.sale(product);
        register();
        
    }
    
    private void showPurchases(){
        View.showBuyListHeader();
        View.showPurchases(database.getPurchases());
        View.showAnyKey();
        int opt = View.getOption();
        register();
    }
    
    private void showSales(){
        View.showSaleListHeader();
        View.showSales(database.getSales());
        View.showAnyKey();
        int opt = View.getOption();
        register();
    }
}
