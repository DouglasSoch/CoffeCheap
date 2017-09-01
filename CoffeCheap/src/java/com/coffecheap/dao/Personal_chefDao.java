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
            PreparedStatement st = this.getCon().prepareStatement("update from personal_chef set(?,?,? where idpersonal=?)");
            st.setString(1, personal.getNombre());
            st.setInt(2, personal.getTelefono());
            st.setInt(3, personal.getTurno().getId_turno());
            st.setInt(4, personal.getId_personal());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    public List<Personal_chef> Mostrar() throws Exception {

        List<Personal_chef> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from personal_chef");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Personal_chef personal = new Personal_chef();
                personal.setId_personal(rs.getInt("idpersonal"));
                personal.setNombre(rs.getString("nombre_personal"));
                personal.setTelefono(rs.getInt("telefono_personal"));
                personal.getTurno().setId_turno(rs.getInt("id_turno"));
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
