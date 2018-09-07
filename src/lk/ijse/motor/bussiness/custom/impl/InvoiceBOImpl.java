/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import java.util.ArrayList;
import lk.ijse.motor.bussiness.custom.InvoiceBO;

import lk.ijse.motor.dao.custom.InvoiceDAO;
import lk.ijse.motor.dto.InvoiceDTO;
import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.Invoice;
import lk.ijse.motor.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ranga Lankathilaka
 */

@Component
public class InvoiceBOImpl implements InvoiceBO{
    @Autowired
    InvoiceDAO invoiceDAO;
    private SessionFactory sessionFactory;
    public InvoiceBOImpl() {
        
       // invoiceDAO=(InvoiceDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.INVOICE);

        sessionFactory = HibernateUtil.getSessionFactory();
    }
    

    @Override
    public boolean save(InvoiceDTO entity) throws Exception{
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // Invoice invoice=new Invoice(0,entity.getDiscription(),entity.getCid());

        try (Session session = sessionFactory.openSession()) {

            invoiceDAO.setSession(session);
            session.beginTransaction();
            Invoice invoice = new Invoice(0,entity.getDiscription(),null);
            invoiceDAO.save(invoice);

            session.getTransaction().commit();
            return true;


        } catch (HibernateException exp) {
            return false;


        }
        
    
    
    
    }

    @Override
    public InvoiceDTO getLastIID() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Invoice lastIID = invoiceDAO.getLastIID();
//        int iid;
//
//         iid = lastIID.getIid();
//
//        return new InvoiceDTO(iid);


  return null;

        }
    
    
    
}
