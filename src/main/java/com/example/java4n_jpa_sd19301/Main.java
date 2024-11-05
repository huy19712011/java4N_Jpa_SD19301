package com.example.java4n_jpa_sd19301;

import com.example.java4n_jpa_sd19301.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Product product1 = new Product(1001, "Product A");
        Product product2 = new Product(1002, "Product B");

        em.getTransaction().begin();

        em.persist(product1);
        em.persist(product2);

        product2.setName("BB");

        em.getTransaction().commit();



        em.createQuery("select p from Product p", Product.class)
                .getResultList()
                .forEach(System.out::println);
    }
}
