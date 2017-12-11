/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;


import com.coffecheap.dao.ValidarLoginDao;
import com.coffecheap.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

/**
 *
 * @author medev
 */
@ManagedBean
@SessionScoped
public class Verificar_login implements Serializable {

    Usuario usu=new Usuario();
    String halo;

    public String getHalo() {
        return halo;
    }

    public void setHalo(String halo) {
        this.halo = halo;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }


    public void vrificarSession() throws IOException {
       
        try {
            
            Usuario usuario=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nomb");
          
            if (usuario==null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml"); 
            }else{
                usu=usuario;
            }
                
        } catch (Exception ex) {

        }
    }
    
    public void hola() throws Exception{
        ValidarLoginDao dao=new ValidarLoginDao();
        halo=dao.hola(usu);
    }
      
    public void cerrar() throws Exception{
         usu=new Usuario();
      FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml"); 
        
    }
           

}
