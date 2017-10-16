package com.coffecheap.bean;

import com.coffecheap.dao.ReservaUsuaDao;
import com.coffecheap.modelo.Mesa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ReservaUsuBean
{
    List<Mesa> lstMesa = new ArrayList();

    public List<Mesa> getLstMesa() {
        return lstMesa;
    }

    public void setLstMesa(List<Mesa> lstMesa) {
        this.lstMesa = lstMesa;
    }
    
    
    public void mesa()
    {
        
    ReservaUsuaDao dao;
    try
    {
     dao = new ReservaUsuaDao();
    lstMesa = dao.mesas();
    }catch(Exception e)
    {
        System.out.println(e);   
    }
    
    }
}
