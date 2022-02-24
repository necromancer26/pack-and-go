package billet.connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author kjpsaycon
 */
public class connection {
    private Connection con;
   
    public connection(){
    }
   
    public Connection connect(){
        if(con == null){
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("packandgo");
            db.setUser("root");
            db.setPassword("");

            try {
                con = db.getConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error","SQL Error: "+e,JOptionPane.ERROR_MESSAGE);
            }
        }
        return con;
    }
   
}
