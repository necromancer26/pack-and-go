/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;
import tn.edu.esprit.models.Commentaire;
import tn.edu.esprit.models.Resteau;

/**
 *
 * @author hp
 */
public interface ICom<T> {
public void AjouterCommentaire(T t);  
public boolean modifierCommentaireR(T t);
        public boolean supprimerCommentaireR(T t);
       public List<Commentaire> getAll();
       public List<Commentaire>  getCommentaireById(int idR);

}
