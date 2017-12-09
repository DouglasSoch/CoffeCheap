package com.coffecheap.bean;

import com.coffecheap.dao.Transaccion_InventarioDAO;
import com.coffecheap.modelo.Compra;
import com.coffecheap.modelo.Transaccion_inventario;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@ViewScoped
public class Transaccion_inventarioBean {

    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }



    
    Transaccion_inventario traInv = new Transaccion_inventario();
    List<Transaccion_inventario> lsttraInv2 = new ArrayList();
    List<Transaccion_inventario> lsttraInv = new ArrayList();
    List<Compra> lsttraFac = new ArrayList();
    String fechaSus = null;
    
    
    

    public List<Compra> getLsttraFac() {
        return lsttraFac;
    }

    public void setLsttraFac(List<Compra> lsttraFac) {
        this.lsttraFac = lsttraFac;
    }

   

    
    public List<Transaccion_inventario> getLsttraInv2() {
        return lsttraInv2;
    }

    public void setLsttraInv2(List<Transaccion_inventario> lsttraInv2) {
        this.lsttraInv2 = lsttraInv2;
    }

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
            
             if (traInv.getProducto().getId_producto() == 0) {
                addMessage("Eliga Producto ");
            } 
            else 
            {
                if(traInv.getTtransaccion().getId_tipo_transacciones()==0)
                {
                    addMessage("Eliga tipo de transaccion");
                }
                else
                 {
                     if(traInv.getTtransaccion().getId_tipo_transacciones()==1)
                     {
                       addMessage("Solo se pueden hacer salidas");
                     }
                     else
                     {
                         if(traInv.getCantidad()==0)
                         {
                             addMessage("Ingrese Cantidad");
                         }
                         else
                         {
                             if(traInv.getDetalle().equals(""))
                             {
                                 addMessage("Ingrese Detalle");
                             }
                             else
                             {
                                 if(traInv.getCompra().getId_compras()==0)
                                 {
                                     addMessage("Eliga una factua");
                                 }
                                 else
                                 {
                                 SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                                 Date fecha = new Date();
                                 String fechaString = formateador.format(fecha);
                                 Date tranformada = formateador.parse(fechaString);
                                 fechaSus = fechaString;
                                 traInv.setFecha(tranformada);
                                 dao.registrar(traInv);
                                 resta();
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

    public void mostar() throws Exception {
        Transaccion_InventarioDAO dao;

        try {
            dao = new Transaccion_InventarioDAO();
            lsttraInv = dao.mostrar();
        } catch (Exception e) {
            throw e;
        }
    }

   
    public void leerParaModificarProducto() throws Exception {
        Transaccion_InventarioDAO dao;

        try {
            dao = new Transaccion_InventarioDAO();
            lsttraInv2 = dao.listarParaModificarProducto();
        } catch (Exception e) {
            throw e;
        }
    }
    
        public void numeroFac() throws Exception {
        Transaccion_InventarioDAO dao;

        try {
            dao = new Transaccion_InventarioDAO();
            lsttraFac = dao.listarCompraFactura();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerParaModificarTipoTransacciones() throws Exception {
        Transaccion_InventarioDAO dao;

        try {
            dao = new Transaccion_InventarioDAO();
            lsttraInv = dao.listarParaModificarTtransaccion();
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscar(Transaccion_inventario tra) throws Exception {
        Transaccion_InventarioDAO dao;
        Transaccion_inventario temp;

        try {
            dao = new Transaccion_InventarioDAO();
            temp = dao.leerParaModificar(tra);
            if (traInv != null) {
                this.traInv = temp;
            }

        } catch (Exception e) {
            throw e;
        }
    }
   
                     public void modificar() throws Exception
    {
        
        Transaccion_InventarioDAO dao ;
        
        try
        {
            dao= new Transaccion_InventarioDAO();
            dao.modificar(traInv);
            
        }catch(Exception e)
        {
            throw e;
        }
    }
    
     public void eliminar(Transaccion_inventario tra) throws Exception
    {
        
        Transaccion_InventarioDAO dao ;
        
        try
        {
            dao= new Transaccion_InventarioDAO();
            dao.eliminar(tra);
            
        }catch(Exception e)
        {
            throw e;
        }
    }
     public void resta() throws Exception
    {
        
        Transaccion_InventarioDAO dao ;
        
        try
        {
            dao= new Transaccion_InventarioDAO();
            dao.resta(traInv);
            
        }catch(Exception e)
        {
            throw e;
        }
    }
                     
    
}
