/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.telefonica.test;

import com.teamj.distribuidas.telefonica.Beans.TelefoniaBean;
import com.teamj.distribuidas.telefonica.Beans.TransaccionTelefoniaBean;

/**
 *
 * @author Dennys
 */
public class Test {
    public static void main(String args[])
    {
//        TelefoniaBean telefoniaBan = new TelefoniaBean();
//        telefoniaBan.getTelefonia().setSaldo(Float.parseFloat("30.00"));
//        telefoniaBan.getTelefonia().setTelefono("0995615271");
//        telefoniaBan.agregarTelefono();
        TransaccionTelefoniaBean ttb = new TransaccionTelefoniaBean();
        ttb.getTelefonia().setTelefono("0987213792");
        ttb.setMonto(Float.parseFloat("20"));
        ttb.buscarTelefono();
        //ttb.agregarSaldo();
    }
}
