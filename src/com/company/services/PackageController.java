package com.company.services;

import com.company.models.Package;
import com.company.models.UserPersonality;
import com.company.util.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PackageController {
    static Connection cnx = DataSource.getInstance().getCnx();

    public static List<Package> getAllPackages() {
        List<Package> packageList = new ArrayList<>();
        try {
            String req = "Select * from packages";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Package aPackage = new Package(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getInt(6),rs.getInt(7));
                packageList.add(aPackage);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return packageList;

    }
}
