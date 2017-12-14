package com.coffecheap.bean;

import com.coffecheap.modelo.Tipo_transacciones;
import com.coffecheap.dao.Tipo_transaccionesDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Santi
 */
@ManagedBean
@ViewScoped
public class Tipo_transaccionesBean {

    private Tipo_transacciones tipo_transacciones = new Tipo_transacciones();
    private List<Tipo_transacciones> lstTipo_transacciones;

    public Tipo_transacciones getTipo_transacciones() {
        return tipo_transacciones;
    }

    public void setTipo_transacciones(Tipo_transacciones tipo_transacciones) {
        this.tipo_transacciones = tipo_transacciones;
    }

    public List<Tipo_transacciones> getLstTipo_transacciones() {
        return lstTipo_transacciones;
    }

    public void setLstTipo_transacciones(List<Tipo_transacciones> lstTipo_transacciones) {
        this.lstTipo_transacciones = lstTipo_transacciones;
    }

    /**
     * Metodo para registrar
     */
    public void registrar() {

        System.out.println("*******************************************************registrar");

        Tipo_transaccionesDao dao;

        try {
            dao = new Tipo_transaccionesDao();
            dao.registrar(tipo_transacciones);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para listar
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listar() throws Exception {
        Tipo_transaccionesDao dao;

        try {
            dao = new Tipo_transaccionesDao();
            lstTipo_transacciones = dao.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para modificar
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Tipo_transacciones mar) throws Exception {
        System.out.println("*******************************************************Modificar");
        Tipo_transaccionesDao dao;

        try {
            dao = new Tipo_transaccionesDao();
            dao.modificar(mar);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para eliminar
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Tipo_transacciones mar) throws Exception {
        System.out.println("*******************************************************eliminar");
        Tipo_transaccionesDao dao;

        try {
            dao = new Tipo_transaccionesDao();
            dao.eliminar(mar);

        } catch (Exception e) {
            throw e;
        }

    }

}
