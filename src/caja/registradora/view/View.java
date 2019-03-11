/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.registradora.view;

import caja.registradora.objects.Product;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mendoza
 */
public class View {
    
    public static void showHeaderPricipal(){
        System.out.println("\t****>>>>>> ¡BIENVENIDO! CAJA REGISTRADORA <<<<<<****");
    }
    
    public static void showMenuPrincipal(){
        System.out.println("\n\t\t1. Comprar");
        System.out.println("\t\t2. Vender");
        System.out.println("\t\t3. Inventario");
        System.out.println("\t\t4. Compras");
        System.out.println("\t\t5. Ventas");
        System.out.println("\t\t6. Salir");
        
    }
    
    public static void showGetOption (){
        System.out.print("\tDigite la opcion : ");
    }
    
    public static void showGetAmount (){
        System.out.print("\tDigite la cantidad : ");
    }
    
    public static void showGetPrice (){
        System.out.print("\tDigite el precio : ");
    }
    
    public static int getOption () {
        
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
        
    }
    
    public static int getAmount () {
        
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
        
    }
    
    public static double getPrice() {
        
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextDouble();
        
    }
    
    public static void showBuyHeader (){    
        System.out.println("\t****>>>>>> Menu de Compras <<<<<<****");
        showItemsMenu();
    }
    
    public static void showSaleHeader (){    
        System.out.println("\t****>>>>>> Menu de Ventas <<<<<<****");
        showItemsMenu();
    }
    
    public static void showStockHeader (){    
        System.out.println("\t****>>>>>> INVENTARIO <<<<<<****");
        showItemsHeader();
 
    }
    
    public static void showItemsHeader() {
        System.out.println("\tProducto | Cantidad | Vlr Unitario | Vlr Total");

    }
    
    public static void showBuyListHeader() {
        System.out.println("\t****>>>>>> Compras <<<<<<****");
        showItemsHeader();

    }
    
    public static void showSaleListHeader() {
        System.out.println("\t****>>>>>> Ventas <<<<<<****");
        showItemsHeader();

    }
    
    public static void showItemsMenu () {
        System.out.println("\n\t\t1. Papa");
        System.out.println("\t\t2. Arroz");
        System.out.println("\t\t3. Carne");
        System.out.println("\t\t4. Regresar");
    }
    
    public static void showThanks() {
        System.out.println("¡Saliendo del Sistema!");
    }
    
    public static void showInvalidOption () {
        System.out.println("Opcion no valida!");
    } 
    
    public static void showGetBack (String name) {
        System.out.println("Saliendo del Modulo "+name);
    } 
    
    public static void showAnyKey () {
        System.out.print("Digite cualquier numero para continuar : ");
    } 
    
    public static void showInvalidAmount() {
        System.out.println("DLa cantidad no es valida!");
    } 
    
    public static void showItemsStock(Product[] products){
        for (Product v : products) {
            System.out.println("\t"+v);
        }
    }
    
    public static void showPurchases(List<Product> list){
        list.forEach((v) -> {
            System.out.println("\t"+v);
        });
    }
    
    public static void showSales(List<Product> list){
        list.forEach((v) -> {
            System.out.println("\t"+v);
        });
    }

}
