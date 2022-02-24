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

public class Resteau {
    private String adressR;
    private String typeR;
    private String nomR; 
    private int idR;
    public Resteau( String typeR,String nomR, String adressR,  int idR) {
        this.idR = idR;
        this.adressR = adressR;
        this.typeR = typeR;
        this.nomR = nomR;
    }
  public Resteau( String typeR,String nomR, String adressR) {
        this.adressR = adressR;
        this.typeR = typeR;
        this.nomR = nomR;
       
    }
  
    public Resteau(int idR){
       this.idR=idR;
       
    }
 
    public String getAdressR() {
        return adressR;
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

    @Override
    public String toString() {
        return " Nom Resteau=" + nomR  + " Adress Resteau=" + adressR + ", Type Resteau=" + typeR + '}';
    }
    
    
}
