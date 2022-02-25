/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


public class Ticket {
    private int num_ticket;
    private float prix;


    public Ticket( int num_ticket, float prix) {

        this.num_ticket = num_ticket;
        this.prix = prix;
    }

    /**
     * @return the num_ticket
     */
    public int getNum_ticket() {
        return num_ticket;
    }

    /**
     * @param num_ticket the num_ticket to set
     */
    public void setNum_ticket(int num_ticket) {
        this.num_ticket = num_ticket;
    }



    /**
     * @return the prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "num_ticket=" + num_ticket +
                ", prix=" + prix +
                '}';
    }


}
