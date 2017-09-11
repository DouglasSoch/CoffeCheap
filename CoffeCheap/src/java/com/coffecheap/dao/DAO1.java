/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author medev
 */
public class DAO1 {

    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginAxel?user=root&password=intecap");

        } catch (Exception ex) {
            throw ex;
        
        }
    }

    public void cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

}
