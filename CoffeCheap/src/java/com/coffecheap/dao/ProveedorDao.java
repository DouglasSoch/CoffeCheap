package com.coffecheap.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.coffecheap.modelo.Proveedor;

public class ProveedorDao extends Dao {

    public void Ingresar(Proveedor proveedor) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into proveedor values(?,?,?,?,?)");
            st.setInt(1, proveedor.getId_provedor());
            st.setString(2, proveedor.getNombre());
            st.setInt(3, proveedor.getTelefono());
            st.setString(4, proveedor.getMail());
            st.setString(5, proveedor.getDireccion());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    public void Eliminar(Proveedor proveedor) throws Exception {
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete proveedor where id_proveedor=?");
            st.setInt(1, proveedor.getId_provedor());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconecar();
        }
        
    }
    
    public void Modificar(Proveedor proveedor) throws Exception{
        
        try {
            PreparedStatement st = this.getCon().prepareStatement("update from proveedor set(?,?,?,? where id_proveedor=?)");
            st.setString(1, proveedor.getNombre());
            st.setInt(2, proveedor.getTelefono());
            st.setString(3, proveedor.getMail());
            st.setString(4, proveedor.getDireccion());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconecar();
        }
        
    }
    
    public List<Proveedor> Mostrar() throws Exception{
        
        List<Proveedor> lista;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from proveedor");
            rs = st.executeQuery();
            lista = new ArrayList();
            
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_provedor(rs.getInt("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                proveedor.setTelefono(rs.getInt("telefono_proveedor"));
                proveedor.setMail(rs.getString("email_proveedor"));
                proveedor.setDireccion(rs.getString("direccion_proveedor"));
                lista.add(proveedor);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconecar();
        }
        return lista;
    }

}
