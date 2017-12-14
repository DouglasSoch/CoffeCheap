package com.coffecheap.bean;

import com.coffecheap.dao.ProveedorDao;
import com.coffecheap.modelo.Proveedor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author bryan
 */
@ManagedBean
@ViewScoped
public class ProveedorBean {

    Proveedor proveedor = new Proveedor();
    List<Proveedor> listar;

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListar() {
        return listar;
    }

    public void setListar(List<Proveedor> listar) {
        this.listar = listar;
    }

    public ProveedorBean() {
    }

    /**
     * Metodo para registrar un proveedor
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Ingresar() throws Exception {

        ProveedorDao dao;

        try {
            dao = new ProveedorDao();
            dao.Ingresar(proveedor);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para eliminar un proveedor
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Eliminar() throws Exception {

        ProveedorDao dao;

        try {
            dao = new ProveedorDao();
            dao.Borrar(proveedor);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para Modifcar un proveedor
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Modificar() throws Exception {

        ProveedorDao dao;

        try {
            dao = new ProveedorDao();
            dao.Editar(proveedor);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para listar todos los registros de proveedor
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Mostrar() throws Exception {

        ProveedorDao dao;

        try {
            dao = new ProveedorDao();
            listar = dao.Mostrar();
        } catch (Exception e) {
            throw e;
        }
    }

}
