/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.telefonica.model;

import com.teamj.distribuidas.telefonica.persistence.BaseEntity;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author Gaming
 */
@Entity(noClassnameStored = true)
public class Telefonia extends BaseEntity{
    private String telefono;
    private float saldo;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
}
