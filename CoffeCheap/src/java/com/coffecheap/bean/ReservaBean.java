package com.coffecheap.bean;

import com.coffecheap.dao.ReservaDao;
import com.coffecheap.modelo.Reserva;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author bryan
 */

@ManagedBean
@ViewScoped
public class ReservaBean 
{
    List<Reserva> lstReserva = new ArrayList();
    Reserva reserva = new Reserva();

    public List<Reserva> getLstReserva() {
        return lstReserva;
    }

    public void setLstReserva(List<Reserva> lstReserva) {
        this.lstReserva = lstReserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    
    
     public void registrar() throws Exception {
       
        ReservaDao dao ;
         
        try {
            

              String formateador = new SimpleDateFormat("yyyy-MM-dd").format(reserva.getFecha());
                        reserva.setFechaSus(formateador);
                    
                        
                        
                       dao = new ReservaDao();
                       dao.registrar(reserva);
                       
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
     public void mostar() throws Exception
    {
        ReservaDao dao;
        
        try
        {
            dao = new ReservaDao();
            lstReserva =dao.mostrar();
        }catch(Exception e)
        {
            throw e;
        }
    }
             
              public void mostarPorParametro() throws Exception
    {
        ReservaDao dao;
        
        try
        {
            dao = new ReservaDao();
            lstReserva =dao.mostrarPorPrarametro(reserva);
        }catch(Exception e)
        {
            throw e;
        }
    }
              
              public void buscar()throws Exception
               {
                   ReservaDao dao;
                   Reserva temp;
                   
                   try
                   {
                       dao = new ReservaDao();
                       temp = dao.leerParaModificar(reserva);
                       
                       if(reserva!=null)
                       {
                           this.reserva= temp;
                       }
                       
                   }catch(Exception e)
                   {
                       throw e;
                   }
               }
         public void modificar() throws Exception
    {
        ReservaDao dao;
        
        try
        {
            dao = new ReservaDao();
            dao.modificar(reserva);
        }catch(Exception e)
        {
            throw e;
        }
    }
         
           public void eliminar() throws Exception
    {
        ReservaDao dao;
        
        try
        {
            dao = new ReservaDao();
            dao.eliminar(reserva);
        }catch(Exception e)
        {
            throw e;
        }
    }
    
    
}
