/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Fayechi
 */
public class Activite {
    private int id_activite;
    private String nom_activite;
    private String adresse;
    private int type_activite;
    private String pays;

    public Activite(int id_activite, String nom_activite, String adresse, int type_activite, String pays) {
        this.id_activite = id_activite;
        this.nom_activite = nom_activite;
        this.adresse = adresse;
        this.type_activite = type_activite;
        this.pays = pays;
    }

    public Activite(String nom_activite, String adresse, int type_activite, String pays) {
        this.nom_activite = nom_activite;
        this.adresse = adresse;
        this.type_activite = type_activite;
        this.pays = pays;
    }

    /**
     * @return the id_activite
     */
    public int getId_activite() {
        return id_activite;
    }

    /**
     * @param id_activite the id_activite to set
     */
    public void setId_activite(int id_activite) {
        this.id_activite = id_activite;
    }

    /**
     * @return the nom_activite
     */
    public String getNom_activite() {
        return nom_activite;
    }

    /**
     * @param nom_activite the nom_activite to set
     */
    public void setNom_activite(String nom_activite) {
        this.nom_activite= nom_activite;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * @param pays the pays to set
     */
    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getType_activite() {
        return type_activite;
    }

    public void setType_activite(int type_activite) {
        this.type_activite = type_activite;
    }

    @Override
    public String toString() {
        return "Activité{" + "id_etablissement=" + id_activite + ", nom_activite=" + nom_activite + ", adresse=" + adresse + " pays = "+pays+ "}'";
    }
    
    
}
