/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.Control_mesaBean;
import com.coffecheap.modelo.Control_mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class Control_mesaDao extends Dao {

    /**
     * Metodo para registrar en control mesa
     *
     * @param Tt para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void registrar(Control_mesa Tt) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into control_mesa values(?,?);");

            //st.setInt(1, Tt.getId_tipo());
            //st.setString(2, Tt.getNombre());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para listar todos losn registros de control mesa
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Control_mesa> listarMesaOcupadas() throws Exception {
        List<Control_mesa> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT *FROM control_mesa");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Control_mesa tt = new Control_mesa();

                //  tt.setId_tipo(rs.getInt(1));
                //  tt.setNombre(rs.getString(2));
                lista.add(tt);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    /**
     * metodo para recibir el tamaño de registros en mesa
     *
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int tamaño() throws Exception {
        int numero = 0;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select count(*)from mesa");
            ResultSet n = st.executeQuery();

            if (n.next()) {
                numero = n.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return numero;
    }

    /**
     * Metodo para eliminar un registro de control mesa
     *
     * @param pac para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Control_mesa pac) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM control_mesa WHERE id_control_mesa=?;");
            //st.setInt(1, pac.getId_tipo());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para cambiar de estado el control mesa
     *
     * @param mesa para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void CamBioEstado(int mesa) throws Exception {
        try {
            this.Conectar();

            PreparedStatement s2 = this.getCon().prepareStatement("select id_estado from mesa WHERE id_mesa=?;");
            s2.setInt(1, mesa);
            ResultSet n = s2.executeQuery();

            if (n.next()) {
                if (n.getInt(1) == 1) {
                    PreparedStatement st = this.getCon().prepareStatement("UPDATE  mesa SET id_estado=? WHERE id_mesa=?;");
                    st.setInt(1, 3);
                    st.setInt(2, mesa);
                    st.executeUpdate();
                }
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para cambiar de color
     *
     * @param mesa para la sentencia SQL
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
    public String ControlEstado(int mesa) throws Exception {
        String color = "btn-default";
        controlreserva(mesa);
        try {
            this.Conectar();

            PreparedStatement s2 = this.getCon().prepareStatement("select id_estado from mesa WHERE id_mesa=?;");
            s2.setInt(1, mesa);
            ResultSet n = s2.executeQuery();

            if (n.next()) {
                if (n.getInt(1) == 1) { //Libre               Verde
                    color = "btn-success";
                }
                if (n.getInt(1) == 3) { //Ocupada             Amarillo       
                    color = "btn-warning";
                }
                if (n.getInt(1) == 4) {//Unida con otra mesa  Blanco
                    color = "btn-default";
                }
                if (n.getInt(1) == 2) {//reserva              Celeste
                    color = "btn-info";
                }

            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return color;

    }

    /**
     * Metodo para registrar el pago
     *
     * @param mesa para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void RegistrarPago(int mesa) throws Exception {

        try {
            this.Conectar();
            int idPedido = 0;
            PreparedStatement s2 = this.getCon().prepareStatement("select id_pedido from control where id_mesa=?;");
            s2.setInt(1, mesa);
            ResultSet n = s2.executeQuery();

            if (n.next()) {
                idPedido = n.getInt(1);

                System.out.println("El pedido = " + idPedido);
            }

            PreparedStatement esme = this.getCon().prepareStatement("select  id_estado from mesa WHERE id_mesa=?;");
            esme.setInt(1, mesa);
            ResultSet n_est = esme.executeQuery();

            if (n_est.next()) {

                idPedido = n_est.getInt(1);
                PreparedStatement s3 = this.getCon().prepareStatement("select *from venta_factura where id_pedido=?;");
                s3.setInt(1, idPedido);
                ResultSet n2 = s3.executeQuery();

                if (idPedido > 1 && n2.next()) {
                    PreparedStatement st = this.getCon().prepareStatement("UPDATE pedido SET cancelado=1 WHERE id_pedido =?;");
                    st.setInt(1, idPedido);
                    st.executeUpdate();
                    Control_mesaBean.addMessage("Pago Realizado");

                } else {
                    Control_mesaBean.addMessage("Pago No Realizado \n (Factura No Generada)");
                }
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para habilitar el pago para los meseros
     *
     * @param mesa para la sentencia SQL
     * @return boolean
     * @throws Exception por si resulta un error de SQL
     */
    public boolean HabilitarPago(int mesa) throws Exception {
        int pago;
        boolean estado = false;
        try {
            this.Conectar();

            PreparedStatement s2 = this.getCon().prepareStatement("select cancelado from control"
                    + " where id_pedido in"
                    + " (select max(id_pedido) from control group by id_mesa) and id_mesa=?;");
            s2.setInt(1, mesa);
            ResultSet n = s2.executeQuery();

            if (n.next()) {
                pago = n.getInt(1);
                System.out.println("DAO: PAGO: " + pago);
                if (pago == 1) {
                    estado = true;
                } else {
                    estado = false;
                }
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }
        System.out.println("DAO ESTADO: " + estado);
        return estado;
    }

    /**
     * Metodo para indicar que esta pagado
     *
     * @param mesa para la sentencia SQL
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
    public String EstaPago(int mesa) throws Exception {
        int pago;
        String estado = null;
        try {
            this.Conectar();

            PreparedStatement s2 = this.getCon().prepareStatement("select cancelado from control"
                    + " where id_pedido in"
                    + " (select max(id_pedido) from control group by id_mesa) and id_mesa=?;");
            s2.setInt(1, mesa);
            ResultSet n = s2.executeQuery();

            if (n.next()) {
                pago = n.getInt(1);
                System.out.println("DAO: PAGO: " + pago);
                if (pago == 1) {
                    estado = "Cancelado";
                } else {
                    estado = "__Pago__";
                }
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }
        System.out.println("DAO ESTADO: " + estado);
        return estado;
    }

    /**
     * Metodo para limpiar mesa para que el recepcionista este avisado
     *
     * @param mesa para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void LimpiarMesa(int mesa) throws Exception {
        try {
            this.Conectar();

            PreparedStatement esme = this.getCon().prepareStatement("select  id_estado from mesa WHERE id_mesa=?;");
            esme.setInt(1, mesa);
            ResultSet n_est = esme.executeQuery();

            PreparedStatement s2 = this.getCon().prepareStatement("select cancelado from control"
                    + " where id_pedido in"
                    + " (select max(id_pedido) from control group by id_mesa) and id_mesa=?;");
            s2.setInt(1, mesa);
            ResultSet n = s2.executeQuery();

            int pago = 0;
            int estado = 0;

            if (n.next()) {
                pago = n.getInt(1);
            }

            if (n_est.next()) {
                estado = n_est.getInt(1);
                if ((estado > 1 & pago == 1) | estado == 4) {
                    PreparedStatement st = this.getCon().prepareStatement("UPDATE  mesa SET id_estado=? WHERE id_mesa=?;");
                    st.setInt(1, 1);
                    st.setInt(2, mesa);
                    st.executeUpdate();

                    PreparedStatement st2 = this.getCon().prepareStatement("INSERT INTO pedido "
                            + "(id_mesa, hora, id_personal, cancelado, fecha)"
                            + " VALUES (?, ?, ?, ?, ?);");

                    java.util.Date utilDate = new java.util.Date(); //fecha actual
                    long lnMilisegundos = utilDate.getTime();
                    java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
                    System.out.println("sql.Time: " + sqlTime);

                    st2.setInt(1, mesa);
                    st2.setTime(2, sqlTime);
                    st2.setInt(3, 3);
                    st2.setInt(4, 0);
                    java.util.Date dates = new java.util.Date();
                    long fechaSis = dates.getTime();
                    java.sql.Timestamp d = new java.sql.Timestamp(fechaSis);

                    st2.setTimestamp(5, d);
                    st2.executeUpdate();
                    Control_mesaBean.addMessage("Se vacio correctamente");
                } else {
                    Control_mesaBean.addMessage("Pago obligatoria antes de vaciar");
                }

            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

    }

    /**
     * Metodo para control de la reserva
     *
     * @param mesa para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void controlreserva(int mesa) throws Exception {

        try {

            java.util.Date utilDate = new java.util.Date(); //fecha actual
            long lnMilisegundos = utilDate.getTime();
            java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
            java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
            System.out.println("sql.Date: " + sqlDate);
            System.out.println("sql.Time: " + sqlTime);

            this.Conectar();
            PreparedStatement s2 = this.getCon().prepareStatement("select fecha, hora_inicio, hora_final, id_mesa from reserva WHERE hora_inicio BETWEEN ? AND ? AND id_mesa=? AND fecha=?;");
            s2.setTime(1, getAddSubtractTime(sqlTime, -30));
            s2.setTime(2, getAddSubtractTime(sqlTime, 30));
            s2.setInt(3, mesa);
            s2.setDate(4, sqlDate);
            ResultSet n = s2.executeQuery();

            System.out.println("hora restada" + getAddSubtractTime(sqlTime, 30));
            System.out.println("la mesa entrada =" + mesa);

            if (n.next()) {
                PreparedStatement st = this.getCon().prepareStatement("UPDATE  mesa SET id_estado=? WHERE id_mesa=?;");
                st.setInt(1, 2);
                st.setInt(2, mesa);
                st.executeUpdate();
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

    }

    /**
     * MEtodo para el manejo de fecha con la libreria java.sql
     *
     * @param time para la sentencia SQL
     * @param minutes para la sentencia SQL
     * @return por si resulta un error de SQL
     */
    public java.sql.Time getAddSubtractTime(java.sql.Time time, int minutes) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(time.getTime());
        cal.add(cal.MINUTE, minutes);
        return new Time(cal.getTimeInMillis());
    }

    /**
     * Metodo para listar el control de las mesas
     *
     * @param mesa
     * @throws Exception
     */
    public void ListaPedido(int mesa) throws Exception {

        try {
            this.Conectar();
            int idPedido = 0;
            PreparedStatement s2 = this.getCon().prepareStatement("select id_pedido from control where id_mesa=?;");
            s2.setInt(1, mesa);
            ResultSet n = s2.executeQuery();

            if (n.next()) {
                idPedido = n.getInt(1);

                System.out.println("El pedido = " + idPedido);
            }

            PreparedStatement esme = this.getCon().prepareStatement("select *from plato_pedido where id_pedido=?;");
            esme.setInt(1, idPedido);
            ResultSet n_est = esme.executeQuery();

            if (n_est.next()) {

            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para asignar todo a una mesa
     *
     * @param mesas para la sentencia SQL
     * @param MesaPrincipal para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void asigTodo1mesa(String[] mesas, int MesaPrincipal) throws Exception {

        try {

            this.Conectar();
            int idPedido;
            PreparedStatement s2 = this.getCon().prepareStatement("select id_pedido from control where id_mesa=?;");
            s2.setInt(1, MesaPrincipal);
            ResultSet n = s2.executeQuery();

            if (n.next()) {
                idPedido = n.getInt(1);
                System.out.println("El pedido = " + idPedido);

                PreparedStatement p2 = this.getCon().prepareStatement("select *from plato_pedido where id_pedido=?;");
                p2.setInt(1, idPedido);
                ResultSet L = p2.executeQuery();

                int idPlatoPedido;
                while (L.next()) {

                    idPlatoPedido = L.getInt(1);
                    System.out.println("el id plato pedido = " + idPlatoPedido);

                    this.Conectar();
                    PreparedStatement st = this.getCon().prepareStatement("UPDATE plato_pedido SET id_pedido=? WHERE id_plato_pedido=?;");

                    st.setInt(1, idPedido);
                    st.setInt(2, idPlatoPedido);
                    st.executeUpdate();

                }

            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para unir mesa
     *
     * @param mesa para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void AsignarMesaUnida(int mesa) throws Exception {
        try {

            this.Conectar();

            PreparedStatement st = this.getCon().prepareStatement("UPDATE  mesa SET id_estado=? WHERE id_mesa=?;");
            st.setInt(1, 4);
            st.setInt(2, mesa);
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

    }

}
