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
import java.util.logging.Level;
import java.util.logging.Logger;



import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import org.primefaces.context.RequestContext;




/**
 *
 * @author medev
 */


@Named
@ViewScoped
public class LoginBean implements Serializable{

  Usuario usu=new Usuario();
  Usuario usuari=new Usuario();

    public Usuario getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuario usuari) {
        this.usuari = usuari;
    }

 
  public Usuario getUsu() {
    return usu;
  }

  public void setUsu(Usuario usu) {
    this.usu = usu;
  }

  public void miAction() throws Exception{   
   
        ValidarLoginDao dao=new ValidarLoginDao();
        try{
            usuari=dao.login(usu);

        }catch(Exception ex){
            throw ex;
        }
      
      try {
     
    
      
              if (usuari.getUsuario().equals(usu.getUsuario())) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nomb", usuari);
     FacesContext.getCurrentInstance().getExternalContext().redirect("contrasenia.xhtml");
        }else{
RequestContext.getCurrentInstance().execute("swal('Usuario Inexistente', 'Intentalo Otra Vez', 'error')");
                }
                   
     

              
    } catch (IOException ex) {
      Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
    }   
    }
  

 
  
  
  
  public void login() throws IOException{
 usuari=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nomb");
 
      
              
      if (usuari.getPass().equals(usu.getPass())) {
          FacesContext.getCurrentInstance().getExternalContext().redirect("MENUGENERAL.xhtml");
      }else{
          RequestContext.getCurrentInstance().execute("swal('Contraseña Incorreta', 'La Contraseña No Coincide Con El Usuario', 'error')");
      }
      
    
  }
}
