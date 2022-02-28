package services;

import models.Ticket;




import models.Activite;
import models.User;
import utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceTicket implements IService<Ticket> {
    Connection cnx = DataSource.getInstance().getCnx();
    public void ajouterTicket(Ticket ticket, Activite activite, User user) {

        try {

            String req = "INSERT INTO `ticket`(`num_ticket`, `id_activite`, `prix`,`id_user` ) VALUES ('"+ ticket.getNum_ticket()+"','3','"+ticket.getPrix()+"','"+ user.getId_user()+"')  ";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }


    @Override
    public void ajouterActivité(Ticket ticket) {

    }



    @Override
    public List<Ticket> getAll() {
        List<Ticket> list = new ArrayList<>();
        try {
            String req = "Select * from ticket";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Ticket ticket = new Ticket(rs.getInt(1),rs.getFloat(3));
                list.add(ticket);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void modifier(Ticket ticket) {

    }

    @Override
    public void modifier(Activite a, Ticket t, User u) {
        try {


            String req= "update `ticket` set `id_activite`=?, `prix`=?, `id_user`=? where `num_ticket`=?";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setInt(4, t.getNum_ticket());
            ps.setLong(3, u.getId_user());
            ps.setFloat(2, t.getPrix());
            ps.setInt(1, a.getId_activite());



            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Ticket ticket) {
        try {

            String req = "DELETE FROM `ticket` where `id_activite` ='" + ticket.getNum_ticket()  + "' ";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }


    }


}
