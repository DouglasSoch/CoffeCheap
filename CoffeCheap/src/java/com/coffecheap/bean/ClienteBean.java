package com.coffecheap.bean;

import com.coffecheap.dao.ClienteDao;
import com.coffecheap.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ClienteBean 
{

    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
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
  
  
    public void fila(Cliente clie) throws Exception 
  {
    ClienteDao dao;
    Cliente temp;
    try {
      dao = new ClienteDao();
      temp = dao.leerFila(clie);

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

  public void eliminar(Cliente cli) throws Exception {
    ClienteDao dao;

    try {
      dao = new ClienteDao();
      dao.eliminar(cli);
    } catch (Exception e) {
      throw e;
    }
  }

}
