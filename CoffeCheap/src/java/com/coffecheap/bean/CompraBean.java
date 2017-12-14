package com.coffecheap.bean;

import com.coffecheap.dao.CompraDao;
import com.coffecheap.dao.Dao;
import java.util.List;
import com.coffecheap.modelo.Compra;
import com.coffecheap.modelo.Producto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bryan
 */
@ManagedBean
@ViewScoped
public class CompraBean extends Dao {

    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    Compra compra = new Compra();
    List<Compra> lista;
    ArrayList<Compra> intermedio = new ArrayList<Compra>();
    int i;
    int producto;

    public ArrayList<Compra> getIntermedio() {
        return intermedio;
    }

    public void setIntermedio(ArrayList<Compra> intermedio) {
        this.intermedio = intermedio;
    }

    public List<Compra> getLista() {
        return lista;
    }

    public void setLista(List<Compra> lista) {
        this.lista = lista;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public CompraBean() {
    }

    /**
     * Metodo especial para la compra
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Intermedio() throws Exception {
        if (compra.getOcompras().getId_orden_compras() == 0) {
            addMessage("Eliga Un Numero de Orden");
        } else {
            if (compra.getProducto().getId_producto() == 0) {
                addMessage("Eliga Un Producto");
            } else {
                if (compra.getCantidad() == 0) {
                    addMessage("Ingrese La Cantidad");
                } else {
                    if (compra.getCosto() == 0) {
                        addMessage("Ingrese El costo");
                    } else {
                        if (compra.getNo_fac() == 0) {
                            addMessage("Ingrese El Numero de Factura");
                        } else {
                            if (compra.getSerie().equals("")) {
                                addMessage("Ingrese El Numero de Serie");
                            } else {
                                if (compra.getFechaEntrega().equals("")) {
                                    addMessage("Ingrese La Fecha de Entrega");
                                } else {
                                    i = i + 1;
                                    intermedio.add(new Compra(i, compra.getOcompras().getId_orden_compras(), compra.getProducto().getId_producto(),
                                            compra.getCantidad(), compra.getCosto(), compra.getNo_fac(), compra.getSerie(), compra.getFechaEntrega()));

                                    compra.getOcompras().setId_orden_compras(0);
                                    compra.getProducto().setId_producto(0);
                                    compra.setCantidad(0);
                                    compra.setCosto(0);
                                    compra.setFechaEntrega(null);
                                    compra.setNo_fac(0);
                                    compra.setSerie(null);

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo para registrar una compra
     */
    public void Ingresar() {
        CompraDao dao;
        try {
            dao = new CompraDao();
            for (int j = 0; j < intermedio.size(); j++) {

                int orden = intermedio.get(j).getOcompras().getId_orden_compras();
                int producto = intermedio.get(j).getProducto().getId_producto();
                int cantidad = intermedio.get(j).getCantidad();
                int costo = intermedio.get(j).getCosto();
                int factura = intermedio.get(j).getNo_fac();
                String serie = intermedio.get(j).getSerie();
                String dia = intermedio.get(j).getFechaEntrega().substring(0, 2);
                String mes = intermedio.get(j).getFechaEntrega().substring(3, 5);
                String anio = intermedio.get(j).getFechaEntrega().substring(6, 10);
                String fecha = anio + "-" + mes + "-" + dia;
                dao.Insertar(orden, producto, cantidad, costo, factura, serie, fecha);
                int productointer = dao.Operacion(intermedio.get(j).getProducto().getId_producto());
                int suma = productointer + cantidad;
                dao.ActualizacionProductos(intermedio.get(j).getProducto().getId_producto(), suma);

            }

            intermedio.clear();

        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(CompraBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo para eliminar un registro de compra
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Eliminar() throws Exception {

        CompraDao dao;

        try {
            dao = new CompraDao();
            int codigoproducto = dao.CodigoProducto(compra.getId_compras());
            int cantidadproducto = dao.CantidadProducto(compra.getId_compras());
            int existencia = dao.CantidadEnTabla(codigoproducto);
            dao.ActualizarExistencia(existencia - cantidadproducto, codigoproducto);
            dao.Eliminar(compra);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para modificar una compra
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Modificar() throws Exception {

        CompraDao dao;
        producto = compra.getProducto().getId_producto();
        try {
            if (compra.getId_compras() == 0) {
                addMessage("Ingrese un ID de Compra");
            } else {
                if (compra.getOcompras().getId_orden_compras() == 0) {
                    addMessage("Eliga Un Numero de Orden");
                } else {
                    if (compra.getProducto().getId_producto() == 0) {
                        addMessage("Eliga Un Producto");
                    } else {
                        if (compra.getCantidad() == 0) {
                            addMessage("Ingrese La Cantidad");
                        } else {
                            if (compra.getCosto() == 0) {
                                addMessage("Ingrese El costo");
                            } else {
                                if (compra.getNo_fac() == 0) {
                                    addMessage("Ingrese El Numero de Factura");
                                } else {
                                    if (compra.getSerie().equals("")) {
                                        addMessage("Ingrese El Numero de Serie");
                                    } else {
                                        if (compra.getFechaEntrega().equals("")) {
                                            addMessage("Ingrese La Fecha de Entrega");
                                        } else {
                                            dao = new CompraDao();
                                            dao.Modificar(compra);
                                            List<String> listado = new ArrayList();
                                            listado = dao.CodigodeProducto();
                                            for (int j = 0; j < listado.size(); j++) {
                                                int cantidad = dao.Cantidad(Integer.parseInt(listado.get(j)));
                                                dao.ActualizarCantidad(cantidad, Integer.parseInt(listado.get(j)));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
//        System.out.println("productos: " + listado.get(j));
            }

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para listar todos los registros de compra
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void Mostrar() throws Exception {

        CompraDao dao;
        try {
            dao = new CompraDao();
            lista = dao.Mostrar();
        } catch (Exception e) {
            throw e;
        }
    }
}
