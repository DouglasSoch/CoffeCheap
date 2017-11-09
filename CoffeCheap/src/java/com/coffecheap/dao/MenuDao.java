package com.coffecheap.dao;

import com.coffecheap.modelo.Menu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDao extends Dao {

    //Me envia los codigos de las paginas principales 1,2,4
    public List<Menu> CodigodeMenu(int tipo) throws Exception {

        List<Menu> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select html.idhtml as codigo, html.nombrepagina as paginaprincipales\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina_html)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + " group by html.idhtml asc;");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setCodigo(rs.getInt("codigo"));
                lista.add(menu);
            }
        } catch (Exception e) {
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    public List<Menu> SubMenu(int tipo, int pagina) throws Exception {

        List<Menu> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select permiso.idcrud as codigo\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina_html)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + " and permiso.idpagina_html=" + pagina + ";");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setCodigosubmenu(rs.getInt("codigo"));
                lista.add(menu);
            }
        } catch (Exception e) {
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    public String Menu1(int tipo, int cantidad) throws Exception {

        String respuesta = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select html.idhtml as codigo, html.nombrepagina as paginaprincipales\n"
                    + "from permiso \n"
                    + "inner join html on(html.idhtml = permiso.idpagina_html)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + " and html.idhtml=" + cantidad + "\n"
                    + "group by html.idhtml asc;");
            rs = st.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setCodigo(rs.getInt("codigo"));
                menu.setPaginaprincipal(rs.getString("paginaprincipales"));
                respuesta = menu.getPaginaprincipal();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return respuesta;
    }

    public int CantidadFor1(int tipo) throws Exception {

        int resultado = 0;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select count(distinct (html.idhtml)) as cantidad\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina_html)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + ";");
            rs = st.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setCantidadprimerciclo(rs.getInt("cantidad"));
                resultado = menu.getCantidadprimerciclo();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }

        return resultado;
    }

    //Este define la cantidad de ciclos
    public int CantidadFor2(int tipo, int idpagina) throws Exception {

        int resultado = 0;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select count(html.idhtml) as cantidad\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina_html)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + " and permiso.idpagina_html=" + idpagina + ";");
            rs = st.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setCantidadprimerciclo(rs.getInt("cantidad"));
                resultado = menu.getCantidadprimerciclo();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }

        return resultado;
    }

    public String NombresCrud(int tipo, int pagina, int codigo) throws Exception {
        String resultado = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select permiso.idcrud as codigo, crud.nombrecrud as nombrest\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina_html)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + " and permiso.idpagina_html=" + pagina + " and permiso.idcrud=" + codigo + ";");
            rs = st.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setSubpagina(rs.getString("nombrest"));
                resultado = menu.getSubpagina();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return resultado;
    }

    public String LlamadoPagina(int tipo, int pagina, int codigo) throws Exception {
        String resultado = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select permiso.idcrud as codigo, concat(html.nombrepagina,'_',crud.nombrecrud,'.xhtml') as nombrest\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina_html)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo="+tipo+" and permiso.idpagina_html="+pagina+" and permiso.idcrud="+codigo+";");
            rs = st.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setLlamadopagina(rs.getString("nombrest"));
                resultado = menu.getLlamadopagina();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return resultado;
    }
}
