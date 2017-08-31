package com.coffecheap.bean;

import com.coffecheap.dao.TurnoDao;
import com.coffecheap.modelo.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "turnoBean")
@RequestScoped
public class TurnoBean {

    Turno turno = new Turno();
    List <Turno> lista = new ArrayList();

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public List<Turno> getLista() {
        return lista;
    }

    public void setLista(List<Turno> lista) {
        this.lista = lista;
    }
    
    public TurnoBean() {
    }
    
    public void Ingreso() throws Exception{
        
        TurnoDao dao;
        
        try {
            dao = new TurnoDao();
            dao.Ingresar(turno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Eliminar() throws Exception{
        
        TurnoDao dao;
        
        try {
            dao = new TurnoDao();
            dao.Eliminar(turno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Modificar()throws Exception{
        
        TurnoDao dao;
        
        try {
            dao = new TurnoDao();
            dao.Modificar(turno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Mostrar() throws Exception{
        
        TurnoDao dao;
        
        try {
            dao = new TurnoDao();
            lista = dao.Mostrar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
