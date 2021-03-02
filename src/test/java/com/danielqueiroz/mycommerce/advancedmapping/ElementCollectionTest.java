package com.danielqueiroz.mycommerce.advancedmapping;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Attribute;
import com.danielqueiroz.mycommerce.model.Client;
import com.danielqueiroz.mycommerce.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class ElementCollectionTest extends EntityManagerTest {

    @Test
    public void applyTags() {
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1L);
        product.setTags(Arrays.asList("ebook", "livro-digital"));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Product productNew = entityManager.find(Product.class, product.getId());
        Assertions.assertFalse(productNew.getTags().isEmpty());
    }

    @Test
    public void applyAttributes() {
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1L);
        product.setAttributes(Arrays.asList(new Attribute("tela", "320x600")));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Product productNew = entityManager.find(Product.class, product.getId());
        Assertions.assertFalse(productNew.getAttributes().isEmpty());
    }

    @Test
    public void applyContacts() {
        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 1L);
        client.setContacts(Collections.singletonMap("email", "daniel@email.com"));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientNew = entityManager.find(Client.class, client.getId());
        Assertions.assertEquals(
                "daniel@email.com", clientNew.getContacts().get("email"));
    }
}
