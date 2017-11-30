package com.coffecheap.dao;

import com.coffecheap.modelo.Tipo;
import com.coffecheap.modelo.Turno;
import com.coffecheap.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends Dao {

    public void registrar(Usuario Tt) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into usuario values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, Tt.getId());
            st.setString(2, Tt.getUsuario());
            st.setString(3, Tt.getPass());
            st.setInt(4, Tt.getTipo().getId());
            st.setString(5, Tt.getNombre());
            st.setString(6, Tt.getApellido());
            st.setInt(7, Tt.getCodigo());
            st.setInt(8, Tt.getTurno().getId_turno());
            st.setInt(9, Tt.getTelefono());
            st.setString(10, Tt.getDireccion());
            st.setInt(11, Tt.getDpi());
            st.setString(12, Tt.getNit());
            st.setString(13, Tt.getCorreo());

            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public List<Usuario> listar() throws Exception {
        List<Usuario> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select iduser, user, pass, tipouser, nombre, apellido, codigo, idturno, telefono, direccion, dpi, nit, correo from usuario");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPass(rs.getString(3));
                usuario.getTipo().setId(rs.getInt(4));
                usuario.setNombre(rs.getString(5));
                usuario.setApellido(rs.getString(6));
                usuario.setCodigo(rs.getInt(7));
                usuario.getTurno().setId_turno(rs.getInt(8));
                usuario.setTelefono(rs.getInt(9));
                usuario.setDireccion(rs.getString(10));
                usuario.setDpi(rs.getInt(11));
                usuario.setNit(rs.getString(12));
                usuario.setCorreo(rs.getString(13));
                lista.add(usuario);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }
    
    
    public List<Turno> listarTurno() throws Exception {
        List<Turno> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select idturno, horario_turno from turno");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Turno turno = new Turno();
                turno.setId_turno(rs.getInt(1));
                turno.setHorario_turno(rs.getString(2));
                lista.add(turno);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    public List<Tipo> listarTipo() throws Exception {
        List<Tipo> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select idtipo, nombretipo from tipo");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt(1));
                tipo.setNombre(rs.getString(2));
                lista.add(tipo);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    
    public List<Usuario> listarPorParametro(Usuario usuarioS) throws Exception {
        List<Usuario> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select iduser, user, pass, tipouser, nombre, apellido, codigo, idturno, telefono, direccion, dpi, nit, correo from usuario where iduser=?");
            st.setInt(1, usuarioS.getId());
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPass(rs.getString(3));
                usuario.getTipo().setId(rs.getInt(4));
                usuario.setNombre(rs.getString(5));
                usuario.setApellido(rs.getString(6));
                usuario.setCodigo(rs.getInt(7));
                usuario.getTurno().setId_turno(rs.getInt(8));
                usuario.setTelefono(rs.getInt(9));
                usuario.setDireccion(rs.getString(10));
                usuario.setDpi(rs.getInt(11));
                usuario.setNit(rs.getString(12));
                usuario.setCorreo(rs.getString(13));
                lista.add(usuario);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    public void modificar(Usuario Tt) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE usuario SET  user=?, pass=?, tipouser=?, nombre=?, apellido=?, codigo=?, idturno=?, telefono=?, direccion=?, dpi=?, nit=?, correo=? WHERE iduser=?");
            st.setString(1, Tt.getUsuario());
            st.setString(2, Tt.getPass());
            st.setInt(3, Tt.getTipo().getId());
            st.setString(4, Tt.getNombre());
            st.setString(5, Tt.getApellido());
            st.setInt(6, Tt.getCodigo());
            st.setInt(7, Tt.getTurno().getId_turno());
            st.setInt(8, Tt.getTelefono());
            st.setString(9, Tt.getDireccion());
            st.setInt(10, Tt.getDpi());
            st.setString(11, Tt.getNit());
            st.setString(12, Tt.getCorreo());
            st.setInt(13, Tt.getId());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public Usuario leerParaModificar(Usuario usuarioS) throws Exception {

        Usuario usuario = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select iduser, user, pass, tipouser, nombre, apellido, codigo, idturno, telefono, direccion, dpi, nit, correo from usuario where iduser=?");
            st.setInt(1, usuarioS.getId());
            rs = st.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPass(rs.getString(3));
                usuario.getTipo().setId(rs.getInt(4));
                usuario.setNombre(rs.getString(5));
                usuario.setApellido(rs.getString(6));
                usuario.setCodigo(rs.getInt(7));
                usuario.getTurno().setId_turno(rs.getInt(8));
                usuario.setTelefono(rs.getInt(9));
                usuario.setDireccion(rs.getString(10));
                usuario.setDpi(rs.getInt(11));
                usuario.setNit(rs.getString(12));
                usuario.setCorreo(rs.getString(13));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return usuario;
    }

    public void eliminar(Usuario pac) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM usuario WHERE iduser=?");
            st.setInt(1, pac.getId());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

}
