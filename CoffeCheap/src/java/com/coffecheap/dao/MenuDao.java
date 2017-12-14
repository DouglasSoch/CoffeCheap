package com.coffecheap.dao;

import com.coffecheap.modelo.Menu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class MenuDao extends Dao {

    //Me envia los codigos de las paginas principales 1,2,4
    /**
     * Metodo que envia los codigos
     *
     * @param tipo para la sentencia SQL
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Menu> CodigodeMenu(int tipo) throws Exception {

        List<Menu> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select html.idhtml as codigo, html.nombrepagina as paginaprincipales\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina)\n"
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

    /**
     * Metodo que lista todos los registros de menu
     *
     * @param tipo para la sentencia SQL
     * @param pagina para la sentencia SQL
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Menu> SubMenu(int tipo, int pagina) throws Exception {

        List<Menu> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select permiso.idcrud as codigo\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + " and permiso.idpagina=" + pagina + ";");
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

    /**
     * MEtodo que lista todos nombre de las paginas
     *
     * @param tipo para la sentencia SQL
     * @param cantidad para la sentencia SQL
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
    public String Menu1(int tipo, int cantidad) throws Exception {

        String respuesta = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select html.idhtml as codigo, html.nombrepagina as paginaprincipales\n"
                    + "from permiso \n"
                    + "inner join html on(html.idhtml = permiso.idpagina)\n"
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

    /**
     * Metodo para ciclo
     *
     * @param tipo para la sentencia SQL
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int CantidadFor1(int tipo) throws Exception {

        int resultado = 0;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select count(distinct (html.idhtml)) as cantidad\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina)\n"
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
    /**
     * Metodo para la cantidad de ciclos
     *
     * @param tipo para la sentencia SQL
     * @param idpagina para la sentencia SQL
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int CantidadFor2(int tipo, int idpagina) throws Exception {

        int resultado = 0;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select count(html.idhtml) as cantidad\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + " and permiso.idpagina=" + idpagina + ";");
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

    /**
     * Metodo para nombre de la paginas
     *
     * @param tipo para la sentencia SQL
     * @param pagina para la sentencia SQL
     * @param codigo para la sentencia SQL
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
    public String NombresCrud(int tipo, int pagina, int codigo) throws Exception {
        String resultado = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select permiso.idcrud as codigo, crud.nombrecrud as nombrest\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + " and permiso.idpagina=" + pagina + " and permiso.idcrud=" + codigo + ";");
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

    /**
     * Metodo para llamado de pagina
     *
     * @param tipo para la sentencia SQL
     * @param pagina para la sentencia SQL
     * @param codigo para la sentencia SQL
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
    public String LlamadoPagina(int tipo, int pagina, int codigo) throws Exception {
        String resultado = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select permiso.idcrud as codigo, concat(html.nombrepagina,'_',crud.nombrecrud,'.xhtml') as nombrest\n"
                    + "from permiso\n"
                    + "inner join html on(html.idhtml = permiso.idpagina)\n"
                    + "inner join crud on (crud.idcrud = permiso.idcrud) where permiso.idtipo=" + tipo + " and permiso.idpagina=" + pagina + " and permiso.idcrud=" + codigo + ";");
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
