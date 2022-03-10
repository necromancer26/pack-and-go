/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


public class Ticket {
    private int num_ticket;


    public Ticket( int num_ticket) {

        this.num_ticket = num_ticket;

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






    @Override
    public String toString() {
        return "Ticket{" +
                "num_ticket=" + num_ticket +
                '}';
    }


}
