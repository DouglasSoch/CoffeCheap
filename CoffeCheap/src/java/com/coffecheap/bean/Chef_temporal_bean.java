/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.Chef_temporal_Dao;
import com.coffecheap.modelo.Tem_chef;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author javam
 */
@ManagedBean
@ViewScoped
public class Chef_temporal_bean {
    ArrayList<Tem_chef> listchef=new ArrayList();
    Tem_chef chef=new Tem_chef();

    public ArrayList<Tem_chef> getListchef() {
        return listchef;
    }

    public void setListchef(ArrayList<Tem_chef> listchef) {
        this.listchef = listchef;
    }

    public Tem_chef getChef() {
        return chef;
    }

    public void setChef(Tem_chef chef) {
        this.chef = chef;
    }
    
    public void listar(){
        Chef_temporal_Dao dao=new Chef_temporal_Dao();
        try{
            listchef=dao.listar();
            
        }catch(Exception e){
            
        }
    }
    
      public String ControlColor(int valor) throws Exception {
    System.out.println("********************************Pago de mesa");
    Chef_temporal_Dao dao;
    String estado = null;
    try {
      dao = new Chef_temporal_Dao();
      estado = dao.ControlColor(valor);
    } catch (Exception e) {
      throw e;
    }

    System.out.println("" + valor + "* " + estado + "");
    return estado;
  }
      
      public void estado(){
          
      }
             
    
}
