package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */
import com.coffecheap.dao.Control_mesaDao;
import com.coffecheap.dao.Facturar_Imp;
import com.coffecheap.modelo.Venta_factura;
import com.coffecheap.dao.Venta_facturaDao;
import com.coffecheap.modelo.Cliente;
import com.coffecheap.modelo.Control_mesa;
import com.coffecheap.modelo.Pedido;
import com.coffecheap.modelo.Proveedor_productos;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;

/**
 *
 * @author Bryan
 */
@ManagedBean
@ViewScoped
public class Venta_facturaBean {

    /**
     *
     * @param summary Texto que sera mostrado como una mensaje emergente
     */
    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Variables
     */
    private Venta_factura venta_factura = new Venta_factura();
    private List<Venta_factura> lstVenta_factura;
    private List<Proveedor_productos> lstProveedor_productos;
    private List<Cliente> lstCliente = new ArrayList();
    private List<Pedido> lstPedido = new ArrayList();

    public List<Cliente> getLstCliente() {
        return lstCliente;
    }

    public void setLstCliente(List<Cliente> lstCliente) {
        this.lstCliente = lstCliente;
    }

    public List<Pedido> getLstPedido() {
        return lstPedido;
    }

    public void setLstPedido(List<Pedido> lstPedido) {
        this.lstPedido = lstPedido;
    }

    public List<Proveedor_productos> getLstProveedor_productos() {
        return lstProveedor_productos;
    }

    public void setLstProveedor_productos(List<Proveedor_productos> lstProveedor_productos) {
        this.lstProveedor_productos = lstProveedor_productos;
    }

    public Venta_factura getVenta_factura() {
        return venta_factura;
    }

    public void setVenta_factura(Venta_factura venta_factura) {
        this.venta_factura = venta_factura;
    }

    public List<Venta_factura> getLstVenta_factura() {
        return lstVenta_factura;
    }

    public void setLstVenta_factura(List<Venta_factura> lstVenta_factura) {
        this.lstVenta_factura = lstVenta_factura;
    }

    /**
     * Metodo registrar
     */
    public void registrar() {

        System.out.println("*******************************************************registrar");

        Venta_facturaDao dao;

        try {

            String formateador = new SimpleDateFormat("yyyy-MM-dd").format(venta_factura.getFecha_emision());

            venta_factura.setTemp_fecha_emision(formateador);

            dao = new Venta_facturaDao();
            dao.registrar(venta_factura);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para listar
     */

    public void listarCliente() {
        Venta_facturaDao dao;
        try {
            dao = new Venta_facturaDao();
            lstCliente = dao.listarCliente();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para listar
     */
    public void listarPedido() {
        Venta_facturaDao dao;
        try {
            dao = new Venta_facturaDao();
            lstPedido = dao.listarPedido();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para listar
     */
    public void listar() {
        Venta_facturaDao dao;
        try {
            dao = new Venta_facturaDao();
            lstVenta_factura = dao.listar();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * metodo para obtener una fila de una tabla en un objeto
     *
     * @param vf Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void buscar(Venta_factura vf) throws Exception {
        Venta_facturaDao dao;
        Venta_factura temp;

        try {
            dao = new Venta_facturaDao();
            temp = dao.leerParaModificar(vf);
            if (venta_factura != null) {
                this.venta_factura = temp;
            }

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * metodo para mostrar
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Mostrar() throws Exception {
        Venta_facturaDao dao;

        try {
            dao = new Venta_facturaDao();
            lstVenta_factura = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para modificar el valor obetenido
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar() throws Exception {

        Venta_facturaDao dao;

        try {
            dao = new Venta_facturaDao();
            dao.modificar(venta_factura);

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo recibe objeto por parametro para eliminar
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Venta_factura mar) throws Exception {

        Venta_facturaDao dao;

        try {
            dao = new Venta_facturaDao();
            dao.eliminar(mar);

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo especial para registrar venta
     *
     * @param mesa Objeto de la clase
     * @param clienteid Objeto de la clase
     */
    public void registrar_venta(int mesa, int clienteid) {

        venta_factura.setEstadoFactura(true);

        Venta_facturaDao dao;
        Control_mesaDao dao2;

        try {

            dao = new Venta_facturaDao();
            dao.registrar_venta(venta_factura, mesa, clienteid);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para control de la factura
     *
     * @param mesa Objeto de la clase
     * @return boolean
     */
    public boolean controlGenerarFactura(int mesa) {

        boolean estado = false;
        Venta_facturaDao dao;

        try {

            dao = new Venta_facturaDao();
            estado = dao.controlGenerarFactura(venta_factura, mesa);

        } catch (Exception e) {
            System.out.println(e);
        }
        return estado;
    }

    /**
     * Metodo para ver archivos PDF
     *
     * @param actionEvent Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void verPDF(ActionEvent actionEvent) throws Exception {
        Facturar_Imp dao = new Facturar_Imp();

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report1.jasper"));

        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(dao.listar()));
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(bytes, 0, bytes.length);
        outStream.flush();
        outStream.close();

        FacesContext.getCurrentInstance().responseComplete();
    }
}
