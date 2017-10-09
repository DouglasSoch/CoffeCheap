package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */
import com.coffecheap.modelo.Control_mesa;
import com.coffecheap.modelo.EstadoPago;
import com.coffecheap.dao.Control_mesaDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class Control_mesaBean {

  static public void addMessage(String summary) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }

  private Control_mesa control_mesa = new Control_mesa();
  private List<Control_mesa> lstControl_mesa;
  private EstadoPago datoEstado;

  public EstadoPago getDatoEstado() {
    return datoEstado;
  }

  public void setDatoEstado(EstadoPago datoEstado) {
    this.datoEstado = datoEstado;
  }

  public Control_mesa getControl_mesa() {
    return control_mesa;
  }

  public void setControl_mesa(Control_mesa control_mesa) {
    this.control_mesa = control_mesa;
  }

  public List<Control_mesa> getLstControl_mesa() {
    return lstControl_mesa;
  }

  public void setLstControl_mesa(List<Control_mesa> lstControl_mesa) {
    this.lstControl_mesa = lstControl_mesa;
  }

  public void registrar() {

    System.out.println("*******************************************************registrar");

    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      dao.registrar(control_mesa);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      lstControl_mesa = dao.listarMesaOcupadas();
    } catch (Exception e) {
      throw e;
    }

  }

  public int tamano() throws Exception {
    Control_mesaDao dao;
    int numero = 0;
    try {
      dao = new Control_mesaDao();
      numero = dao.tamaño();
    } catch (Exception e) {
      throw e;
    }
    System.out.println("El numero de mesas es " + numero);
    return numero;

  }

  public void eliminar(Control_mesa mar) throws Exception {
    System.out.println("*******************************************************eliminar");
    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

  public void CambioEstado(int MesaSelecionada) throws Exception {
    System.out.println("********************************Cambio Estado de mesa");
    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      dao.CamBioEstado(MesaSelecionada);
    } catch (Exception e) {
      throw e;
    }
  }

  public boolean HabilitarPago(int mesa) throws Exception {
    System.out.println("********************************Pago de mesa");
    Control_mesaDao dao;
    boolean pago = false;
    try {
      dao = new Control_mesaDao();
      pago = dao.HabilitarPago(mesa);
    } catch (Exception e) {
      throw e;
    }

    System.out.println("" + mesa + "* " + pago + "");
    return pago;
  }

  public String EstaPago(int mesa) throws Exception {
    System.out.println("********************************Pago de mesa");
    Control_mesaDao dao;
    String pago = null;
    try {
      dao = new Control_mesaDao();
      pago = dao.EstaPago(mesa);
    } catch (Exception e) {
      throw e;
    }

    System.out.println("" + mesa + "* " + pago + "");
    return pago;
  }

  public String ControlEstado(int mesa) throws Exception {
    System.out.println("********************************Pago de mesa");
    Control_mesaDao dao;
    String estado = null;
    try {
      dao = new Control_mesaDao();
      estado = dao.ControlEstado(mesa);
    } catch (Exception e) {
      throw e;
    }

    System.out.println("" + mesa + "* " + estado + "");
    return estado;
  }

  public void RegistrarPago(int Mesa) throws Exception {
    System.out.println("********************************Registrar Pago");
    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      dao.RegistrarPago(Mesa);
    } catch (Exception e) {
      throw e;
    }
  }

  public void LimpiarMesa(int Mesa) throws Exception {
    System.out.println("********************************Limpiar Mesa");
    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      dao.LimpiarMesa(Mesa);

    } catch (Exception e) {
      throw e;
    }
  }

}
