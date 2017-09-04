package com.coffecheap.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.coffecheap.modelo.Personal_chef;

public class Personal_chefDao extends Dao {

    public void Ingresar(Personal_chef personal) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into personal_chef values (?,?,?,?)");
            st.setInt(1, personal.getId_personal());
            st.setString(2, personal.getNombre());
            st.setInt(3, personal.getTelefono());
            st.setInt(4, personal.getTurno().getId_turno());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            personal.setId_personal(0);
            personal.setNombre(null);
            personal.setTelefono(0);
            personal.getTurno().setId_turno(0);
        }
    }

    public void Borrar(Personal_chef personal) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from personal_chef where idpersonal=?");
            st.setInt(1, personal.getId_personal());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            personal.setId_personal(0);
        }
    }

    public void Modificar(Personal_chef personal) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update personal_chef set nombre_personal=?, telefono_personal=?, id_turno=? where idpersonal=?");
            st.setString(1, personal.getNombre());
            st.setInt(2, personal.getTelefono());
            st.setInt(3, personal.getTurno().getId_turno());
            st.setInt(4, personal.getId_personal());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            personal.setId_personal(0);
            personal.setNombre(null);
            personal.setTelefono(0);
            personal.getTurno().setId_turno(0);
        }
    }

    public List<Personal_chef> listar() throws Exception {

        List<Personal_chef> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT * FROM personal_chef");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Personal_chef personal = new Personal_chef();
                personal.setId_personal(rs.getInt(1));
                personal.setNombre(rs.getString(2));
                personal.setTelefono(rs.getInt(3));
                personal.getTurno().setId_turno(rs.getInt(4));
                lista.add(personal);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }

        return lista;
    }

}
