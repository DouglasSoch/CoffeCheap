/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;


import com.coffecheap.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author medev
 */
public class ValidarLoginDao extends DAO{
     Usuario usuari=new Usuario();

    public Usuario getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuario usuari) {
        this.usuari = usuari;
    }
    
    
    public Usuario login(Usuario usu) throws Exception{
         usuari.setUsua("use154151fd51s5dfr");
            usuari.setPass("pa545454548asd415ss");
            usuari.setNombre("nomb45as4d54a5sdre");
            usuari.setTipouser(531684129);
            usuari.setApellido("as1d5as1d51a");
        try{
            this.conectar();
            System.out.println(usu.getUsua());
            PreparedStatement st=this.getCn().prepareStatement("select * from usuario where user='"+usu.getUsua()+"'");
            ResultSet rs=st.executeQuery();
            rs.next();
            
            usuari.setUsua(rs.getString("user"));
            usuari.setPass(rs.getString("pass"));
            usuari.setNombre(rs.getString("nombre"));
            usuari.setTipouser(rs.getInt("tipouser"));
            usuari.setApellido(rs.getString("apellido"));
        
            
           
               
        
        }catch(Exception ex){
          
        }finally{
            this.cerrar();
            
        }
        return usuari;
    }
}
