/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.Plato_pedidoDao;
import com.coffecheap.modelo.Plato_pedido;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bryan
 */
@Named(value = "plato_pedidoBean")
@ManagedBean
@ViewScoped
public class Plato_pedidoBean {

    /**
     * Metodo para mostrar un mensaje emergente desde una instnacia de
     * Plato_pedidoBean
     *
     * @param summary String
     */
    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    private Plato_pedido plapedido = new Plato_pedido();
    private List<Plato_pedido> lstPlapedido;

    public Plato_pedido getPlapedido() {
        return plapedido;
    }

    public void setPlapedido(Plato_pedido plapedido) {
        this.plapedido = plapedido;
    }

    public List<Plato_pedido> getLstPlapedido() {
        return lstPlapedido;
    }

    public void setLstPlapedido(List<Plato_pedido> lstPlapedido) {
        this.lstPlapedido = lstPlapedido;
    }

    /**
     * Metodo para registrar un plato pedido
     */
    public void registrar() {
          try {
        if (plapedido.getPlato().getId_plato() == 0) {
            addMessage("Seleccione el Plato");
        } else {
            if (plapedido.getCantidad() == 0) {
                addMessage("Ingrese la Cantidad");
            } else {
                if (plapedido.getCantidad() == 0) {
                    addMessage("Ingrese la Cantidad");
                } else {
                    if (plapedido.getUsuario().getId() == 0) {
                        addMessage("Seleccione el Usuario");
                    } else {
                        if (plapedido.getPedido().getId_pedido() == 0) {
                            addMessage("Seleccione el Pedido");
                        } else {
                            if (plapedido.getPrecio() == 0) {
                                addMessage("Ingrese el Precio");
                            } else {

                                Plato_pedidoDao dao;
                              
                                    dao = new Plato_pedidoDao();
                                    dao.registrar(plapedido);
                                }}}}}}
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                            }
                            /**
                             * Metodo para listar todos los registros de plato
                             * pedido
                             *
                             * @throws Exception por si resulta un error de SQL
                             */
    public void listar() throws Exception {
        Plato_pedidoDao dao;

        try {
            dao = new Plato_pedidoDao();
            lstPlapedido = dao.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para obtener una fila en un objeto de plato pedido
     *
     * @param platoP Objeto de la clase
     */
    public void fila(Plato_pedido platoP) {
        Plato_pedidoDao dao;
        Plato_pedido temp;
        try {
            dao = new Plato_pedidoDao();
            temp = dao.leerParaModificar(platoP);
            if (temp != null) {
                this.plapedido = temp;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo para modificar un plato pedido
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar() throws Exception {
        Plato_pedidoDao dao;

        try {
            dao = new Plato_pedidoDao();
            dao.modificar(plapedido);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para eliminar un plato pedido
     *
     * @param plapedido Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Plato_pedido plapedido) throws Exception {
        Plato_pedidoDao dao;
        try {
            dao = new Plato_pedidoDao();
            dao.eliminar(plapedido);
        } catch (Exception e) {
            throw e;
        }

    }

}
