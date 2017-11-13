package com.coffecheap.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

    Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
  
    
    public void Conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");            
           //con = DriverManager.getConnection("jdbc:mysql://localhost/coffechip?user=root&password=intecap");                       
            con = DriverManager.getConnection("jdbc:mysql://localhost/coffechip?user=root");
            //con = DriverManager.getConnection("jdbc:mysql://192.168.22.52/coffechip?user=lezana&password=lezana");
        } catch (Exception e) {
            throw e;
        }
    }

    public void Desconecar() throws Exception {

        try {
            if (con != null) {
                if (this.con.isClosed() == false) {
                    con.close();
                }
            }
        } catch (Exception e) 
        {
            throw e;
            
        }
    }
}
