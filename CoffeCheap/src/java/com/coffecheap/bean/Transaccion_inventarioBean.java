package com.coffecheap.bean;


import com.coffecheap.dao.Transaccion_InventarioDAO;
import com.coffecheap.modelo.Transaccion_inventario;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Transaccion_inventarioBean {

    Transaccion_inventario traInv = new Transaccion_inventario();
    List<Transaccion_inventario> lsttraInv = new ArrayList();
    String fechaSus = null;

    public String getFechaSus() {
        return fechaSus;
    }

    public void setFechaSus(String fechaSus) {
        this.fechaSus = fechaSus;
    }

    public Transaccion_inventario getTraInv() {
        return traInv;
    }

    public void setTraInv(Transaccion_inventario traInv) {
        this.traInv = traInv;
    }

    public List<Transaccion_inventario> getLsttraInv() {
        return lsttraInv;
    }

    public void setLsttraInv(List<Transaccion_inventario> lsttraInv) {
        this.lsttraInv = lsttraInv;
    }

    public void registrar() throws Exception {

        Transaccion_InventarioDAO dao = new Transaccion_InventarioDAO();

        try {
            
            if (traInv.getTtransaccion().getId_tipo_transacciones() != 0) {
                if (traInv.getProducto().getId_producto() != 0) {
                    if (traInv.getId_transaccion() != 0) {
                        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                        Date fecha = new Date();
                        String fechaString = formateador.format(fecha);
                        Date tranformada = formateador.parse(fechaString);

                        fechaSus = fechaString;
                        traInv.setFecha(tranformada);
                        
                        dao.registrar(traInv);
                    }

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*
             public void mostar() throws Exception
    {
        Transaccion_InventarioDAO dao;
        
        try
        {
            dao = new Transaccion_InventarioDAO();
            lstoc =dao.mostrar();
        }catch(Exception e)
        {
            throw e;
        }
    }
        
            public void mostarPorParametro() throws Exception
    {
        Transaccion_InventarioDAO dao;
        
        try
        {
            dao = new Transaccion_InventarioDAO();
            lstoc =dao.mostrarPorPrarametro(oc);
        }catch(Exception e)
        {
            throw e;
        }
    }
            
                 public void eliminar() throws Exception
    {
        
        Transaccion_InventarioDAO dao = new Transaccion_InventarioDAO();
        
        try
        {
            dao.eliminar(oc);
            
        }catch(Exception e)
        {
            throw e;
        }
    }
                 public void listaParaModificar() throws Exception
    {
        Transaccion_InventarioDAO dao = new Transaccion_InventarioDAO();
        
        try
        {
            lstoc =dao.listarParaModificar();
        }catch(Exception e)
        {
            throw e;
        }
    }
                 public void modificar() throws Exception
    {
        
        Transaccion_InventarioDAO dao = new Transaccion_InventarioDAO();
        
        try
        {
            dao.modificar(oc);
            
        }catch(Exception e)
        {
            throw e;
        }
    }
     */
}
