package com.coffecheap.bean;

import com.coffecheap.dao.ReservaUsuaDao;
import com.coffecheap.modelo.Mesa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author bryan
 */
@ManagedBean
@ViewScoped
public class ReservaUsuBean {

    List<Mesa> lstMesa = new ArrayList();

    public List<Mesa> getLstMesa() {
        return lstMesa;
    }

    public void setLstMesa(List<Mesa> lstMesa) {
        this.lstMesa = lstMesa;
    }

    /**
     * Metodo para listar las mesas
     */
    public void mesa() {

        ReservaUsuaDao dao;
        try {
            dao = new ReservaUsuaDao();
            lstMesa = dao.mesas();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para el control del estado de las mesas
     *
     * @param mesa Objeto de la clase
     * @return retorna el estado de la mesa
     * @throws Exception posible excepciones en el metodo
     */
    public String ControlEstado(int mesa) throws Exception {
        ReservaUsuaDao dao;
        String estado = null;
        try {
            dao = new ReservaUsuaDao();
            estado = dao.ControlEstado(mesa);
        } catch (Exception e) {
            throw e;
        }
        System.out.println("" + mesa + "* " + estado + "");
        return estado;
    }

    /**
     * Metodo
     *
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int tamano() throws Exception {
        ReservaUsuaDao dao;
        int numero = 0;
        try {
            dao = new ReservaUsuaDao();
            numero = dao.tamaño();
        } catch (Exception e) {
            throw e;
        }
        System.out.println("El numero de mesas es " + numero);
        return numero;
    }

    /**
     * Metodo para verificar cambio de estados en la mesa
     *
     * @param MesaSelecionada Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void CambioEstado(int MesaSelecionada) throws Exception {

        ReservaUsuaDao dao;

        try {
            dao = new ReservaUsuaDao();
            dao.CamBioEstado(MesaSelecionada);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para cantidad de personas por mesa
     *
     * @param MesaSelecionada Objeto de la clase
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int comensales(int MesaSelecionada) throws Exception {
        int numero = 0;
        ReservaUsuaDao dao;

        try {
            dao = new ReservaUsuaDao();
            numero = dao.comensales(MesaSelecionada);
        } catch (Exception e) {
            throw e;
        }
        return numero;

    }
}
