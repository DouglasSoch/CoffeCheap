package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */
import com.coffecheap.modelo.Control_mesa;
import com.coffecheap.modelo.EstadoPago;
import com.coffecheap.dao.Control_mesaDao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Control_mesaBean {

    /**
     *
     * @param summary String
     */
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

    /**
     * Metodo para ingresar
     */
    public void registrar() {

        Control_mesaDao dao;

        try {
            dao = new Control_mesaDao();
            dao.registrar(control_mesa);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para listar registros
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listar() throws Exception {
        Control_mesaDao dao;

        try {
            dao = new Control_mesaDao();
            lstControl_mesa = dao.listarMesaOcupadas();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para tamaño de mesa
     *
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Control_mesa mar) throws Exception {
        Control_mesaDao dao;

        try {
            dao = new Control_mesaDao();
            dao.eliminar(mar);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     *
     * @param MesaSelecionada Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void CambioEstado(int MesaSelecionada) throws Exception {
        Control_mesaDao dao;

        try {
            dao = new Control_mesaDao();
            dao.CamBioEstado(MesaSelecionada);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param mesa Objeto de la clase
     * @return boolean
     * @throws Exception por si resulta un error de SQL
     */
    public boolean HabilitarPago(int mesa) throws Exception {
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

    /**
     *
     * @param mesa Objeto de la clase
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     *
     * @param mesa Objeto de la clase
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     *
     * @param Mesa Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     *
     * @param Mesa Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     *
     * @param Mesa Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void AsignarMesaUnida(int Mesa) throws Exception {
        System.out.println("********************************Asignar Mesa Unida");
        Control_mesaDao dao;

        try {
            dao = new Control_mesaDao();
            dao.AsignarMesaUnida(Mesa);

        } catch (Exception e) {
            throw e;
        }
    }

    private String[] selectedMesa;
    private List<String> cities;

    public void init() {
        cities = new ArrayList<String>();
        String m = null;
        try {
            for (int i = 0; i <= tamano(); i++) {
                m = Integer.toString(i);
                System.out.println("" + i);
                cities.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(Control_mesaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String[] getSelectedMesa() {

        return selectedMesa;

//    hacer los cambios de mesa aqui
    }

    /**
     * Metodo para unir mesa
     *
     * @param selec Objeto de la clase
     * @param mesa Objeto de la clase
     */
    public void unirMesa(String[] selec, int mesa) {
        Control_mesaDao dao;
        try {
            dao = new Control_mesaDao();
            dao.asigTodo1mesa(selec, mesa);

        } catch (Exception ex) {
            Logger.getLogger(Control_mesaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setSelectedMesa(String[] selectedMesa) {
        this.selectedMesa = selectedMesa;
    }

    public List<String> getCities() {
        return cities;
    }

    /**
     *
     * @param Mesa Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void controlreserva(int Mesa) throws Exception {
        System.out.println("********************************controlreserva");
        Control_mesaDao dao;

        try {
            dao = new Control_mesaDao();
            dao.controlreserva(Mesa);

        } catch (Exception e) {
            throw e;
        }
    }

}
