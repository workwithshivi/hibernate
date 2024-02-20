package com.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) {

        try {
            Configuration cfg=new Configuration();
            cfg.configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();

            System.out.println(factory);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }
}
