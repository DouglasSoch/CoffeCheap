package com.coffecheap.bean;

import com.coffecheap.dao.TipoUsuarioDao;
import com.coffecheap.modelo.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class TipoUsuarioBean {

    TipoUsuario tipo = new TipoUsuario();
    List<TipoUsuario> listacrud;
    List<TipoUsuario> listanombre;
    ArrayList<TipoUsuario> datosbase = new ArrayList<TipoUsuario>();
    ArrayList<TipoUsuario> intermedio = new ArrayList<TipoUsuario>();
    ArrayList<TipoUsuario> listadescripcion = new ArrayList<TipoUsuario>();
    int i;
    int acum;

    private String message;

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

    public void Crud() throws Exception {

        TipoUsuarioDao dao;
        try {
            dao = new TipoUsuarioDao();
            listacrud = dao.Crud();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Nombre() throws Exception {

        TipoUsuarioDao dao;
        try {
            dao = new TipoUsuarioDao();
            listanombre = dao.Html();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Intermedio() throws Exception {
        TipoUsuarioDao dao;

        try {
            dao = new TipoUsuarioDao();

            String nombre = dao.Comparar(tipo.getNombretipo());
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
                            if (nombre == null) {

                                if (intermedio.size() > 0) {

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
                            } else {
                                FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, new FacesMessage("Error:", "Este Usuario Ya Existente"));
                            }

                        }
                    }

                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public int Ocultar() {
        int respuesta = listadescripcion.size();

        return respuesta;
    }

}
