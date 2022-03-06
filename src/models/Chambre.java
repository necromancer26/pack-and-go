/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author dorsaf
 */
public class Chambre {
    public static String pathfileCh; 
    public static String filenameCh="";
    
    private int id_chambre;
    private int num_chambre;
    private String type_chambre;
    private int etage;
    private int prix;
    private int id_hotel;
    private String image;
    
    public Chambre(int id_chambre, int num_chambre, String type_chambre, int etage, int prix, String image, int id_hotel) {
        this.id_chambre = id_chambre;
        this.num_chambre = num_chambre;
        this.type_chambre = type_chambre;
        this.etage = etage;
        this.prix = prix;
        this.image = image;
        this.id_hotel = id_hotel;
        
    }
    public Chambre(int id_chambre, int num_chambre, String type_chambre, int etage, int prix, int id_hotel) {
        this.id_chambre = id_chambre;
        this.num_chambre = num_chambre;
        this.type_chambre = type_chambre;
        this.etage = etage;
        this.prix = prix;
        this.id_hotel = id_hotel;
        
    }

    public Chambre(int num_chambre, String type_chambre, int etage, int prix, String image, int id_hotel) {
        this.num_chambre = num_chambre;
        this.type_chambre = type_chambre;
        this.etage = etage;
        this.prix = prix;
        this.image = image;
        this.id_hotel = id_hotel;
        
    }

    public Chambre( int num_chambre, String type_chambre, int etage, int prix, String image) {
        this.num_chambre = num_chambre;
        this.type_chambre = type_chambre;
        this.etage = etage;
        this.prix = prix;
        this.image = image;
    }

    public Chambre() {
    }

    public Chambre(int index_ch) {
    }


    @Override
    public String toString() {
        return "Chambre{" + "id_chambre=" + id_chambre + ", num_chambre=" + num_chambre + ", type_chambre=" + type_chambre + ", etage=" + etage + ", prix=" + prix + ", image=" + image+ ", id_hotel=" + id_hotel + '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ImageView getImg() {
        ImageView img = null;
        try{
            Image new_image = new Image("file:" +image);      
            img = new ImageView();
            img.setImage(new_image); 
            img.setFitWidth(270);
            img.setFitHeight(150);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return img;
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

    public void setId_chambre(int aInt) {
    }
   
    
}
