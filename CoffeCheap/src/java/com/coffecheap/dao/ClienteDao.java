package com.coffecheap.dao;

import com.coffecheap.bean.ClienteBean;
import com.coffecheap.modelo.Cliente;
import com.coffecheap.modelo.Transaccion_inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends Dao {

    public void registrar(Cliente cli) throws Exception 
    {
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("select *from cliente where nit_cliente=?");
            ps.setString(1, cli.getNit_cliente());
            rs=ps.executeQuery();
            
            if(rs.next())
            {
             ClienteBean.addMessage("El cleinte ya exixte");
            }else{
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO cliente (`nit_cliente`, `nombre_cliente`, `direccion`) VALUES (?, ?, ?)");
            st.setString(1, cli.getNit_cliente());
            st.setString(2, cli.getNombre());
            st.setString(3, cli.getDireccion());            
            st.executeUpdate();
            ClienteBean.addMessage("Accion completada");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }
    
    public void registrarN(Cliente cli) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO cliente (`nit_cliente`, `nombre_cliente`, `direccion`) VALUES (?, ?, ?);");            
            st.setString(1, cli.getNit_cliente());
            st.setString(2, cli.getNombre());
            st.setString(3, cli.getDireccion());            
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
            PreparedStatement st = getCon().prepareCall(" select id_cliente, nit_cliente, nombre_cliente, direccion from cliente");
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
    
    public List<Cliente> listarNombre() throws Exception{
        List<Cliente> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement ps = getCon().prepareCall("select  id_cliente, nombre_cliente from cliente");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setId_cliente(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                lista.add(cli);
            }   
        }catch(Exception e)
        {
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
            PreparedStatement st = getCon().prepareCall("select direccion from cliente where id_cliente=?");
            st.setInt(1, cliente.getId_cliente());
            rs = st.executeQuery();

            while (rs.next()) {
                cli = new Cliente();
                cli.setDireccion(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return cli;
    }

        
    public Cliente leerParaModificarS(Cliente cliente) throws Exception {
        Cliente cli= null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_cliente, nit_cliente, nombre_cliente, direccion from cliente where nit_cliente=?");
            st.setString(1, cliente.getNit_cliente());
            rs = st.executeQuery();

            
            if (rs!=null && rs.next()) {
                cli = new Cliente();
                cli.setId_cliente(rs.getInt(1));
                cli.setNit_cliente(rs.getString(2));
                cli.setNombre(rs.getString(3));
                cli.setDireccion(rs.getString(4));

            }
            else
            {
            cli = new Cliente();
                cli.setId_cliente(0);
                cli.setNit_cliente(null);
                cli.setNombre(null);
                cli.setDireccion(null);
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
            PreparedStatement st = this.getCon().prepareStatement("delete from cliente where id_cliente=?");
            st.setInt(1, cliente.getId_cliente());
            st.executeUpdate();
            ClienteBean.addMessage("Accion completada");    
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
    }
     
    public void modificar(Cliente cliente) throws Exception 
    {
        System.out.println("El nombre es "+cliente.getNombre());
        System.out.println("la direccion es "+cliente.getDireccion());
        System.out.println("El id es"+ cliente.getId_cliente());
        System.out.println("el nit es "+cliente.getNit_cliente());
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update cliente set nombre_cliente=?, direccion=? where id_cliente=?");
            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getDireccion());
            st.setInt(3, cliente.getId_cliente());
            st.executeUpdate();
            ClienteBean.addMessage("Accion completada");
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    public Cliente leerFila(Cliente cliente) throws Exception {
        
        
        Cliente cli= null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_cliente, nit_cliente, nombre_cliente, direccion from cliente where id_cliente=?");
            st.setInt(1, cliente.getId_cliente());
            rs = st.executeQuery();

            while (rs.next()) {
                cli = new Cliente();
                cli.setId_cliente(rs.getInt(1));
                cli.setNit_cliente(rs.getString(2));
                cli.setNombre(rs.getString(3));
                cli.setDireccion(rs.getString(4));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return cli;
    }
    
}
