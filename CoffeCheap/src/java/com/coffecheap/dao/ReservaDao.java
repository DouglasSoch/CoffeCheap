package com.coffecheap.dao;

import com.coffecheap.bean.ReservaBean;
import com.coffecheap.modelo.Cliente;
import com.coffecheap.modelo.Mesa;
import com.coffecheap.modelo.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ReservaDao extends Dao {

//    Cliente cliEs = new Cliente();
//
//    public Cliente getCliEs() {
//        return cliEs;
//    }
//
//    public void setCliEs(Cliente cliEs) {
//        this.cliEs = cliEs;
//    }
    /**
     * Metodo para listar cosulta de disponibilidad
     *
     * @param reserva para la sentencia SQL
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo para registrar un cliente y una reserva
     *
     * @param nit para la sentencia SQL
     * @return boolean
     * @throws Exception por si resulta un error de SQL
     */
    public Boolean registrarclienteYReserva(String nit) throws Exception {
        Boolean estado = false;
        try {
            this.Conectar();

            PreparedStatement ps = this.getCon().prepareStatement("select nit_cliente from cliente where nit_cliente=?");
            ps.setString(1, nit);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString(1).equals(nit)) {
                    ReservaBean.addMessage("El cliente existe");
                    estado = false;
                }
            } else {
                ReservaBean.addMessage("El cliente no existe");
                estado = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        System.out.println("el valor final es: " + estado);
        return estado;

    }

    /**
     * Metodo para listar todos los registros de cliente para lista desplegable
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Cliente> listarNombre() throws Exception {
        List<Cliente> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareCall("select  id_cliente, nombre_cliente from cliente");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId_cliente(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                lista.add(cli);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    /**
     * Metodo para listar todos los registros de mesa
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Mesa> listarMesa() throws Exception {
        List<Mesa> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareCall("select id_mesa from mesa ORDER BY id_mesa ASC");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Mesa cli = new Mesa();
                cli.setId_mesa(rs.getInt(1));

                lista.add(cli);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    /**
     * Metodo para registrar una reserva
     *
     * @param reserva para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void registrar(Reserva reserva) throws Exception {
        try {
            this.Conectar();
            PreparedStatement psir = this.getCon().prepareStatement("insert into reserva (fecha, hora_inicio, hora_final, cantidad_personas, id_mesa, id_cliente) values(?,?,?,?,?,?)");
            psir.setString(1, reserva.getFechaSus());
            psir.setString(2, reserva.getHora_entrada());
            psir.setString(3, reserva.getHora_salida());
            psir.setInt(4, reserva.getCantidad_personas());
            psir.setInt(5, reserva.getMesa().getId_mesa());
            psir.setInt(6, reserva.getCliente().getId_cliente());
            psir.executeUpdate();
            ReservaBean.addMessage("Reserva guardada");
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    /**
     * Metodo para listar reserva
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo para listar Reserva
     *
     * @param reservaa para la sentencia SQL
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo para obtener registro
     *
     * @param reservaa para la sentencia SQL
     * @return objeto reserva
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo para eliminar una reserva
     *
     * @param reserva para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * MEtodo para miodificar una reserva
     *
     * @param reserva para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo para listar reserva
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo para obtener e registro de reserva
     *
     * @param cliente para la sentencia SQL
     * @return objeto Cliente
     * @throws Exception por si resulta un error de SQL
     */
    public Cliente leerFilaR(Cliente cliente) throws Exception {

        Cliente cli = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_cliente, nit_cliente, nombre_cliente, direccion from cliente where nit_cliente=?");
            st.setString(1, cliente.getNit_cliente());
            rs = st.executeQuery();

            while (rs.next()) {
                cli = new Cliente();
                cli.setId_cliente(rs.getInt(1));
                cli.setNit_cliente(rs.getString(2));
                cli.setNombre(rs.getString(3));
                cli.setDireccion(rs.getString(4));
            }
            //this.getCliEs().setNit_cliente(cli.getNit_cliente());
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return cli;
    }

//         public Cliente nit(Cliente cliente) throws Exception {
//        Cliente cli= null;
//        try {
//            this.Conectar();
//        
//                cli.setNit_cliente(rs.getString(2));
//              
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.Desconecar();
//        }
//        return cli;
//    }
}
