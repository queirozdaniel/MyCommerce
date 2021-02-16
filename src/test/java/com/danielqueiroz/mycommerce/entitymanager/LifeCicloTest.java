package com.danielqueiroz.mycommerce.entitymanager;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Category;
import com.danielqueiroz.mycommerce.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LifeCicloTest extends EntityManagerTest {

    /*
        Life Cicles are: Transient, Managed, Detached, Removed
     */

    @Test
    public void check(){
        // EntityManager is on Managed
        Product product = entityManager.find(Product.class, 1L);

        // Still on Managed
        Product productMerge = entityManager.merge(product);

        // EntityManager is to Removed -> to Detached or DB
        entityManager.remove(product);

        // EntityManager is Detached
        entityManager.detach(product);

        //entityManager.getTransaction().commit(); will flush/commit to DB

        //entityManager.clear();
    }



}
