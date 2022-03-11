/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Commentaire;

/**
 *
 * @author hp
 */
public interface Ireserv<T> {
    
    
    public void AjouterReservationR(T t);  
public boolean modifierReservationR(T t);
        public boolean supprimerReservationR(T t);
       public List<T> getAll();

}
