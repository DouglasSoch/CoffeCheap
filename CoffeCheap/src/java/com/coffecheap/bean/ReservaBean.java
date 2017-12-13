package com.coffecheap.bean;

import com.coffecheap.dao.ClienteDao;
import com.coffecheap.dao.ReservaDao;
import com.coffecheap.modelo.Cliente;
import com.coffecheap.modelo.Mesa;
import com.coffecheap.modelo.Reserva;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bryan
 */


@ManagedBean
@ViewScoped
public class ReservaBean {

    /**
     * Metodo para mostrar mensajes emergentes desde una instancia creada de
     * ReservaBean
     *
     * @param summary
     */
    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    List<Reserva> lstReserva = new ArrayList();
    List<Mesa> lstMesa = new ArrayList();
    Reserva reserva = new Reserva();
    Cliente cliente = new Cliente();
    List<Cliente> lstCliente = new ArrayList();
    Cliente cli = new Cliente();

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

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

    String nombreBoton = "Buscar";

    public List<Mesa> getLstMesa() {
        return lstMesa;
    }

    public void setLstMesa(List<Mesa> lstMesa) {
        this.lstMesa = lstMesa;
    }

    public String getNombreBoton() {
        return nombreBoton;
    }

    public void setNombreBoton(String nombreBoton) {
        this.nombreBoton = nombreBoton;
    }

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

//    public void estadoDelBoton() throws Exception
//    {
//        ReservaDao dao = new ReservaDao();
//        boolean serONoSer;
//        //serONoSer=this.registrarCyR();
//        
//     if(serONoSer==false)
//     {
//         this.nombreBoton="Buscar";
//     }
//     else
//     {
//         ClienteDao daoC = new ClienteDao();
//         this.nombreBoton="Guardar";
//         daoC.registrarN(cliente);
//     }
//            
//    }
    /**
     * Metodo especial para registrar cliente si es necesario y reserva
     *
     * @throws Exception
     */
    public void registrarCyR() throws Exception {

        ReservaDao dao;
        String nit = cliente.getNit_cliente();
        boolean serONoSer;
        serONoSer = false;
        boolean estado = false;
        try {

//             String formateador = new SimpleDateFormat("yyyy-MM-dd").format(reserva.getFecha());
//                        reserva.setFechaSus(formateador);
            dao = new ReservaDao();
            estado = dao.registrarclienteYReserva(nit);

            if (estado == false) {
                ClienteBean clB = new ClienteBean();
                this.nombreBoton = "Buscar";
                this.cliRe(cliente);

            } else {
                this.nombreBoton = "Guardar";
                if (!cliente.getNombre().equals("")) {
                    if (!cliente.getDireccion().equals("")) {
                        try {
                            ClienteDao daoC = new ClienteDao();

                            daoC.registrarN(cliente);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }

        } catch (Exception e) {
            throw e;
        }

    }
    
    /**
     * Metodo para mostrar el cliente si este existe
     * @param clie
     * @throws Exception 
     */

    public void cliRe(Cliente clie) throws Exception {
        ReservaDao dao;
        Cliente temp;
        try {
            dao = new ReservaDao();
            temp = dao.leerFilaR(clie);

            if (cliente != null) {
                this.cli.setId_cliente(temp.getId_cliente());
                this.cli.setNit_cliente(temp.getNit_cliente());
                this.cliente = temp;
            }

        } catch (Exception e) {
            throw e;

        }
    }
/**
 * Metodo para listar reservas
 * @throws Exception 
 */
    public void listar() throws Exception {
        ReservaDao dao;

        try {
            dao = new ReservaDao();
            lstCliente = dao.listarNombre();
        } catch (Exception e) {
            throw e;
        }
    }
/**
 * Metodo para listar mesa en lista desplegable
 * @throws Exception 
 */
    public void listarMesa() throws Exception {
        ReservaDao dao;

        try {
            dao = new ReservaDao();
            lstMesa = dao.listarMesa();
        } catch (Exception e) {
            throw e;
        }
    }
/**
 * Metodo para registrar una reserva
 * @throws Exception 
 */
    public void registrar() throws Exception {
        ReservaDao dao;
        try {

            if (reserva.getFecha() == null) {
                addMessage("Ingrese fecha");
            } else {
                if (reserva.getHora_entrada().equals("")) {
                    addMessage("Ingrese Hora de entrada");
                } else {
                    if (reserva.getHora_salida().equals("")) {
                        addMessage("Ingrese Hora de salida");
                    } else {
                        if (reserva.getCantidad_personas() == 0) {
                            addMessage("Ingrese cantidad de personas");
                        } else {
                            if (reserva.getMesa().getId_mesa() == 0) {
                                addMessage("Eliga una mesa");
                            } else {

                                String formateador = new SimpleDateFormat("yyyy-MM-dd").format(reserva.getFecha());
                                reserva.setFechaSus(formateador);
                                this.reserva.getCliente().setId_cliente(cli.getId_cliente());
                                dao = new ReservaDao();
                                dao.registrar(reserva);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
/**
 * Metodo para verificar si hay disponiblidad
 * @throws Exception 
 */
    public void Dispo() throws Exception {
        ReservaDao dao;

        try {
            dao = new ReservaDao();
            lstReserva = dao.consultaDeDispo(reserva);
        } catch (Exception e) {
            throw e;
        }
    }
/**
 * Metodo para listar reserva
 */
    public void mostrar() {
        ReservaDao dao;

        try {
            dao = new ReservaDao();
            lstReserva = dao.mostrarr();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
/**
 * Metodo para listar reserva
 * @throws Exception 
 */
    public void mostar() throws Exception {
        ReservaDao dao;

        try {
            dao = new ReservaDao();
            lstReserva = dao.mostrar();
        } catch (Exception e) {
            throw e;
        }
    }
/**
 * Metodo para listar reserva por parametro
 * @throws Exception 
 */
    public void mostarPorParametro() throws Exception {
        ReservaDao dao;

        try {
            dao = new ReservaDao();
            lstReserva = dao.mostrarPorPrarametro(reserva);
        } catch (Exception e) {
            throw e;
        }
    }
/**
 * Metodo para obtner una fila en un objeto Reserva
 * @throws Exception 
 */
    public void buscar() throws Exception {
        ReservaDao dao;
        Reserva temp;

        try {
            dao = new ReservaDao();
            temp = dao.leerParaModificar(reserva);

            if (reserva != null) {
                this.reserva = temp;

            }

        } catch (Exception e) {
            throw e;
        }
    }
/**
 * Metodo para modificar un registro de Reserva
 * @throws Exception 
 */
    public void modificar() throws Exception {
        ReservaDao dao;

        try {
            dao = new ReservaDao();
            dao.modificar(reserva);
        } catch (Exception e) {
            throw e;
        }
    }
/**
 * Metodo para eliminar una Reserva
 * @throws Exception 
 */
    public void eliminar() throws Exception {
        ReservaDao dao;

        try {
            dao = new ReservaDao();
            dao.eliminar(reserva);
        } catch (Exception e) {
            throw e;
        }
    }

}
