package com.coffecheap.bean;

import com.coffecheap.dao.CompraDao;
import com.coffecheap.dao.Dao;
import java.util.List;
import com.coffecheap.modelo.Compra;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CompraBean extends Dao {

    Compra compra = new Compra();
    List<Compra> lista;
    ArrayList<Compra> intermedio = new ArrayList();

    public List<Compra> getLista() {
        return lista;
    }

    public void setLista(List<Compra> lista) {
        this.lista = lista;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public CompraBean() {
    }

    public void Ingresar() throws Exception {

        CompraDao dao;

        try {
            dao = new CompraDao();
            dao.Insertar(compra);
        } catch (Exception e) {
            throw e;
        }
    }

    public void Eliminar() throws Exception {

        CompraDao dao;

        try {
            dao = new CompraDao();
            dao.Eliminar(compra);
        } catch (Exception e) {
            throw e;
        }
    }

    public void Modificar() throws Exception {

        CompraDao dao;

        try {
            dao = new CompraDao();
            dao.Modificar(compra);
        } catch (Exception e) {
            throw e;
        }
    }

    public void Mostrar() throws Exception {

        CompraDao dao;

        try {
            dao = new CompraDao();
            lista = dao.Mostrar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Ver() {

        CompraDao dao;

        try {
            dao = new CompraDao();
            dao.Prueba(compra);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Ver2(){
        
        CompraDao dao;
        
        try {
            dao = new CompraDao();
            dao.Prueba2(compra);
        } catch (Exception e) {
            throw e;
        }
    }

}
