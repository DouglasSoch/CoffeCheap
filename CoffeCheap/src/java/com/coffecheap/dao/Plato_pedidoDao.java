/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.Plato_pedidoBean;
import com.coffecheap.modelo.Plato_pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class Plato_pedidoDao extends Dao {

    /**
     * Metodo para registrar en plato pedido
     *
     * @param ppedido
     * @throws Exception
     */
    public void registrar(Plato_pedido ppedido) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into plato_pedido(id_plato,cantidad,id_personal,id_pedido,precio) values(?,?,?,?,?)");
            st.setInt(1, ppedido.getPlato().getId_plato());
            st.setInt(2, ppedido.getCantidad());
            st.setInt(3, ppedido.getUsuario().getId());
            st.setInt(4, ppedido.getPedido().getId_pedido());
            st.setDouble(5, ppedido.getPrecio());
            st.executeUpdate();
            Plato_pedidoBean.addMessage("Accion Completada");
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para listar todos los registros de plato pedido
     *
     * @return
     * @throws Exception
     */
    public List<Plato_pedido> listar() throws Exception {
        List<Plato_pedido> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select plato_pedido.id_plato_pedido, plato.id_plato, plato.nombre_platillo, plato_pedido.cantidad, usuario.iduser, usuario.user, pedido.id_pedido, plato_pedido.precio from plato_pedido inner join plato on(plato_pedido.id_plato = plato.id_plato) inner join usuario on (plato_pedido.id_personal = usuario.iduser) inner join pedido on (plato_pedido.id_pedido = pedido.id_pedido)");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Plato_pedido ppedido = new Plato_pedido();
                ppedido.setId_plato_pedido(rs.getInt(1));
                ppedido.getPlato().setId_plato(rs.getInt(2));
                ppedido.getPlato().setNombre(rs.getString(3));
                ppedido.setCantidad(rs.getInt(4));
                ppedido.getUsuario().setId(rs.getInt(5));
                ppedido.getUsuario().setUsuario(rs.getString(6));
                ppedido.getPedido().setId_pedido(rs.getInt(7));
                ppedido.setPrecio(rs.getDouble(8));
                lista.add(ppedido);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    /**
     * MEtodo para modificar un registro en plato pedido
     *
     * @param ppedido
     * @throws Exception
     */
    public void modificar(Plato_pedido ppedido) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE  plato_pedido SET  id_plato=?, cantidad=?, id_personal=?, id_pedido=?, precio=? WHERE id_plato_pedido=?");
            st.setInt(1, ppedido.getPlato().getId_plato());
            st.setInt(2, ppedido.getCantidad());
            st.setInt(3, ppedido.getUsuario().getId());
            st.setInt(4, ppedido.getPedido().getId_pedido());
            st.setDouble(5, ppedido.getPrecio());
            st.setInt(6, ppedido.getId_plato_pedido());
            st.executeUpdate();
            Plato_pedidoBean.addMessage("Accion Completada");

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }
    }

    /**
     * Metodo para eliminar un registro en plato pedido
     *
     * @param ppedido
     * @throws Exception
     */
    public void eliminar(Plato_pedido ppedido) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM plato_pedido WHERE id_plato_pedido=?;");
            st.setInt(1, ppedido.getId_plato_pedido());
            st.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }
    }

    /**
     * Metodo para obtener antes de modificar
     *
     * @param platoPedido
     * @return
     * @throws Exception
     */
    public Plato_pedido leerParaModificar(Plato_pedido platoPedido) throws Exception {
        Plato_pedido platoPe = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_plato_pedido,id_plato,cantidad,id_personal,id_pedido,precio  from plato_pedido where id_plato_pedido=?");
            st.setInt(1, platoPedido.getId_plato_pedido());
            rs = st.executeQuery();
            while (rs.next()) {
                platoPe = new Plato_pedido();
                platoPe.setId_plato_pedido(rs.getInt(1));
                platoPe.getPlato().setId_plato(rs.getInt(2));
                platoPe.setCantidad(rs.getInt(3));
                platoPe.getUsuario().setId(rs.getInt(4));
                platoPe.getPedido().setId_pedido(rs.getInt(5));
                platoPe.setPrecio(rs.getDouble(6));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return platoPe;
    }

}
