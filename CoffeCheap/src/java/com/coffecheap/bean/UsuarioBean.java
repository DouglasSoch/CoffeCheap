package com.coffecheap.bean;

import com.coffecheap.modelo.Usuario;
import com.coffecheap.dao.UsuarioDao;
import com.coffecheap.modelo.Tipo;
import com.coffecheap.modelo.Turno;
import java.util.ArrayList;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class UsuarioBean {

    /**
     * Metodo para mostrar mensajes desde on objeto creado de este molde
     *
     * @param summary String
     */
    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private Usuario usuario = new Usuario();
    private List<Usuario> lstUsuario = new ArrayList();
    private List<Tipo> lstTipo = new ArrayList();
    private List<Turno> lstTurno = new ArrayList();
    List<Usuario> lstUsuarioMe = new ArrayList();
    private List<Usuario> lstUsuarioChef;

    public List<Usuario> getLstUsuarioChef() {
        return lstUsuarioChef;
    }

    public void setLstUsuarioChef(List<Usuario> lstUsuarioChef) {
        this.lstUsuarioChef = lstUsuarioChef;
    }

    public List<Usuario> getLstUsuarioMe() {
        return lstUsuarioMe;
    }

    public void setLstUsuarioMe(List<Usuario> lstUsuarioMe) {
        this.lstUsuarioMe = lstUsuarioMe;
    }

    /**
     * Metodo para listar todos los registros de usuario
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listarMe() throws Exception {
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();
            lstUsuarioMe = dao.listarMe();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para listar todos los chef
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listarChef() throws Exception {
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();
            lstUsuarioChef = dao.listarChef();
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Tipo> getLstTipo() {
        return lstTipo;
    }

    public void setLstTipo(List<Tipo> lstTipo) {
        this.lstTipo = lstTipo;
    }

    public List<Turno> getLstTurno() {
        return lstTurno;
    }

    public void setLstTurno(List<Turno> lstTurno) {
        this.lstTurno = lstTurno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(List<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    /**
     * MEtodo para registrar un usuario
     */
    public void registrar() {
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();
            dao.registrar(usuario);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para mostrar por paramatro
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void mostarPorParametro() throws Exception {
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();
            lstUsuario = dao.listarPorParametro(usuario);
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para listar todos los registros de usuario
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listar() throws Exception {
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();
            lstUsuario = dao.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para listar todos los registros de tipo de usuario
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listarTipo() throws Exception {
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();
            lstTipo = dao.listarTipo();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para listar todos los registros de turno
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listarTurno() throws Exception {
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();
            lstTurno = dao.listarTurno();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para obtener el registro de una tabla
     *
     * @param usu Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void buscarr(Usuario usu) throws Exception {

        UsuarioDao dao;
        Usuario temp;

        try {
            dao = new UsuarioDao();
            temp = dao.leerParaModificar(usu);

            if (usuario != null) {
                this.usuario = temp;
            } else {
                this.usuario = temp;
            }

        } catch (Exception e) {
            throw e;

        }
    }

    /**
     * Metodo para modificar un registro de usuario
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar() throws Exception {
        UsuarioDao dao;

        try {

            dao = new UsuarioDao();
            dao.modificar(usuario);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para eliminar un registro de usuario
     *
     * @param usu Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Usuario usu) throws Exception {
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();
            dao.eliminar(usu);

        } catch (Exception e) {
            throw e;
        }

    }

}
