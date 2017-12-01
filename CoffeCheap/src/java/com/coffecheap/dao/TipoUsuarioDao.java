package com.coffecheap.dao;

import com.coffecheap.modelo.TipoUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioDao extends Dao {

    public void Ingresar(String nombre, String descripcion) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into tipo values(0,?,?)");
            st.setString(1, nombre);
            st.setString(2, descripcion);
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    public void Permiso(int usuario, int idpagina, int idcrud) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into permiso values(?,?,?);");
            st.setInt(1, usuario);
            st.setInt(2, idpagina);
            st.setInt(3, idcrud);
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }

    }

    public void Eliminar() {

    }

    public void Modificar() {

    }

    public int Buscar(String nombre) throws Exception {

        int respuesta = 0;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select idtipo from tipo where nombretipo='" + nombre+"';");
            rs = st.executeQuery();
            while (rs.next()) {
                respuesta = rs.getInt("idtipo");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return respuesta;
    }

    public String Comparar(String nombre) throws Exception {
        String respuesta = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select nombretipo from tipo where nombretipo='" + nombre + "';");
            rs = st.executeQuery();
            
            while (rs.next()) {
                respuesta = rs.getString("nombretipo");
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }

        return respuesta;
    }

    public List<TipoUsuario> Tipo() throws Exception {

        List<TipoUsuario> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from tipo");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                TipoUsuario tipo = new TipoUsuario();
                tipo.setId_crud(rs.getInt("idcrud"));
                tipo.setNombrecrud(rs.getString("nombrecrud"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    public List<TipoUsuario> Crud() throws Exception {

        List<TipoUsuario> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from crud");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                TipoUsuario tipo = new TipoUsuario();
                tipo.setId_crud(rs.getInt("idcrud"));
                tipo.setNombrecrud(rs.getString("nombrecrud"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    public List<TipoUsuario> Html() throws Exception {
        List<TipoUsuario> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from html");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                TipoUsuario tipo = new TipoUsuario();
                tipo.setId_html(rs.getInt("idhtml"));
                tipo.setNombrepagina(rs.getString("nombrepagina"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }
}
