/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author dorsaf
 */
public class ReservationChambre {
    
    private int num_reservation;
    private Date check_in, check_out;
    private int id_user, id_chambre;

    public ReservationChambre(Date check_in, Date check_out, int id_user, int id_chambre) {
        this.check_in = check_in;
        this.check_out = check_out;
        this.id_user = id_user;
        this.id_chambre = id_chambre;
    }

    public ReservationChambre(int num_reservation, Date check_in, Date check_out, int id_user, int id_chambre) {
        this.num_reservation = num_reservation;
        this.check_in = check_in;
        this.check_out = check_out;
        this.id_user = id_user;
        this.id_chambre = id_chambre;
    }

    public ReservationChambre(int num_reservation, Date check_in, Date check_out, int id_chambre) {
        this.num_reservation = num_reservation;
        this.check_in = check_in;
        this.check_out = check_out;
        this.id_chambre = id_chambre;
        
    }

    public int getNum_reservation() {
        return num_reservation;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_chambre() {
        return id_chambre;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    @Override
    public String toString() {
        return "ReservationChambre{" + "num_reservation=" + num_reservation + ", check_in=" + check_in + ", check_out=" + check_out + ", id_user=" + id_user + ", id_chambre=" + id_chambre + '}';
    }

    

  
}
