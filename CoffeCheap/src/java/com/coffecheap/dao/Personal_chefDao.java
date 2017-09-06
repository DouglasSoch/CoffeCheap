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
            PreparedStatement st = this.getCon().prepareCall("select chef.idpersonal, chef.nombre_personal, chef.telefono_personal, turnochef.horario_turno\n" +
            "from personal_chef as chef inner join turno as turnochef\n" +
            "on(chef.idpersonal = turnochef.idturno);");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Personal_chef personal = new Personal_chef();
                personal.setId_personal(rs.getInt("chef.idpersonal"));
                personal.setNombre(rs.getString("chef.nombre_personal"));
                personal.setTelefono(rs.getInt("chef.telefono_personal"));
                personal.getTurno().setHorario_turno(rs.getString("turnochef.horario_turno"));
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
