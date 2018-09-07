package lk.ijse.motor.util;



import lk.ijse.motor.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory=buildSessionFactory();

     private static SessionFactory buildSessionFactory(){
         StandardServiceRegistry registry = new StandardServiceRegistryBuilder().loadProperties("application.properties").build();

         Metadata metadata = new MetadataSources( registry )
                 .addAnnotatedClass(Customer.class)
                 .addAnnotatedClass(CustomerDetail.class)
                 .addAnnotatedClass(Invoice.class)
                 .addAnnotatedClass(InvoiceDetail.class)
                 .addAnnotatedClass(Part.class)
                 .addAnnotatedClass(Vehicle.class)

                 .buildMetadata();

         return metadata.getSessionFactoryBuilder().build();

     }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
