/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao;

import org.hibernate.Session;

/**
 *
 * @author Ranga Lankathilaka
 */
public interface SuperDao {
    void setSession(Session session);
}
