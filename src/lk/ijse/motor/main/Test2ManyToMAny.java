package lk.ijse.motor.main;

import lk.ijse.motor.entity.*;
import lk.ijse.motor.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class Test2ManyToMAny {


    public static void main(String[] args) {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();




            Customer customer=new Customer(119, "jkghjkghjk", 7867, "ghjk");

            Invoice invoice=new Invoice(3,"hbhgjkg", customer);
            session.persist(invoice);

            Part part1=new Part(118,"hjhkh", 32, 23, 3, "jghj");
            Part part2=new Part(119,"hjhkh", 32, 23, 3, "jghj");

            session.persist(part1);
            session.persist(part2);

            invoice.getInvoiceDetail().add(new InvoiceDetail("gkjhkjhj", 43, 443, 344343, 4343,invoice.getIid(),part1.getPid()));
            invoice.getInvoiceDetail().add(new InvoiceDetail("gkjhkjhj", 43, 443, 344343, 4343,invoice.getIid(),part2.getPid()));

            session.persist(invoice);


            session.getTransaction().commit();

        }

        sessionFactory.close();










    }



}
