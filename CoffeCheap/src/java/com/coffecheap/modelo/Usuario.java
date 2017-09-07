/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.modelo;

/**
 *
 * @author medev
 */
public class Usuario {
  public String usua;
  public String pass;
  public int tipouser;
  public String nombre;
  public String apellido;

    public int getTipouser() {
        return tipouser;
    }

 

    public void setTipouser(int tipouser) {
        this.tipouser = tipouser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

  public String getUsua() {
    return usua;
  }

  public void setUsua(String usua) {
    this.usua = usua;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }


}
