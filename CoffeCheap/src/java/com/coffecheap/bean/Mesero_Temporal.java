/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.MeseroTemporalDao;
import com.coffecheap.modelo.Plato;
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
        private Plato tplato2=new Plato();
    private ArrayList<Tipo_plato> listtipo=new ArrayList();
    private ArrayList<Plato> listplato=new ArrayList();

    public ArrayList<Plato> getListplato() {
     
        return listplato;
    }

    public void setListplato(ArrayList<Plato> listplato) {
        this.listplato = listplato;
    }

    public ArrayList<Tipo_plato> getListtipo() {
        return listtipo;
    }

    public void setListtipo(ArrayList<Tipo_plato> listtipo) {
        this.listtipo = listtipo;
    }

    public Tipo_plato getTplato() {
        return tplato;
    }

    public void setTplato(Tipo_plato tplato) {
        this.tplato = tplato;
    }
    
    
    
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
            listplato=dao.listar2(tplato);

        }catch(Exception ex){
            throw ex;
        }
        return listplato;
    }
    
    
}
