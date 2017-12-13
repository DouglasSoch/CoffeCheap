package com.coffecheap.bean;

import com.coffecheap.dao.TurnoDao;
import com.coffecheap.modelo.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * 
 * @author Douglas
 */

@ManagedBean
@ViewScoped
public class TurnoBean {

    Turno turno = new Turno();
    List <Turno> listar = new ArrayList();
    
    

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public List<Turno> getListar() {
        return listar;
    }

    public void setListar(List<Turno> listar) {
        this.listar = listar;
    }
    
    public TurnoBean() {
    }
    
    /**
     * Metodo para registrar 
     * @throws Exception 
     */
    public void Ingreso() throws Exception{
        
        TurnoDao dao;
        
        try {
            dao = new TurnoDao();
            dao.Ingresar(turno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Metodo para eliminar
     * @throws Exception 
     */
    public void Eliminar() throws Exception{
        
        TurnoDao dao;
        
        try {
            dao = new TurnoDao();
            dao.Eliminar(turno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Metodo para modificar u registro
     * @throws Exception 
     */
    public void Editar()throws Exception{
        
        TurnoDao dao;
        
        try {
            dao = new TurnoDao();
            dao.Modificar(turno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Metodo para listar
     * @throws Exception 
     */
    public void Mostrar() throws Exception{
        
        TurnoDao dao;
        
        try {
            dao = new TurnoDao();
            listar = dao.Visualizar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
