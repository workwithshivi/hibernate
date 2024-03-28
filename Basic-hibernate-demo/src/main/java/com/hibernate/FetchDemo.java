package com.hibernate;

import com.hibernate.model.Address;
import com.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        /*
            Two way to fetch data from db
            1. session.get(entity class, id): return null if no id found, use if you are not sure about id availability
            2. session.load(entity class, id): throw ObjectNotFoundException  if no id found, use if you sure about id availability
        */

        //1. Get
        Student st = session.get(Student.class, 1);
        System.out.println(st);
        //this second call will not hit db as Student id 1 is already saved in session cache
        session.get(Student.class, 1);
        // if we clear the cache and call get() again than only DB will get a hit
        session.clear();
        session.get(Student.class, 1);

        // 2. load()
        Address ad = session.load(Address.class, 1);
       /*
        lazy initialization: load() returns a proxy object and will not hit the db until any
        method other than getId() is called, this will increase the performance
        */

        //no hit on db
        System.out.println(ad.getAddressId());
        //db hit
        System.out.println(ad.getCity());

        session.close();
    }
}
