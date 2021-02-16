package com.danielqueiroz.mycommerce.entitymanager;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Product;
import org.junit.jupiter.api.Test;

public class FirstLevelCache extends EntityManagerTest {

    @Test
    public void checkCache() {

        Product product = entityManager.find(Product.class, 1L);
        System.out.println(product.getName());
        System.out.println("-----------");

        // Two calls for DB
        //entityManager.clear();

        Product productNew = entityManager.find(Product.class, product.getId());
        System.out.println(productNew.getName());
        System.out.println("-----------");
    }
}
