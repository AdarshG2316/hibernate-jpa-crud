package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Create a student object (currently not setting values as we're doing retrieval/deletion)

        Student s1 =  new Student();
      /*   s1.setSname("Arjun");
         s1.setRollno(6);
         s1.setSage(22); */

        // Configure Hibernate and build SessionFactory
        SessionFactory sf = new Configuration()
                .configure() // Loads hibernate.cfg.xml
                .addAnnotatedClass(org.example.Student.class)  // Register our entity
                .buildSessionFactory();

        // Open a new session
        Session session = sf.openSession();

       Transaction transaction = session.beginTransaction();
       s1 = session.get(Student.class,6);

        // CRUD Operation Examples:
        // session.persist(s1); // Creates a new record (INSERT)

        // session.merge(s1);  // Updates existing record (UPDATE)

        session.remove(s1);    // Deletes the record (DELETE)
        transaction.commit();   // Commit the transaction
        session.close();
        sf.close();

        System.out.println(s1);
    }
}