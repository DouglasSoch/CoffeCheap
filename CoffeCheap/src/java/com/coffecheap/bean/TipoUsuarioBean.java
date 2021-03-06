package com.coffecheap.bean;

import com.coffecheap.dao.TipoUsuarioDao;
import com.coffecheap.modelo.Tipo;
import com.coffecheap.modelo.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bryan
 */
@ManagedBean
@ViewScoped
public class TipoUsuarioBean {

    TipoUsuario tipo = new TipoUsuario();
    List<TipoUsuario> listacrud;
    List<TipoUsuario> listanombre;
    ArrayList<TipoUsuario> datosbase = new ArrayList<TipoUsuario>();
    ArrayList<TipoUsuario> intermedio = new ArrayList<TipoUsuario>();
    ArrayList<TipoUsuario> listadescripcion = new ArrayList<TipoUsuario>();
    List<Tipo> lstUsu = new ArrayList();
    Tipo tip = new Tipo();
    int i;
    int acum;

    private String message;

    public List<Tipo> getLstUsu() {
        return lstUsu;
    }

    public void setLstUsu(List<Tipo> lstUsu) {
        this.lstUsu = lstUsu;
    }

    public Tipo getTip() {
        return tip;
    }

    public void setTip(Tipo tip) {
        this.tip = tip;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<TipoUsuario> getListadescripcion() {
        return listadescripcion;
    }

    public void setListadescripcion(ArrayList<TipoUsuario> listadescripcion) {
        this.listadescripcion = listadescripcion;
    }

    public ArrayList<TipoUsuario> getIntermedio() {
        return intermedio;
    }

    public void setIntermedio(ArrayList<TipoUsuario> intermedio) {
        this.intermedio = intermedio;
    }

    public List<TipoUsuario> getListanombre() {
        return listanombre;
    }

    public void setListanombre(List<TipoUsuario> listanombre) {
        this.listanombre = listanombre;
    }

    public List<TipoUsuario> getListacrud() {
        return listacrud;
    }

    public void setListacrud(List<TipoUsuario> listacrud) {
        this.listacrud = listacrud;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo para ingresar un tipo de usuario
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Ingresar() throws Exception {

        TipoUsuarioDao dao;
        try {

            dao = new TipoUsuarioDao();
            dao.Ingresar(listadescripcion.get(0).getNombretipo(), listadescripcion.get(0).getDescripcion());
            int numero = dao.Buscar(listadescripcion.get(0).getNombretipo());

            for (int j = 0; j < intermedio.size(); j++) {
                dao.Permiso(numero, intermedio.get(j).getId_html(), intermedio.get(j).getId_crud());
            }
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Mensaje:", "Guardado Correctamente"));
            intermedio.clear();
            listadescripcion.clear();
            tipo.setId_crud(0);
            tipo.setId_html(0);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para listar las paginas del proyecto
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Crud() throws Exception {

        TipoUsuarioDao dao;
        try {
            dao = new TipoUsuarioDao();
            listacrud = dao.Crud();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para listar los nombres de las paginas
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Nombre() throws Exception {

        TipoUsuarioDao dao;
        try {
            dao = new TipoUsuarioDao();
            listanombre = dao.Html();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo especial para verificacion de permisos de los tipo de usuarios
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Intermedio() throws Exception {
        TipoUsuarioDao dao;

        try {
            dao = new TipoUsuarioDao();

            String nombre = dao.Comparar(tipo.getNombretipo());

            if (nombre == null) {

                if (intermedio.size() > 0) {

                    if (tipo.getId_crud() == 0) {
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(null, new FacesMessage("Error:", "Ingrese una de las Opciones Permiso"));
                    } else if (tipo.getId_html() == 0) {
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(null, new FacesMessage("Error:", "Ingrese su HTML"));
                    } else {
                        for (int j = 0; j < intermedio.size(); j++) {
                            if (intermedio.get(j).getId_html() == tipo.getId_html() && intermedio.get(j).getId_crud() == tipo.getId_crud()) {
                                acum = acum + 1;
                            }
                        }
                        if (acum > 0) {
                            FacesContext context = FacesContext.getCurrentInstance();
                            context.addMessage(null, new FacesMessage("Error:", "Este Dato Se Repite"));
                            acum = 0;
                        } else {
                            i = i + 1;
                            intermedio.add(new TipoUsuario(i, tipo.getId_crud(), tipo.getId_html()));

                            if (listadescripcion.size() == 0) {
                                listadescripcion.add(new TipoUsuario(1, tipo.getNombretipo(), tipo.getDescripcion()));
                                tipo.setNombretipo(null);
                                tipo.setDescripcion(null);
                            }
                            tipo.setId_crud(0);
                            tipo.setId_html(0);
                        }
                    }
                } else {
                    if (tipo.getId_crud() == 0) {
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(null, new FacesMessage("Error:", "Ingrese una de las Opciones Permiso"));
                    } else {
                        if (tipo.getId_html() == 0) {
                            FacesContext context = FacesContext.getCurrentInstance();
                            context.addMessage(null, new FacesMessage("Error:", "Ingrese su HTML"));
                        } else {

                            if (tipo.getNombretipo().equals("")) {
                                FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, new FacesMessage("Error:", "Ingrese el Nombre"));
                            } else {
                                if (tipo.getDescripcion().equals("")) {
                                    FacesContext context = FacesContext.getCurrentInstance();
                                    context.addMessage(null, new FacesMessage("Error:", "Ingrese su Descripcion"));
                                } else {
                                    i = i + 1;
                                    intermedio.add(new TipoUsuario(i, tipo.getId_crud(), tipo.getId_html()));

                                    if (listadescripcion.size() == 0) {
                                        listadescripcion.add(new TipoUsuario(1, tipo.getNombretipo(), tipo.getDescripcion()));
                                        tipo.setNombretipo(null);
                                        tipo.setDescripcion(null);
                                    }
                                    tipo.setId_crud(0);
                                    tipo.setId_html(0);
                                }
                            }
                        }

                    }
                }

            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Error:", "Este Usuario Ya Existente"));
            }

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para ocultar elementos
     *
     * @return int
     */
    public int Ocultar() {
        int respuesta = listadescripcion.size();

        return respuesta;
    }

    /**
     * Metodo para modificar un tipo de usuario
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar() throws Exception {

        TipoUsuarioDao dao;

        try {
            dao = new TipoUsuarioDao();
            dao.modificar(tip);

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para eliminar un tipo de usuario
     *
     * @param tipo el objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Tipo tipo) throws Exception {

        TipoUsuarioDao dao;

        try {
            dao = new TipoUsuarioDao();
            dao.eliminar(tipo);

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para listar todos los registros de usuario
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void mostar() throws Exception {
        TipoUsuarioDao dao;

        try {
            dao = new TipoUsuarioDao();
            lstUsu = dao.mostrar();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para obtner una fila en un objeto de tipo Uusario
     *
     * @param tipo Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void buscar(Tipo tipo) throws Exception {
        TipoUsuarioDao dao;
        Tipo temp;

        try {
            dao = new TipoUsuarioDao();
            temp = dao.leerParaModificar(tipo);
            if (tip != null) {
                this.tip = temp;
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
