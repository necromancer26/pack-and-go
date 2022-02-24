/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.models;

/**
 *
 * @author hp
 */
public class Commentaire {
    			
    private int idCommentaireR;
    private int idR;
    private int id_user;
    private String contenuCommentaireR;
    private String  dateCR;

    //private utilisateur utilisateur;
    private Resteau Resteau;
    
    public Commentaire() {
    //    utilisateur = new utilisateur(id_user);
        Resteau = new Resteau(idR);
    }

    public Commentaire(int idCommentaireR, int idR, int id_user, String contenuCommentaireR,String dateCR) { 
    //    utilisateur = new utilisateur(id_user);
        Resteau = new Resteau(idR);
        
        this.idCommentaireR = idCommentaireR;
        this.idR = idR;
        this.id_user = id_user;
        this.contenuCommentaireR = contenuCommentaireR;
        this.dateCR=dateCR;
    }

    public Commentaire( int idR,int id_user, String contenuCommentaireR,String dateCR) { 

        //utilisateur = new utilisateur(id_user);
        Resteau = new Resteau(idR);
                this.idR = idR;
                this.id_user = id_user;
        this.dateCR=dateCR;

        this.contenuCommentaireR = contenuCommentaireR;
    }

    public Commentaire(int idCommentaireR) {
        this.idCommentaireR = idCommentaireR;
    }
   /* public Commentaire( String contenuCommentaireR) { 

        this.contenuCommentaireR = contenuCommentaireR;
    }*/
    public int getIdCommentaireR() {
        return idCommentaireR;
    }

    public void setIdcommentaireR(int idCommentaireR) {
        this.idCommentaireR = idCommentaireR;
    }

    public int getid_user() {
        return id_user;
    }

    public String getDateCR() {
        return dateCR;
    }

    public void setDateCR(String dateCR) {
        this.dateCR = dateCR;
    }
    

    public void setid_user(int id_user) {
        this.id_user = id_user;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR= idR;
    }

    public String getContenuCommentaireR() {
        return contenuCommentaireR;
    }

    public void setContenuCommentaireR(String contenuCommentaireR) {
        this.contenuCommentaireR = contenuCommentaireR;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "idCommentaireR=" + idCommentaireR + ", idR=" + idR + ", id_user=" + id_user + ", contenuCommentaireR=" + contenuCommentaireR + ", dateCR=" + dateCR + '}';
    }



  
    
    
}
