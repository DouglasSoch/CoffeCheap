package com.coffecheap.dao;

import com.coffecheap.modelo.Mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservaUsuaDao extends Dao
{
    public List<Mesa> mesas()
    {
        ResultSet rs;
        List<Mesa> lstMesa = null;
        
        try{
         this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("select id_mesa from mesa order by id_mesa");
            rs = ps.executeQuery();
            lstMesa = new ArrayList();
            
            while(rs.next())
            {
                Mesa mesa = new Mesa();
                mesa.setId_mesa(rs.getInt(1));
                lstMesa.add(mesa);
            }
        }catch(Exception e )
        {
        
        }
        return lstMesa;
        
    }
    
}
