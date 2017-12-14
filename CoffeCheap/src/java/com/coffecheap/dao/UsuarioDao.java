package com.coffecheap.dao;

import com.coffecheap.bean.UsuarioBean;
import com.coffecheap.modelo.Tipo;
import com.coffecheap.modelo.Turno;
import com.coffecheap.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class UsuarioDao extends Dao {

    /**
     * Metodo para registrar un usuario
     *
     * @param Tt recibe por parametro los valores de la tabla
     * @throws Exception podria tener excepciones si hay algun valor vacio
     */
    public void registrar(Usuario Tt) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into usuario(user,pass,tipouser,nombre,apellido,codigo,idturno,telefono,direccion,dpi,nit,correo) values(?,?,?,?,?,?,?,?,?,?,?,?)");
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
            st.executeUpdate();
            UsuarioBean.addMessage("Accion compleata");

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo que lista todos los registros de usuario
     *
     * @return retorna una lista tipo Usuario
     * @throws Exception por si resulta un error de SQL
     */
    public List<Usuario> listar() throws Exception {
        List<Usuario> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select usuario.iduser, usuario.user, usuario.pass, tipo.idtipo, tipo.nombretipo, usuario.nombre, usuario.apellido, usuario.codigo, turno.idturno, turno.horario_turno, usuario.telefono, usuario.direccion, usuario.dpi, usuario.nit, usuario.correo from usuario inner join tipo on(usuario.tipouser = tipo.idtipo) inner join turno on(usuario.idturno = turno.idturno)");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPass(rs.getString(3));
                usuario.getTipo().setId(rs.getInt(4));
                usuario.getTipo().setNombre(rs.getString(5));
                usuario.setNombre(rs.getString(6));
                usuario.setApellido(rs.getString(7));
                usuario.setCodigo(rs.getInt(8));
                usuario.getTurno().setId_turno(rs.getInt(9));
                usuario.getTurno().setHorario_turno(rs.getString(10));
                usuario.setTelefono(rs.getInt(11));
                usuario.setDireccion(rs.getString(12));
                usuario.setDpi(rs.getInt(13));
                usuario.setNit(rs.getString(14));
                usuario.setCorreo(rs.getString(15));
                lista.add(usuario);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    /**
     * Metodo que lista todos los registros de Turno y es para una lista
     * desplegable en el frontEnd
     *
     * @return retorna una lista tipo Turno
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo que lista todos los registro de Tipo y es para una lista
     * desplegable en el frontEnd
     *
     * @return retorna una lista de tipo Tipo
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo que lista los registros de usuario por condicion
     *
     * @param usuarioS para la sentencia SQL
     * @return retorna una lista Usuario
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo que modifica un registro de usuario y recibe los valores por medio
     * de parametro
     *
     * @param Tt objeto Usuario para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
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
            UsuarioBean.addMessage("Accion compleata");
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para listar los registros con condicion de usuario
     *
     * @param usuarioS para la sentencia SQL
     * @return objeto
     * @throws Exception por si resulta un error de SQL
     */
    public Usuario leerParaModificar(Usuario usuarioS) throws Exception {
        Usuario usuario = null;
        ResultSet rs;
        boolean ver;
        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select iduser, user, pass, tipouser, nombre, apellido, codigo, idturno, telefono, direccion, dpi, nit, correo from usuario where iduser=?");
            st.setInt(1, usuarioS.getId());
            rs = st.executeQuery();

            ver = rs.next();

            System.out.println(ver);

            if (ver == true) {
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
                rs.close();
            } else {
                UsuarioBean.addMessage("no existe");
                rs.close();
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return usuario;
    }

    /**
     * Metodo para eliminar un registro de usuario
     *
     * @param pac para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Usuario pac) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM usuario WHERE iduser=?");
            st.setInt(1, pac.getId());
            st.executeUpdate();
            UsuarioBean.addMessage("Accion compleata");
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para listar usuario para lista desplegable en el FrontEnd
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Usuario> listarMe() throws Exception {
        List<Usuario> lista;
        ResultSet rs;
        int numero = 3;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select iduser, user from usuario where tipouser=?");
            st.setInt(1, numero);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Usuario tt = new Usuario();
                tt.setId(rs.getInt(1));
                tt.setUsuario(rs.getString(2));
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
     * Metodo para listar chef
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Usuario> listarChef() throws Exception {
        List<Usuario> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT *FROM usuario WHERE tipouser=4");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Usuario tt = new Usuario();

                tt.setId(rs.getInt(1));
                tt.setNit(rs.getString(2));
                tt.setPass(rs.getString(3));
                tt.getTipo().setId(rs.getInt(4));
                tt.setNombre(rs.getString(5));
                tt.setApellido(rs.getString(6));
                tt.setCodigo(rs.getInt(7));
                tt.getTurno().setId_turno(rs.getInt(8));

                lista.add(tt);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

}
