package com.example.java4n_jpa_sd19301.repository;

import com.example.java4n_jpa_sd19301.entity.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public ArrayList<Product> getProducts() {
        List<Product> products = em.createQuery("select p from Product p", Product.class)
                .getResultList();

        return new ArrayList<>(products);
    }

    public Product getProductById(long id) {

        return em.find(Product.class, id);
    }

    public void updateProduct(Product product) {

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

    public void addProduct(Product product) {

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    public void deleteProduct(long id) {

        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }

    //JPQL
    public List<Product> getProductsByNameOrId_2(String name, long id) {

        TypedQuery<Product> query =
                em.createQuery("SELECT p FROM Product p WHERE p.name=?1 OR p.id=?2", Product.class);
        query.setParameter(1, name);
        query.setParameter(2, id);

        return query.getResultList();
    }

    public List<Product> getProductsByNameOrId_3(String name, long id) {

        TypedQuery<Product> query =
                em.createQuery("SELECT p FROM Product p WHERE p.name=:name OR p.id=:id", Product.class);
        query.setParameter("name", name);
        query.setParameter("id", id);

        return query.getResultList();
    }

    // Native SQL
    public List<Product> getProductsByNameOrId_4(String name, long id) {

        Query query =
                em.createNativeQuery("SELECT * FROM Product p WHERE p.name=?1 OR p.id=?2", Product.class);
        query.setParameter(1, name);
        query.setParameter(2, id);

        return query.getResultList();
    }

    public List<Product> getProductsByNameOrId_5(String name, long id) {

        Query query =
                em.createNativeQuery("SELECT * FROM Product p WHERE p.name=:name OR p.id=:id", Product.class);
        query.setParameter("name", name);
        query.setParameter("id", id);

        return query.getResultList();
    }

    public List<Product> findProductsByNameContaining(String name) {

        TypedQuery<Product> query =
                em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :name", Product.class);
        query.setParameter("name", "%" + name + "%");

        return query.getResultList();
    }

}
