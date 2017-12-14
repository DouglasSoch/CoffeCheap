package com.coffecheap.bean;

import com.coffecheap.modelo.Orden_compras;
import com.coffecheap.dao.Orden_comprasDao;
import com.coffecheap.modelo.Proveedor_productos;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bryan
 */
@ManagedBean
@ViewScoped
public class Orden_comprasBean {

    private Orden_compras orden_compras = new Orden_compras();
    private List<Orden_compras> lstOrden_compras;
    List<Proveedor_productos> lstProveedor_productos;

    public List<Proveedor_productos> getLstProveedor_productos() {
        return lstProveedor_productos;
    }

    public void setLstProveedor_productos(List<Proveedor_productos> lstProveedor_productos) {
        this.lstProveedor_productos = lstProveedor_productos;
    }

    public Orden_compras getOrden_compras() {
        return orden_compras;
    }

    public void setOrden_compras(Orden_compras orden_compras) {
        this.orden_compras = orden_compras;
    }

    public List<Orden_compras> getLstOrden_compras() {
        return lstOrden_compras;
    }

    public void setLstOrden_compras(List<Orden_compras> lstOrden_compras) {
        this.lstOrden_compras = lstOrden_compras;
    }

    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Metodo para registrar una orden de compras
     */
    public void registrar() {
        Orden_comprasDao dao;
        try {
            if (orden_compras.getId_orden_compras() == 0) {
                addMessage("Ingrese El Id de Compra");
            } else {
                if (orden_compras.getTemp_fecha_orden().equals("")) {
                    addMessage("Seleccione la Fecha de La orden");
                } else {
                    if (orden_compras.getTemp_fecha_entrega().equals("")) {
                        addMessage("Seleccione la Fecha de Entrega");
                    } else {
                        if (orden_compras.getCantidad() == 0) {
                            addMessage("Ingrese La Cantidad");
                        } else {
                            if (orden_compras.getPproductos().getProveedor().getId_proveedor() == 0) {
                                addMessage("Seleccione El Proveedor");
                            } else {
                                if (orden_compras.getPproductos().getProducto().getId_producto() == 0) {
                                    addMessage("Seleccione Un Producto");
                                } else {

                                    dao = new Orden_comprasDao();
                                    dao.registrar(orden_compras);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para listar todos los registros de orden de compras
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Mostrar() throws Exception {
        Orden_comprasDao dao;

        try {
            dao = new Orden_comprasDao();
            lstOrden_compras = dao.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para modificar una orden de compras
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Orden_compras mar) throws Exception {
        System.out.println("*******************************************************Modificar");
        Orden_comprasDao dao;

        try {
            dao = new Orden_comprasDao();
            dao.modificar(mar);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para eliminar una orden de compras
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Orden_compras mar) throws Exception {
        System.out.println("*******************************************************eliminar");
        Orden_comprasDao dao;

        try {
            dao = new Orden_comprasDao();
            dao.eliminar(mar);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para listar el proveedor_Producto
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Mostrar_Prov_Produ() throws Exception {
        //Mostrar Proveedor_produc
        Orden_comprasDao dao;

        try {
            dao = new Orden_comprasDao();
            lstProveedor_productos = dao.ListarProveedor_Produ(orden_compras);
        } catch (Exception e) {
            throw e;
        }
    }

}
