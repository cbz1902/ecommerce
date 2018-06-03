/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.sql.Date;

/**
 *
 * @author carlos
 */

public class Transaccionescab{
    Integer id_transaccion;
    Date fecha;
    int total;
    String direccion_de_envio;
    int id_medio_pago;
    Integer nro_tarjeta;
    String estado;
    int id_usuario;

    public Integer getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(Integer id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDireccion_de_envio() {
        return direccion_de_envio;
    }

    public void setDireccion_de_envio(String direccion_de_envio) {
        this.direccion_de_envio = direccion_de_envio;
    }

    public int getId_medio_pago() {
        return id_medio_pago;
    }

    public void setId_medio_pago(int id_medio_pago) {
        this.id_medio_pago = id_medio_pago;
    }

    public Integer getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(Integer nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}