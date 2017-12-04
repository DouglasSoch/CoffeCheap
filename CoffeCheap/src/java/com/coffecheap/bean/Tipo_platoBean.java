package com.coffecheap.bean;

import com.coffecheap.dao.TipoUsuarioDao;
import com.coffecheap.dao.Tipo_platoDao;
import com.coffecheap.modelo.Tipo_plato;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Tipo_platoBean 
{
    
      static public void addMessage(String summary) 
      {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }
   private Tipo_plato tipoPlato = new Tipo_plato();
   private List<Tipo_plato>lstTipo_plato;

    public Tipo_plato getTipo_plato() {
        return tipoPlato;
    }

    public void setTipo_plato(Tipo_plato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    public List<Tipo_plato> getLstTipo_plato() {
        return lstTipo_plato;
    }

    public void setLstTipo_plato(List<Tipo_plato> lstTipo_plato) {
        this.lstTipo_plato = lstTipo_plato;
    }
    
    public void registrar() 
    {
    Tipo_platoDao dao ;
    try 
    {
      dao = new Tipo_platoDao();
      dao.registrar(tipoPlato);
    }
    catch (Exception e) 
    {
      System.out.println(e);
    }

  }
    
    public void fila(Tipo_plato tipo) 
  {
    Tipo_platoDao dao;
    Tipo_plato temp;
    try 
    {
      dao = new Tipo_platoDao();
      temp = dao.leerFila(tipo);
      if(temp !=null)
      {
          this.tipoPlato= temp;
      }
      
    } catch (Exception e) 
    {
      System.out.println(e);
    }
  }

  public void listar() throws Exception 
  {
    Tipo_platoDao dao;
    try 
    {
      dao = new Tipo_platoDao();
      lstTipo_plato = dao.listar();
    }
    catch (Exception e) 
    {
      throw e;
    }

  }


  
  public void modificar() throws Exception 
  { 
    Tipo_platoDao dao;
    try 
    {
      dao = new Tipo_platoDao();
      dao.modificar(tipoPlato);

    }
    catch (Exception e) 
    {
      throw e;
    }

  }


  public void eliminar(Tipo_plato tipoPlato) throws Exception 
  {
    Tipo_platoDao dao;
    try 
    {
      dao = new Tipo_platoDao();
      dao.eliminar(tipoPlato);

    }
    catch (Exception e) 
    {
      throw e;
    }

  }
}
