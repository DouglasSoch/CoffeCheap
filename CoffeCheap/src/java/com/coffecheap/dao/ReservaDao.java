package com.coffecheap.dao;

import com.coffecheap.bean.ReservaBean;
import com.coffecheap.modelo.Cliente;
import com.coffecheap.modelo.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReservaDao extends Dao {

    public List<Reserva> consultaDeDispo(Reserva reserva) throws Exception {
        List<Reserva> lstReserva = null;
        try {
            this.Conectar();

            ResultSet rs;
            PreparedStatement ps = getCon().prepareCall("select id_mesa, hora_inicio, hora_final, fecha from reserva where hora_inicio BETWEEN  ? and ? AND fecha=?");
            ps.setString(1, reserva.getHora_entrada());
            ps.setString(2, reserva.getHora_salida());
            ps.setString(3, reserva.getFechaSus());
            rs = ps.executeQuery();
            lstReserva = new ArrayList();
            while (rs.next()) {
                Reserva reser = new Reserva();
                reser.setId_reserva(rs.getInt(1));
                reser.setHora_entrada(rs.getString(2));
                reser.setHora_salida(rs.getString(3));
                reser.setFechaSus(rs.getString(4));
                lstReserva.add(reser);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lstReserva;
    }

    public void registrarclienteYReserva(String nit) throws Exception 
    {
           
        try {
            this.Conectar();
            String resultado=null;
            
            PreparedStatement ps = this.getCon().prepareStatement("select nit_cliente from cliente where nit_cliente=?");
            ps.setString(1, nit);
            ResultSet rs =ps.executeQuery();
            
            
            rs.next(); 
            
                if (rs.getString(1).equals(nit)) 
                {
                    System.out.println("el nit es correcto :  "+resultado);
                    ReservaBean.addMessage("El cliente existe");
                }
                if (rs.getString(1).isEmpty())
                {
                    System.out.println("el nit es incorrecto:  "+resultado);
                    ReservaBean.addMessage("El cliente no existe");
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    public void registrar(Reserva reserva) throws Exception {
        try {
            this.Conectar();
            PreparedStatement psir = this.getCon().prepareStatement("insert into reserva values(?,?,?,?,?,?,?)");
            psir.setInt(1, reserva.getId_reserva());
            psir.setString(2, reserva.getFechaSus());
            psir.setString(3, reserva.getHora_entrada());
            psir.setString(4, reserva.getHora_salida());
            psir.setInt(5, reserva.getCantidad_personas());
            psir.setInt(6, reserva.getMesa().getId_mesa());
            psir.setInt(7, reserva.getCliente().getId_cliente());
            psir.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    public List<Reserva> mostrar() throws Exception {
        List<Reserva> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall(" select id_reserva, fecha, hora_inicio, hora_final, cantidad_personas from reserva");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId_reserva(rs.getInt(1));
                reserva.setFecha(rs.getDate(2));
                reserva.setHora_inicio(rs.getTime(3));
                reserva.setHora_final(rs.getTime(4));
                reserva.setCantidad_personas(rs.getInt(5));
                lista.add(reserva);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    public List<Reserva> mostrarPorPrarametro(Reserva reservaa) throws Exception {

        List<Reserva> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_reserva, fecha, hora_inicio, hora_final, cantidad_personas from reserva where id_reserva=?");
            st.setInt(1, reservaa.getId_reserva());
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {

                Reserva reserva = new Reserva();
                reserva.setId_reserva(rs.getInt(1));
                reserva.setFecha(rs.getDate(2));
                reserva.setHora_inicio(rs.getTime(3));
                reserva.setHora_final(rs.getTime(4));
                reserva.setCantidad_personas(rs.getInt(5));
                lista.add(reserva);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    public Reserva leerParaModificar(Reserva reservaa) throws Exception {
        Reserva reserva = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_reserva, fecha, hora_inicio, hora_final, cantidad_personas from reserva where id_reserva=?");
            st.setInt(1, reservaa.getId_reserva());
            rs = st.executeQuery();

            while (rs.next()) {
                reserva = new Reserva();
                reserva.setId_reserva(rs.getInt(1));
                reserva.setFechaSus(rs.getString(2));
                reserva.setHora_entrada(rs.getString(3));
                reserva.setHora_salida(rs.getString(4));
                reserva.setCantidad_personas(rs.getInt(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return reserva;
    }

    public void eliminar(Reserva reserva) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from reserva where id_reserva=?");
            st.setInt(1, reserva.getId_reserva());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    public void modificar(Reserva reserva) throws Exception {
        try {

            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formateadorHora = new SimpleDateFormat("HH:MM");

            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update reserva set fecha=?, hora_inicio=?, "
                    + "hora_final=?, cantidad_personas=?  where id_reserva=?");

            st.setString(1, formateador.format(reserva.getFecha()));
            st.setString(2, formateadorHora.format(reserva.getHora_inicio()));
            st.setString(3, formateadorHora.format(reserva.getHora_final()));
            st.setInt(4, reserva.getCantidad_personas());
            st.setInt(5, reserva.getId_reserva());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    public List<Reserva> mostrarr() throws Exception {
        List<Reserva> lstReserva = null;
        System.out.println("entro");
        try {
            this.Conectar();

            ResultSet rs;
            PreparedStatement ps = getCon().prepareCall("select id_mesa, hora_inicio, hora_final, fecha from reserva");
            rs = ps.executeQuery();

            lstReserva = new ArrayList();
            while (rs.next()) {
                Reserva reser = new Reserva();
                reser.getMesa().setId_mesa(rs.getInt(1));
                reser.setHora_entrada(rs.getString(2));
                reser.setHora_salida(rs.getString(3));
                reser.setFecha(rs.getDate(4));
                lstReserva.add(reser);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lstReserva;
    }
}
