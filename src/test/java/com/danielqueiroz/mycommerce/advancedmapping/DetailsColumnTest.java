package com.danielqueiroz.mycommerce.advancedmapping;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DetailsColumnTest extends EntityManagerTest {

    @Test
    public void preventInsertionOnUpdateColumn() {
        Product product = new Product();
        product.setName("Teclado para smartphone");
        product.setDescription("O mais confortável");
        product.setPrice(BigDecimal.ONE);
        product.setCreationDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product productNew = entityManager.find(Product.class, product.getId());
        Assertions.assertNotNull(productNew.getCreationDate());
        Assertions.assertNull(productNew.getUpdatedDate());
    }

    @Test
    public void preventUpdateOnCreationColumn() {
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1L);
        product.setPrice(BigDecimal.TEN);
        product.setCreationDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());

        entityManager.getTransaction().commit();

        entityManager.clear();

        Product productNew = entityManager.find(Product.class, product.getId());
        Assertions.assertNotEquals(product.getCreationDate().truncatedTo(ChronoUnit.SECONDS),
                productNew.getCreationDate().truncatedTo(ChronoUnit.SECONDS));
        Assertions.assertEquals(product.getUpdatedDate().truncatedTo(ChronoUnit.SECONDS),
                productNew.getUpdatedDate().truncatedTo(ChronoUnit.SECONDS));
    }
}
