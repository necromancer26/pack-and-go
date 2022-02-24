/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author dorsaf
 */
public class Hotel {
    
    private int id_hotel;
    private String nom_hotel;
    private int nbr_etoiles;
    private int nbr_chambres;
    private String adresse;
    private String pays;
    private int tel;
    private String email;

    
    public int getId_hotel() {
        return id_hotel;
    }
    
    public String getNom_hotel() {
        return nom_hotel;
    }

    public String getPays() {
        return pays;
    }

    public int getNbr_etoiles() {
        return nbr_etoiles;
    }

    public int getNbr_chambres() {
        return nbr_chambres;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public void setNbr_etoiles(int nbr_etoiles) {
        this.nbr_etoiles = nbr_etoiles;
    }

    public void setNbr_chambres(int nbr_chambres) {
        this.nbr_chambres = nbr_chambres;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id_hotel=" + id_hotel + ", nom_hotel=" + nom_hotel+ ", nbr_etoiles=" + nbr_etoiles + ", nbr_chambres=" + nbr_chambres + ", adresse=" + adresse + ", pays=" + pays + ", tel=" + tel + ", email=" + email + '}';
    }

    public Hotel(String nom_hotel, int nbr_etoiles, int nbr_chambres, String adresse, String pays, int tel, String email) {
        this.nom_hotel = nom_hotel;
        this.nbr_etoiles = nbr_etoiles;
        this.nbr_chambres = nbr_chambres;
        this.adresse = adresse;
        this.pays = pays;
        this.tel = tel;
        this.email = email;
    }

    public Hotel(int id_hotel, String nom_hotel, int nbr_etoiles, int nbr_chambres, String adresse, String pays, int tel, String email) {
        this.id_hotel = id_hotel;
        this.nom_hotel = nom_hotel;
        this.nbr_etoiles = nbr_etoiles;
        this.nbr_chambres = nbr_chambres;
        this.adresse = adresse;
        this.pays = pays;
        this.tel = tel;
        this.email = email;
    }

}
