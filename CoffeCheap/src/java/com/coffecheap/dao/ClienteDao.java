package com.coffecheap.dao;

import com.coffecheap.modelo.Cliente;
import com.coffecheap.modelo.Transaccion_inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends Dao {

    public void registrar(Cliente cli) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into cliente values (?,?,?,?)");
            st.setInt(1, cli.getId_cliente());
            st.setString(2, cli.getNit_cliente());
            st.setString(3, cli.getNombre());
            st.setString(4, cli.getDireccion());            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    public List<Cliente> mostrar() throws Exception {
        List<Cliente> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall(" select *from cliente");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId_cliente(rs.getInt(1));
                cli.setNit_cliente(rs.getString(2));
                cli.setNombre(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                lista.add(cli);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    public List<Cliente> mostrarPorPrarametro(Cliente cliente) throws Exception {
        
        List<Cliente> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select nit_cliente, nombre_cliente, direccion from cliente where nit_cliente=?");
            st.setString(1, cliente.getNit_cliente());
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {

                Cliente cli = new Cliente();                
                cli.setNit_cliente(rs.getString(1));
                cli.setNombre(rs.getString(2));
                cli.setDireccion(rs.getString(3));
                lista.add(cli);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    public Cliente leerParaModificar(Cliente cliente) throws Exception {
        Cliente cli= null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select nit_cliente, nombre_cliente, direccion from cliente where nit_cliente=?");
            st.setString(1, cliente.getNit_cliente());
            rs = st.executeQuery();

            while (rs.next()) {
                cli = new Cliente();
                cli.setNit_cliente(rs.getString(1));
                cli.setNombre(rs.getString(2));
                cli.setDireccion(rs.getString(3));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return cli;
    }

    
         public void eliminar(Cliente cliente) throws Exception
    {
        try
        {
         this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from cliente where nit_cliente= ?");
            st.setString(1, cliente.getNit_cliente());
            st.executeUpdate();
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
    }
     
    public void modificar(Cliente cliente) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update cliente set direccion=? where nit_cliente=?");
            st.setString(1, cliente.getDireccion());
            st.setInt(2, cliente.getId_cliente());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

}
