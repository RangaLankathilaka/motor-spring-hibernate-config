package lk.ijse.motor.main;


import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.Invoice;
import lk.ijse.motor.entity.Vehicle;
import lk.ijse.motor.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class Test {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Customer customer = new Customer(12,"Ranga",798787878, "jjj");

//            Vehicle vehicle1 = new Vehicle(66,"hjkh","hkjhkjh", customer);
//            Vehicle vehicle2 = new Vehicle(67,"hjkh","hkjhkjh", customer);

            Invoice invoice1=new Invoice(43,"ggkj",customer);
            Invoice invoice2=new Invoice(44,"ggkj",customer);


            customer.getInvoice().add(invoice1);
            customer.getInvoice().add(invoice2);

            session.persist(customer);

            session.getTransaction().commit();

        }

        sessionFactory.close();
    }
}
