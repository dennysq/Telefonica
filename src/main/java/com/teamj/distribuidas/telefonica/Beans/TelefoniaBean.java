/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.telefonica.Beans;

import com.teamj.distribuidas.telefonica.DAO.TelefoniaDAO;
import com.teamj.distribuidas.telefonica.model.Telefonia;
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
public class TelefoniaBean {
    TelefoniaDAO telefoniaDAO;
    private Telefonia telefonia;

    public Telefonia getTelefonia() {
        return telefonia;
    }

    public void setTelefonia(Telefonia telefonia) {
        this.telefonia = telefonia;
    }
    public TelefoniaBean()
    {
        telefoniaDAO = new TelefoniaDAO(Telefonia.class, PersistenceManager.instance().datastore());
        telefonia = new Telefonia();
    }
    public void agregarTelefono() {

        try {
            Telefonia temp = this.telefoniaDAO.findOne("telefono", this.telefonia.getTelefono());
            if (temp == null) {
                this.telefoniaDAO.save(telefonia);
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El  nuevo cliente ha sido registrado"));
                this.telefonia = new Telefonia();
            } else {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Un cliente ya ha sido registrado con esa identificacion"));

            }
        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El  nuevo cliente no se pudo registrar"));
            System.out.println("" + e);
        }

    }
}
