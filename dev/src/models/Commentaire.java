/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hp
 */
public class Commentaire {

    			
    private int idCommentaireR;
    private int idR;
    private int id_user;
    private String contenuCommentaireR;
  static int idr;
  //  private User User;
   // private Resteau Resteau;
      static int idres;
        static int idusr;
      static int idCOMMENT;

    public static int getIdCOMMENT() {
        return idCOMMENT;
    }

    public static void setIdCOMMENT(int idCOMMENT) {
        Commentaire.idCOMMENT = idCOMMENT;
    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public static int getIdusr() {
        return idusr;
    }

    public static void setIdusr(int idusr) {
        Commentaire.idusr = idusr;
    }

    public static int getIdres() {
        return idres;
    }
         public static int getIdr() {
        return idr;
    }
       public static void setIdr(int idr) {
        Commentaire.idr = idr;
    }

    public static void setIdres(int idres) {
        Commentaire.idres = idres;
    }
    public Commentaire() {
        
      // User = new User(id_user);
      //  Resteau = new Resteau(idR);
    }

    public Commentaire(int idCommentaireR, int idR, int id_user, String contenuCommentaireR) { 
   //User = new User(id_user);
        //Resteau = new Resteau(idR);
        
        this.idCommentaireR = idCommentaireR;
        this.idR = idR;
        this.id_user = id_user;
        this.contenuCommentaireR = contenuCommentaireR;
    }

    public Commentaire( int idR,int id_user, String contenuCommentaireR) { 

        //utilisateur = new utilisateur(id_user);
       // Resteau = new Resteau(idR);
                this.idR = idR;
                this.id_user = id_user;

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
        return "Commentaire{" + "idCommentaireR=" + idCommentaireR + ", idR=" + idR + ", id_user=" + id_user + ", contenuCommentaireR=" + contenuCommentaireR + '}';
    }



  
    
    
}
