/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.MesaBean;
import com.coffecheap.modelo.Control_mesa;
import com.coffecheap.modelo.EstadoPago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Control_mesaDao extends Dao {

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

    public void eliminar(Control_mesa pac) throws Exception {
        System.out.println("*******************************************************eliminar dao");
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

    public void CamBioEstado(int mesa) throws Exception {

        System.out.println("*******************************************************modificar dao");
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE  mesa SET id_estado=? WHERE id_mesa=?;");
            st.setInt(1, 3);
            st.setInt(2, mesa);
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public String ControlEstado(int mesa) throws Exception {
        String color = "rgb(115, 191, 209)";
        System.out.println("*******************************************************modificar dao");
        try {
            this.Conectar();
            PreparedStatement s2 = this.getCon().prepareStatement("select id_estado from mesa WHERE id_mesa=?;");
            s2.setInt(1, mesa);
            ResultSet n = s2.executeQuery();

            if (n.next()) {
                if (n.getInt(1) == 1) {
                    color = "rgb(115, 191, 209)";
                } else {
                    color = "rgb(150, 60, 60)";
                }

            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return color;

    }

    public void RegistrarPago(int mesa) throws Exception {

        System.out.println("*******************************************************modificar dao");
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
            s2.setInt(1, mesa);
            ResultSet n_est = esme.executeQuery();

            if (n_est.next()) {
                System.out.println("if fuera");
                if (n_est.getInt(1)>1) {
                    PreparedStatement st = this.getCon().prepareStatement("UPDATE pedido SET cancelado=1 WHERE id_pedido =" + idPedido + ";");
                    st.executeUpdate();
                    System.out.println("if dentro");
                }
            } else {
                System.out.println("no entro bien");
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

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
                    estado = "Pagado";
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

//    public EstadoPago FuncionEstadoPago(int mesa) throws Exception {
//        
//        EstadoPago EP=new EstadoPago();
//    
//       
//        ResultSet rs;        
//        int pago;
//        boolean estado = false;
//
//        try {
//
//            this.Conectar();
//
//            PreparedStatement s2 = this.getCon().prepareStatement("select * from control \n"
//                    + "where id_pedido in \n"
//                    + "(select max(id_pedido) from control group by id_mesa) and id_mesa=?;");
//            s2.setInt(1, mesa);
//            ResultSet n = s2.executeQuery();
//            if (n.next()) {
//                pago = n.getInt(1);
//
//                if (pago == 1) {
//                    EP.setDesHabilitarBoton(true);
//                    EP.setEstado("Pagado");
//                } else {
//                    EP.setDesHabilitarBoton(false);
//                    EP.setEstado("No Pagado");
//                }
//            }
//
//          
//        
//        } catch (Exception ex) {
//            throw ex;
//        } finally {
//            this.Desconecar();
//        }
//
//        return EP;
//
//}
}
