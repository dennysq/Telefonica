/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.telefonica.Beans;

import com.teamj.distribuidas.telefonica.DAO.TelefoniaDAO;
import com.teamj.distribuidas.telefonica.DAO.TransaccionTelefoniaDAO;
import com.teamj.distribuidas.telefonica.model.Telefonia;
import com.teamj.distribuidas.telefonica.model.TransaccionTelefonia;
import com.teamj.distribuidas.telefonica.persistence.PersistenceManager;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gaming
 */
//@ManagedBean
//@ViewScoped
public class TransaccionTelefoniaBean {
    private final TransaccionTelefoniaDAO transaccionTelefonicaDAO;
    private final TelefoniaDAO telefonicaDAO;
    private TransaccionTelefonia transaccionTelefonica;
    private float monto;
    private Telefonia telefonia;
    private String telefono;
    private int success;

    public TransaccionTelefonia getTransaccionTelefonica() {
        return transaccionTelefonica;
    }

    public void setTransaccionTelefonica(TransaccionTelefonia transaccionTelefonica) {
        this.transaccionTelefonica = transaccionTelefonica;
    }
    public TransaccionTelefoniaBean()
    {
        transaccionTelefonicaDAO = new TransaccionTelefoniaDAO(TransaccionTelefonia.class, PersistenceManager.instance().datastore());
        telefonicaDAO = new TelefoniaDAO(Telefonia.class, PersistenceManager.instance().datastore());
        transaccionTelefonica = new TransaccionTelefonia();
        telefonia = new Telefonia();
    }
    public void agregarSaldo() {
        try {
            this.transaccionTelefonica.setTelefonia(this.telefonia);
            this.transaccionTelefonica.setNumeroTelefono(this.telefonia.getTelefono());
            this.transaccionTelefonica.setMonto(this.monto);
            this.transaccionTelefonica.setSaldo(this.monto + this.telefonia.getSaldo());
            this.transaccionTelefonicaDAO.save(transaccionTelefonica);
            System.out.println("Saldo Agregado");
            
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "La Factura ha sido guardada correctamente"));
        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo guardar la factura" + e.getMessage()));
            success=0;
            System.out.println(e.toString());
        }
    }
    public void buscarTelefono() {
        Telefonia temp = telefonicaDAO.findOne("telefono", this.telefonia.getTelefono());
        if (temp != null) {
            this.telefonia = temp;
            System.out.println("encontrado");
            agregarSaldo();
            success=1;
        } else {
            this.telefonia.setTelefono("");
            success=0;
            System.out.println("no encontrado");
            
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se ha encontrado el cliente"));
        }
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float saldo) {
        this.monto = saldo;
    }

    public Telefonia getTelefonia() {
        return telefonia;
    }

    public void setTelefonia(Telefonia telefonia) {
        this.telefonia = telefonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
    
}
