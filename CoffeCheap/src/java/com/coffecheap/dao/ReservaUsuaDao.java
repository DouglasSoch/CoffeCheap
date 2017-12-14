package com.coffecheap.dao;

import com.coffecheap.modelo.Mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ReservaUsuaDao extends Dao {

    /**
     * Metodo para listar todos los registros de la reserva
     *
     * @return List
     */
    public List<Mesa> mesas() {
        ResultSet rs;
        List<Mesa> lstMesa = null;

        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("select id_mesa from mesa order by id_mesa");
            rs = ps.executeQuery();
            lstMesa = new ArrayList();

            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setId_mesa(rs.getInt(1));
                lstMesa.add(mesa);
            }
        } catch (Exception e) {

        }
        return lstMesa;

    }

    /**
     * metodo para verificar el estado
     *
     * @param mesa para la sentencia SQL
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
    public String ControlEstado(int mesa) throws Exception {
        String color = "rgb(115, 191, 209)";

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

    /**
     * MEtodo para verificar el tamaño de la mesa
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
     * Control para el cambio de estado de la reserva
     *
     * @param mesa para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void CamBioEstado(int mesa) throws Exception {

        System.out.println("*******************************************************modificar dao");
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
     * *
     * Metodo para ver los ccomensales de la reserva
     *
     * @param numer para la sentencia SQL
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int comensales(int numer) throws Exception {
        int numero = 0;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select cantidad_comensales from mesa where id_mesa=?");
            st.setInt(1, numer);
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

}
