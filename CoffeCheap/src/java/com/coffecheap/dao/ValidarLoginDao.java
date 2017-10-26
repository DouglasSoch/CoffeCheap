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
public class ValidarLoginDao extends Dao{
     Usuario usuari=new Usuario();

    public Usuario getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuario usuari) {
        this.usuari = usuari;
    }
    
    
    public Usuario login(Usuario usu) throws Exception{
         usuari.setUsuario("use154151fd51s5dfr");
            usuari.setPass("pa545454548asd415ss");
            usuari.setNombre("nomb45as4d54a5sdre");
            usuari.getTipo().setId(53168412);
            usuari.setApellido("as1d5as1d51a");
        try{
            this.Conectar();
            System.out.println(usu.getUsuario());
            PreparedStatement st=this.getCon().prepareStatement("select * from usuario where user='"+usu.getUsuario()+"'");
            ResultSet rs=st.executeQuery();
            rs.next();
            
            usuari.setUsuario(rs.getString("user"));
            usuari.setPass(rs.getString("pass"));
            usuari.setNombre(rs.getString("nombre"));
            usuari.getTipo().setId(rs.getInt("tipouser"));
            usuari.setApellido(rs.getString("apellido"));
            usuari.setId(rs.getInt("iduser"));
        
            
           
               
        
        }catch(Exception ex){
          
        }finally{
            this.Desconecar();
            
        }
        return usuari;
    }
}
