package services;

import models.Ticket;




import models.Activite;
import models.User;
import utils.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class ServiceTicket implements IService<Ticket> {

    public void ajouter2(Ticket ticket, Activite activite, User user) {
        Connection cnx = DataSource.getInstance().getCnx();
        try {

            String req = "INSERT INTO `Ticket`(`num_ticket`, `id_activité`, `prix`,`id_user` ) VALUES ('"+ ticket.getNum_ticket()+"','"+ ticket.getPrix()+"','"+ activite.getId_activite()+"','"+ user.getId_User()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }


    @Override
    public void ajouter(Ticket ticket) {

    }

  

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public void modifier(Ticket ticket) {

    }

    @Override
    public void supprimer(Ticket ticket) {

    }
}
