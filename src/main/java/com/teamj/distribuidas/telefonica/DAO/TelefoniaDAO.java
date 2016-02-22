/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.distribuidas.telefonica.DAO;
import com.teamj.distribuidas.telefonica.model.Telefonia;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
/**
 *
 * @author Gaming
 */
public class TelefoniaDAO extends BasicDAO<Telefonia,ObjectId> {
    
    public TelefoniaDAO(Class<Telefonia> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
}
