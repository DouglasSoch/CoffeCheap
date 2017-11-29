package com.coffecheap.bean;

import com.coffecheap.dao.ClienteDao;
import com.coffecheap.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ClienteBean {

  Cliente cliente = new Cliente();
  List<Cliente> lstCliente = new ArrayList();

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<Cliente> getLstCliente() {
    return lstCliente;
  }

  public void setLstCliente(List<Cliente> lstCliente) {
    this.lstCliente = lstCliente;
  }

  public void registrar() throws Exception {
    ClienteDao dao;
    try {
      dao = new ClienteDao();
      dao.registrar(cliente);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  
  public void registrarN() throws Exception {
    ClienteDao dao;
    try {
      dao = new ClienteDao();
      dao.registrarN(cliente);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void mostar() throws Exception {
    ClienteDao dao;

    try {
      dao = new ClienteDao();
      lstCliente = dao.mostrar();
    } catch (Exception e) {
      throw e;
    }
  }
  
    public void listar() throws Exception {
    ClienteDao dao;
 
    try {
      dao = new ClienteDao();
      lstCliente = dao.listarNombre();
    } catch (Exception e) {
      throw e;
    }
  }

  public void mostarPorParametro() throws Exception {
    ClienteDao dao;

    try {
      dao = new ClienteDao();
      lstCliente = dao.mostrarPorPrarametro(cliente);
    } catch (Exception e) {
      throw e;
    }
  }

  public void buscar() throws Exception 
  {
        System.out.println("EL id es "+cliente.getId_cliente());
    ClienteDao dao;
    Cliente temp;
        System.out.println("EL id es "+cliente.getId_cliente());
    try {
      dao = new ClienteDao();
      temp = dao.leerParaModificarS(cliente);

      if (cliente != null) {
        this.cliente = temp;
      }

    } catch (Exception e) {
      throw e;
      
    }
  }
  
   public void buscarr() throws Exception 
  {
        System.out.println("EL id es "+cliente.getId_cliente());
    ClienteDao dao;
    Cliente temp;
        System.out.println("EL id es "+cliente.getId_cliente());
    try {
      dao = new ClienteDao();
      temp = dao.leerParaModificar(cliente);

      if (cliente != null) {
        this.cliente = temp;
      }

    } catch (Exception e) {
      throw e;
      
    }
  }

  public void modificar() throws Exception {
    ClienteDao dao;

    try {
      dao = new ClienteDao();
      dao.modificar(cliente);
    } catch (Exception e) {
      throw e;
    }
  }

  public void eliminar() throws Exception {
    ClienteDao dao;

    try {
      dao = new ClienteDao();
      dao.eliminar(cliente);
    } catch (Exception e) {
      throw e;
    }
  }

}
