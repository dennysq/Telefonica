/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.telefonica.model;

import com.teamj.distribuidas.telefonica.persistence.BaseEntity;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author Gaming
 */
@Entity(noClassnameStored = true)
public class TransaccionTelefonia extends BaseEntity{
    @Reference
    private Telefonia telefonia;
    private float monto;
    private float saldo;
    private String numeroTelefono;
    private Date fecha;

    public Telefonia getTelefonia() {
        return telefonia;
    }

    public void setTelefonia(Telefonia telefonia) {
        this.telefonia = telefonia;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
