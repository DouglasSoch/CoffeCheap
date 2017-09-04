package com.coffecheap.bean;

import com.coffecheap.dao.ProveedorDao;
import com.coffecheap.modelo.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "proveedorBean")
@RequestScoped
public class ProveedorBean {

    Proveedor proveedor = new Proveedor();
    List <Proveedor> lista = new ArrayList();

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getLista() {
        return lista;
    }

    public void setLista(List<Proveedor> lista) {
        this.lista = lista;
    }
    
    public ProveedorBean() {
    }
    
    public void Ingresar() throws Exception{
        
        ProveedorDao dao;
        
        try {
            dao = new ProveedorDao();
            dao.Ingresar(proveedor);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Eliminar() throws Exception{
        
        ProveedorDao dao;
        
        try {
            dao = new ProveedorDao();
            dao.Borrar(proveedor);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Modificar() throws Exception{
        
        ProveedorDao dao;
        
        try {
            dao = new ProveedorDao();
            dao.Editar(proveedor);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Mostrar() throws Exception{
        
        ProveedorDao dao;
        
        try {
            dao = new ProveedorDao();
            lista = dao.Mostrar();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
