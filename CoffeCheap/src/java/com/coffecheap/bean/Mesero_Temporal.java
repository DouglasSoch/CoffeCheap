/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.MeseroTemporalDao;
import com.coffecheap.modelo.Plato;
import com.coffecheap.modelo.Tem_chef;
import com.coffecheap.modelo.Tipo_plato;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author medev
 */
@ManagedBean
@ViewScoped
public class Mesero_Temporal {
    private Tipo_plato tplato=new Tipo_plato();
        private Tem_chef chef=new Tem_chef();
        private ArrayList<Tem_chef> listchef=new ArrayList();
        private ArrayList<Tem_chef> listchefunico=new ArrayList();

    public ArrayList<Tem_chef> getListchefunico() {
        return listchefunico;
    }

    public void setListchefunico(ArrayList<Tem_chef> listchefunico) {
        this.listchefunico = listchefunico;
    }
        int a=-1;

    public Tipo_plato getTplato() {
        return tplato;
    }

    public void setTplato(Tipo_plato tplato) {
        this.tplato = tplato;
    }

    public Tem_chef getChef() {
        return chef;
    }

    public void setChef(Tem_chef chef) {
        this.chef = chef;
    }

    public ArrayList<Tem_chef> getListchef() {
        return listchef;
    }

    public void setListchef(ArrayList<Tem_chef> listchef) {
        this.listchef = listchef;
    }

    public ArrayList<Tipo_plato> getListtipo() {
        return listtipo;
    }

    public void setListtipo(ArrayList<Tipo_plato> listtipo) {
        this.listtipo = listtipo;
    }

    public ArrayList<Plato> getListplato() {
        return listplato;
    }

    public void setListplato(ArrayList<Plato> listplato) {
        this.listplato = listplato;
    }

    private ArrayList<Tipo_plato> listtipo=new ArrayList();
    private ArrayList<Plato> listplato=new ArrayList();

  
    

    
    
    
    
    public ArrayList listartipo() throws Exception{
        MeseroTemporalDao dao;
        try{
            dao=new MeseroTemporalDao();
            listtipo=dao.listar();

        }catch(Exception ex){
            throw ex;
        }
        return listtipo;
    }
    
   public ArrayList listarplato() throws Exception{
       
        MeseroTemporalDao dao;
        try{
            dao=new MeseroTemporalDao();
            listplato=dao.listar2(chef);

        }catch(Exception ex){
            throw ex;
        }
        return listplato;
    }
   
   

        
   
       
   
   
   public void listar(){
     
             
       a=a+1;
     
      
           chef.setCodigounico(a);
       listchef.add(chef);
     
         
       chef=new Tem_chef();
    
        
   }
   
     public void leerId(Tem_chef espe) throws Exception{
      
            try{
                listchefunico=new ArrayList();
                   chef=espe;
                   listchefunico.add(chef);
                        
          chef=new Tem_chef();
   
        }catch(Exception ex){
            throw ex;
        }
           
      
           
    }
   
    public void eliminar(Tem_chef espe){
        listchef.remove(espe.getCodigounico());
                
        
      }
    
}
