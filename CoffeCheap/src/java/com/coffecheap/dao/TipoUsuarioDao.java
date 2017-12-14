package com.coffecheap.dao;

import com.coffecheap.modelo.Tipo;
import com.coffecheap.modelo.TipoUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class TipoUsuarioDao extends Dao {

    /**
     * Metodo para registrar en tipo
     *
     * @param nombre
     * @param descripcion
     * @throws Exception
     */
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

    /**
     * metodo para registrar los permisosde usuario
     *
     * @param usuario
     * @param idpagina
     * @param idcrud
     * @throws Exception
     */
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

    /**
     * MEtodo para eliminar un tip de usuario
     *
     * @param tipo
     * @throws Exception
     */
    public void eliminar(Tipo tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from tipo where idtipo=?");
            st.setInt(1, tipo.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    /**
     * Metodo para modficar un tipo de usuario
     *
     * @param tipo
     * @throws Exception
     */
    public void modificar(Tipo tipo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update tipo set  nombretipo=?, descripcion=? where idtipo=?");
            st.setString(1, tipo.getNombre());
            st.setString(2, tipo.getDesc());
            st.setInt(3, tipo.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    /**
     * Metodo para obtener un registro en un objeto
     *
     * @param nombre
     * @return
     * @throws Exception
     */
    public int Buscar(String nombre) throws Exception {

        int respuesta = 0;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select idtipo from tipo where nombretipo='" + nombre + "';");
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

    /**
     * MEtodo para lista deplegable de tipo
     *
     * @return
     * @throws Exception
     */
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

    /**
     * Metodo para lista desplegable de crud
     *
     * @return
     * @throws Exception
     */
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

    /**
     * Metodo para lista desplegable de html
     *
     * @return
     * @throws Exception
     */
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

    /**
     * Metodo para listar tipo
     *
     * @return
     * @throws Exception
     */
    public List<Tipo> mostrar() throws Exception {
        List<Tipo> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select idtipo, nombretipo, descripcion from tipo");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt(1));
                tipo.setNombre(rs.getString(2));
                tipo.setDesc(rs.getString(3));
                lista.add(tipo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    /**
     * Metodo para leer antes de modificar
     *
     * @param tipo
     * @return
     * @throws Exception
     */
    public Tipo leerParaModificar(Tipo tipo) throws Exception {
        Tipo tip = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select idtipo, nombretipo, descripcion from tipo where idtipo=?");
            st.setInt(1, tipo.getId());
            rs = st.executeQuery();

            while (rs.next()) {
                tip = new Tipo();
                tip.setId(rs.getInt(1));
                tip.setNombre(rs.getString(2));
                tip.setDesc(rs.getString(3));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return tip;
    }

}
