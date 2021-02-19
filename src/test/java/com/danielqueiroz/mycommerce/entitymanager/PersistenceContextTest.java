package com.danielqueiroz.mycommerce.entitymanager;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PersistenceContextTest extends EntityManagerTest {

    // PC = Persistence Context
    @Test
    public void usePersistenceContext(){
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1L);
        product.setPrice(new BigDecimal(100.0));

        // Product1 is out PC
        Product product1 = new Product();
        product1.setName("Canecá");
        product1.setPrice(new BigDecimal(15.0));
        product1.setDescription("Uma caneca simples, ótima para tomar café");
        entityManager.persist(product1); // Product1 is added to PC

        entityManager.flush();

        product1.setDescription("Uma caneca limpa"); // As Product was in PC, this line do a update

        entityManager.getTransaction().commit();
    }

}
