/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;

/**
 *
 * @author hp
 */
public interface Iresteau <T>{
    public void ajouter(T t);
   // public T getById(int adr);
    public List<T> getAll();
public boolean modifier(T t);
        public boolean supprimerR(T t);
        public void TRIRestau();
}
