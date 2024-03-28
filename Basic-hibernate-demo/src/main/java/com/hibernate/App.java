package com.hibernate;

import com.hibernate.model.Address;
import com.hibernate.model.Certificate;
import com.hibernate.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) {

        try {
            Configuration cfg = new Configuration();
            cfg.configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();

            Student st = new Student();

            st.setName("Ram");
            st.setCity("Ayodhya");
            Certificate certificate=new Certificate("Java","3 months");
            st.setCertificate(certificate);
            System.out.println(st);


            // creating object for address

            Address ad = new Address();
            ad.setStreet("street 1");
            ad.setCity("City 1");
            ad.setOpen(true);
            ad.setAddedDate(new Date());
            ad.setX(100.67);
            // reading image
            FileInputStream fis = new FileInputStream("/Users/shivampunia/dev/repo/JavaRepo/Hibernate/hibernate/basic-hibernate-demo/src/main/resources/river.png");
            byte[] data = new byte[fis.available()];
            fis.read(data);
            ad.setImage(data);

            Transaction tx = session.beginTransaction();
            session.save(st);
            session.save(ad);
            tx.commit();

            fis.close();
            session.close();
        } catch (HibernateException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
