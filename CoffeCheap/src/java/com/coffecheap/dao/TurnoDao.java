package com.coffecheap.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.coffecheap.modelo.Turno;

public class TurnoDao extends Dao{

    public void Ingresar(Turno turno) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into turno values(?,?,?)");
            st.setInt(1, turno.getId_turno());
            st.setString(2, turno.getHorario_turno());
            st.setString(3, turno.getObservaciones());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconecar();
            turno.setId_turno(0);
            turno.setHorario_turno(null);
            turno.setObservaciones(null);
        }
    }
    
    public void Eliminar(Turno turno) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from turno where idturno=?");
            st.setInt(1, turno.getId_turno());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconecar();
            turno.setId_turno(0);
        }
    }
    
    public void Modificar(Turno turno) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE turno SET horario_turno=?, observaciones=? where idturno=?");
            st.setString(1,turno.getHorario_turno());
            st.setString(2, turno.getObservaciones());
            st.setInt(3, turno.getId_turno());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconecar();
            turno.setId_turno(0);
            turno.setHorario_turno(null);
            turno.setObservaciones(null);
        }
    }
    
    
    public List<Turno> Visualizar() throws Exception{
        
        List<Turno> lista;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from turno");
            rs = st.executeQuery();
            lista = new ArrayList();
            
            while (rs.next()) {
                Turno turno = new Turno();
                turno.setId_turno(rs.getInt("idturno"));
                turno.setHorario_turno(rs.getString("horario_turno"));
                turno.setObservaciones(rs.getString("observaciones"));
                lista.add(turno);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconecar();
        }
        return lista;
    }
}
