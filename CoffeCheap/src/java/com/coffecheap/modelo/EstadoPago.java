package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase estado pago
 *
 * @author bryan
 */
public class EstadoPago {

    private boolean DesHabilitarBoton = false;
    private String Estado = null;

    public boolean isDesHabilitarBoton() {

        return DesHabilitarBoton;
    }

    public void setDesHabilitarBoton(boolean DesHabilitarBoton) {
        this.DesHabilitarBoton = DesHabilitarBoton;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public EstadoPago() {
    }

}
