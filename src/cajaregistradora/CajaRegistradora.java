/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajaregistradora;

import caja.registradora.controllers.Register;
import caja.registradora.objects.Potato;
import caja.registradora.objects.Product;
import caja.registradora.storage.Database;
import caja.registradora.view.View;

/**
 *
 * @author mendoza
 */
public class CajaRegistradora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Register register = new Register();
        register.register();

//        Product x = new Potato();
//        Database d = new Database();
//        
//        for (Product v : d.getAll()) {
//            System.out.println("\t"+v);
//        }
//        
//        x = d.getByIndex(0);
//        x.setAmount(10);
//        x.setPrice(20);
//        
//        for (Product v : d.getAll()) {
//            System.out.println("\t"+v);
//        }
        
    }
    
    
    
}
