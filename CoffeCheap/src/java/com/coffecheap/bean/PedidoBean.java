package com.coffecheap.bean;

/**
 *
 * @Pedhor acier
 */
import com.coffecheap.modelo.Pedido;
import com.coffecheap.dao.PedidoDao;
import java.sql.Time;
import java.text.SimpleDateFormat;

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
public class PedidoBean {

    /**
     * Metodo para mostrar un mensaje emergente desde una instancia de
     * PedidoBean
     *
     * @param summary String
     */
    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    private Pedido pedido = new Pedido();
    private List<Pedido> lstPedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getLstPedido() {
        return lstPedido;
    }

    public void setLstPedido(List<Pedido> lstPedido) {
        this.lstPedido = lstPedido;
    }

    /**
     * Metodo para registrar un pedido
     */
    public void registrar() {

        PedidoDao dao;
        try {
            if (pedido.getMesa().getId_mesa() == 0) {
                addMessage("Seleccione Una Mesa");
            } else {
                if (pedido.getHoraS().equals("")) {
                    addMessage("Ingrese La Hora");
                } else {
                    if (pedido.getUsuario().getId() == 0) {
                        addMessage("Seleccione el usuario");
                    } else {
                        if (pedido.getTemp_fecha().equals("")) {
                            addMessage("Seleccione la Fecha");
                        } else {

                            dao = new PedidoDao();
                            dao.registrar(pedido);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para listar todos los registros de pedido
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listar() throws Exception {
        PedidoDao dao;

        try {
            dao = new PedidoDao();
            lstPedido = dao.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para modificar un pedido
     *
     * @param Ped Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Pedido Ped) throws Exception {
        System.out.println("*******************************************************Modificar");
        PedidoDao dao;

        try {
            dao = new PedidoDao();
            dao.modificar(Ped);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para eliminar un pedido
     *
     * @param Ped Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Pedido Ped) throws Exception {
        System.out.println("*******************************************************eliminar");
        PedidoDao dao;

        try {
            dao = new PedidoDao();
            dao.eliminar(Ped);

        } catch (Exception e) {
            throw e;
        }

    }

}
