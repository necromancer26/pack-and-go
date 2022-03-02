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
public class reservationR {
    private int nbrPersonneR;
    private String timeR;
    private  String dateR;    
    private int id_user;
    private int idR;
    private int idreservationR;
   
    // private utilisateur utilisateur;
    private Resteau Resteau;
     private static int idres;

    public static int getIdres() {
        return idres;
    }

    public static void setIdres(int idres) {
        reservationR.idres = idres;
    }
    public reservationR() {
    //    utilisateur = new utilisateur(id_user);
        Resteau = new Resteau(idR);
    }
    
    public reservationR(int idreservationR, int idR, int id_user, int nbrPersonneR,String timeR ,String dateR) { 
//        utilisateur = new utilisateur(id_user);
        Resteau = new Resteau(idR);
        
        this.idreservationR = idreservationR;
        this.idR = idR;
        this.id_user = id_user;
        this.nbrPersonneR = nbrPersonneR;
          this.timeR = timeR;
        this.dateR = dateR;
    }
        public reservationR( int idR, int id_user, int nbrPersonneR,String timeR ,String dateR) { 
    //    utilisateur = new utilisateur(id_user);
        Resteau = new Resteau(idR);
        
        this.idR = idR;
        this.id_user = id_user;
        this.nbrPersonneR = nbrPersonneR;
          this.timeR = timeR;
        this.dateR = dateR;
    }
         public reservationR(int idreservationR) { 
            this.idreservationR = idreservationR;
      
    }

  

    public void setNbrPersonneR(int nbrPersonneR) {
        this.nbrPersonneR = nbrPersonneR;
    }

    public void setTimeR(String timeR) {
        this.timeR = timeR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setIdR(int idR) {
        this.idR = idR;
        System.out.println(idR);
    }

    public void setIdreservationR(int idreservationR) {
        this.idreservationR = idreservationR;
    }

  /*  public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }*/

    public void setResteau(Resteau Resteau) {
        this.Resteau = Resteau;
    }

    public int getNbrPersonneR() {
        return nbrPersonneR;
    }

    public String getTimeR() {
        return timeR;
    }

    public String getDateR() {
        return dateR;
    }

    public int getId_user() {
        return id_user;
    }

    public int getIdR() {
        return idR;
    }

    public int getIdreservationR() {
        return idreservationR;
    }

  /*  public utilisateur getUtilisateur() {
        return utilisateur;
    }
*/
    public Resteau getResteau() {
        return Resteau;
    }

    @Override
    public String toString() {
        return "reservationR{" + "nbrPersonneR=" + nbrPersonneR + ", timeR=" + timeR + ", dateR=" + dateR + ", id_user=" + id_user + ", idR=" + idR + ", idreservationR=" + idreservationR +  '}';
    }
         
   
}
