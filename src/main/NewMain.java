/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.Activite;
import services.ServiceActivité;



public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceActivité sp = new ServiceActivité();
        Activite p = new Activite("", "",3,"");
    sp.ajouter(p);
        System.out.println(sp.getAll());
        
    }
    
}
