package com.coffecheap.dao;

import com.coffecheap.bean.PedidoBean;
import com.coffecheap.modelo.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class PedidoDao extends Dao {

  public void registrar(Pedido Tt) throws Exception 
  {

    try 
    {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into pedido(id_mesa,hora,id_personal,cancelado,fecha)values(?,?,?,?,?)");
      st.setInt(1, Tt.getMesa().getId_mesa());
      st.setTime(2, Tt.getHora());
      st.setInt(3, Tt.getUsuario().getId());
      st.setInt(4, 0);
      st.setString(5, Tt.getTemp_fecha());
      st.executeUpdate();
      PedidoBean.addMessage("Accion Completada");
    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Pedido> listar() throws Exception {
    List<Pedido> lista;
    ResultSet rs;
    String cancelado= null;
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("select pedido.id_pedido, mesa.id_mesa, pedido.hora, usuario.iduser, usuario.user, pedido.cancelado, pedido.fecha from pedido inner join mesa on (pedido.id_mesa = mesa.id_mesa) inner join usuario on (pedido.id_personal = usuario.iduser)");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) 
      {
          
        Pedido tt = new Pedido();
          if(rs.getInt(6) == 1)
          {
            tt.setCancelar("CANCELADO");
          }
          else
          {
              tt.setCancelar("NO CANCELADO");
          }
        tt.setId_pedido(rs.getInt(1));
        tt.getMesa().setId_mesa(rs.getInt(2));
        tt.setHora(rs.getTime(3));
        tt.getUsuario().setId(rs.getInt(4));
        tt.getUsuario().setNombre(rs.getString(5));
        tt.getCancelar();
        tt.setFecha(rs.getDate(7));
        lista.add(tt);
          
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Pedido Tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  pedido SET id_pedido=?, id_mesa=?, hora=?, id_personal=? WHERE id_pedido=?;");

      st.setInt(1, Tt.getId_pedido());
      st.setInt(2, Tt.getMesa().getId_mesa());
      st.setTime(3, Tt.getHora());
      st.setInt(4, Tt.getUsuario().getId());
      st.setInt(5, Tt.getId_pedido());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Pedido pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM pedido WHERE id_pedido=?;");
      st.setInt(1, pac.getId_pedido());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

}
