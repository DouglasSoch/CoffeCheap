package com.coffecheap.bean;

import com.coffecheap.dao.MenuDao;
import com.coffecheap.modelo.Menu;
import com.coffecheap.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MenuBean implements Serializable {

    Menu menu = new Menu();
    List<Menu> listamenu = new ArrayList();
    Usuario usu = new Usuario();

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getListamenu() {
        return listamenu;
    }

    public void setListamenu(List<Menu> listamenu) {
        this.listamenu = listamenu;
    }

    public void usu() {
        usu = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nomb");
    }

    public String Mostrar(int hola) throws Exception {

        String respuesta = null;
        MenuDao dao;
        try {
            dao = new MenuDao();
            respuesta = dao.Menu1(usu.getTipo().getId(), hola);
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    public int Cantidad1() throws Exception {
        int respuesta = 0;
        MenuDao dao;
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nomb");
        try {
            dao = new MenuDao();
            respuesta = dao.CantidadFor1(usuario.getTipo().getId());
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    public int CodigoEnvio(int cantidadciclo) throws Exception {

        int respuesta = 0;
        MenuDao dao;
        
        try {
            dao = new MenuDao();
            int cantidadget = cantidadciclo - 1;
            Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nomb");
            respuesta = dao.CodigodeMenu(usuario.getTipo().getId()).get(cantidadget).getCodigo();
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    public int CodigoEnvio2(int num2, int cantidadciclo) throws Exception {

        int respuesta = 0;
        MenuDao dao;
        try {
            dao = new MenuDao();
            int cantidadget = cantidadciclo - 1;
            respuesta = dao.SubMenu(usu.getTipo().getId(), num2).get(cantidadget).getCodigosubmenu();
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    public int Cantidad2(int num1) throws Exception {
        int respuesta = 0;
        MenuDao dao;
        try {
            Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nomb");
            dao = new MenuDao();
            respuesta = dao.CantidadFor2(usuario.getTipo().getId(), num1);
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    public String Submenu(int pagina, int num) throws Exception {
        String respuesta = null;
        MenuDao dao;
        try {
            dao = new MenuDao();
            respuesta = dao.NombresCrud(usu.getTipo().getId(), pagina, num);
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    public String PaginaLlamado(int pagina, int num) throws Exception {
        String respuesta = null;
        MenuDao dao;
        try {
            dao = new MenuDao();
            respuesta = dao.LlamadoPagina(usu.getTipo().getId(), pagina, num);
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

}
