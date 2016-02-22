/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.telefonica.EndPoint;

import com.teamj.distribuidas.telefonica.Beans.TransaccionTelefoniaBean;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedProperty;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
/**
 *
 * @author Gaming
 */
@ServerEndpoint("/endpoint")
public class WebSocketController {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    
    
    
    @OnOpen
    public void onOpen(Session s) {
        System.out.println(s.getId() + " abrió conexión");
        sessions.add(s);
        broadcastMsg("Usuario conectado: " + s.getId(), s);       
    }

    @OnClose
    public void onClose(Session s) {
        System.out.println(s.getId() + " cerró conexión");
        sessions.remove(s);
        broadcastMsg("Usuario desconectado: " + s.getId(), null); 
    }

    @OnMessage
    public void onMessage(String message, Session s) {
        System.out.println(s.getId() + " envía mensaje:" + message);
        String[] parts = message.split("a");
        System.out.println("Telefono" + parts[0]);
        System.out.println("Monto" + parts[1]);
        TransaccionTelefoniaBean ttb = new TransaccionTelefoniaBean();
        ttb.getTelefonia().setTelefono(parts[0]);
        ttb.setMonto(Float.parseFloat(parts[1]));
        ttb.buscarTelefono();
        
        broadcastMsg(String.valueOf(ttb.getSuccess()), s);
    }
    
    private void broadcastMsg(String message, Session sender) {
        for(Session sTmp : sessions){
            try {
                if(sender == sTmp) {
                    sTmp.getBasicRemote().sendText("<<<<< " + message);
                } else {
                    sTmp.getBasicRemote().sendText(">>>>> " + message);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }          
    }
    
}

