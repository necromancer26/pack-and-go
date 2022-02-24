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
public class Chambre {
    
    private int id_chambre;
    private int num_chambre;
    private String type_chambre;
    private int etage;
    private int prix;
    private int id_hotel;

    public Chambre(int id_chambre, int num_chambre, String type_chambre, int etage, int prix, int id_hotel) {
        this.id_chambre = id_chambre;
        this.num_chambre = num_chambre;
        this.type_chambre = type_chambre;
        this.etage = etage;
        this.prix = prix;
        this.id_hotel = id_hotel;
    }

    public Chambre(int num_chambre, String type_chambre, int etage, int prix, int id_hotel) {
        this.num_chambre = num_chambre;
        this.type_chambre = type_chambre;
        this.etage = etage;
        this.prix = prix;
        this.id_hotel = id_hotel;
    }

    public Chambre( int num_chambre, String type_chambre, int etage, int prix) {
        this.num_chambre = num_chambre;
        this.type_chambre = type_chambre;
        this.etage = etage;
        this.prix = prix;
    }


    @Override
    public String toString() {
        return "Chambre{" + "id_chambre=" + id_chambre + ", num_chambre=" + num_chambre + ", type_chambre=" + type_chambre + ", etage=" + etage + ", prix=" + prix + ", id_hotel=" + id_hotel + '}';
    }

    public int getId_chambre() {
        return id_chambre;
    }

    public int getNum_chambre() {
        return num_chambre;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public String getType_chambre() {
        return type_chambre;
    }

    public int getEtage() {
        return etage;
    }

    public int getPrix() {
        return prix;
    }

    public void setNum_chambre(int num_chambre) {
        this.num_chambre = num_chambre;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
}
