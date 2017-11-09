/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistance.miniProjet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Application class.
 *
 * @author elhor maher
 */
public class Application {

    /**
     * Attribute declaration for factory to share between methods.
     */
    private static SessionFactory factory;

    public static void main(String[] args) {
        System.out.println("JavaSE + Maven + Hibernate + MySQL : Many to Many Association");

        // Open connection  pool
        factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // new category
            Tache category_a = new Tache();
            category_a.setTitre("Cat a");
            session.save(category_a);

            // new category
            Tache category_b = new Tache();
            category_b.setTitre("Cat b");
            session.save(category_b);

            // new product
            Developpeur product_x = new Developpeur();
            product_x.setNom("Prod x");
            product_x.setPrice(456);
            product_x.getCategories().add(category_b);
            session.save(product_x);

            // new product
            Developpeur product_y = new Developpeur();
            product_y.setNom("Prod y");
            product_y.setPrice(123);
            product_y.getCategories().add(category_a);
            session.save(product_y);

            // new product
            Developpeur product_z = new Developpeur();
            product_z.setNom("Prod z");
            product_z.setPrice(789);
            product_z.getCategories().add(category_a);
            session.save(product_z);

            // new product
            Developpeur product_w = new Developpeur();
            product_w.setNom("Prod w");
            product_w.setPrice(258);
            session.save(product_w);

            // new category
            Tache category_c = new Tache();
            category_c.Developpeur("Cat c");
            category_c.getDeveloppeurs().add(product_w);
            session.save(category_c);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            //e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            session.close();
        }

        // Cleaning up connection pool
        factory.close();
    }

}