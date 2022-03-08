/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author hp
 */

public class Resteau {
    private String adressR;
    private String typeR;
    private String nomR; 
    private String paysR; 
    private String telR; 
    private String imgR;
    private int idR;
    static int idd;
     public static String pathfile; 
    public static String filename="";
    public static final String REGEX = "[a-zA-Z]";
public static final String REGEXnumber = "[1-9]";
 
public ImageView getImg() {
        ImageView img = null;
        try{
            Image new_image = new Image("file:" +imgR);      
            img = new ImageView();
            img.setImage(new_image); 
            img.setFitWidth(150);
            img.setFitHeight(150);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return img;
    }   
    public String getImgR() {
        return imgR;
    }

    public void setImgR(String imgR) {
        this.imgR = imgR;
    }

     public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Resteau.idd = idd;
    }
    private List<Commentaire> Commentaire;

     public Resteau() {
         
    }
     
    public Resteau( String typeR,String nomR, String adressR,String paysR,String telR,String imgR,  int idR) {
        this.idR = idR;
        this.adressR = adressR;
        this.paysR = paysR;
        this.telR = telR;
        this.typeR = typeR;
        this.nomR = nomR;
        this.imgR=imgR;

                Commentaire = new ArrayList<>();

    }
  public Resteau( String typeR,String nomR, String adressR,String paysR,String telR,String imgR) {
        this.adressR = adressR;
        this.typeR = typeR;
        this.nomR = nomR;
        this.paysR = paysR;
        this.telR = telR;
        this.imgR=imgR;
    }
  
    public Resteau(int idR){
       this.idR=idR;
       
    }

   
 
    public String getAdressR() {
        return adressR;
    }

    public void setPaysR(String paysR) {
        this.paysR = paysR;
    }

    public void setTelR(String telR) {
        this.telR = telR;
    }

    public String getPaysR() {
        return paysR;
    }

    public String getTelR() {
        return telR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getNomR() {
        return nomR;
    }

    public int getIdR() {
        return idR;
    }

    public void setAdressR(String adressR) {
        this.adressR = adressR;
    }
       public String getnomR() {
        return nomR;
    }

    public void setnomR(String nomR) {
        this.nomR = nomR;
    }

    public String getTypeR() {
        return typeR;
    }

    public void setTypeR(String typeR) {
        this.typeR = typeR;
    }
      public List<Commentaire> getCommentaire() {
        return Commentaire;
    }
    public void setCommentaire(List<Commentaire> Commentaire) {
        this.Commentaire = Commentaire;
    }

    @Override
    public String toString() {
        return "Resteau{" + "adressR=" + adressR + ", typeR=" + typeR + ", nomR=" + nomR + ", paysR=" + paysR + ", telR=" + telR + ", imgR=" + imgR + ", idR=" + idR + ", Commentaire=" + Commentaire + '}';
    }

  

  
    
    
}
