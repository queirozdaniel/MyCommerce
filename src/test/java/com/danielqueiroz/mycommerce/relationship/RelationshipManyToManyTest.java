package com.danielqueiroz.mycommerce.relationship;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class RelationshipManyToManyTest extends EntityManagerTest {

    @Test
    public void checkRelationship(){
        Product product = entityManager.find(Product.class, 1L);
        Category category = entityManager.find(Category.class, 1L);

        entityManager.getTransaction().begin();
        product.setCategories(Arrays.asList(category));
        entityManager.getTransaction().commit();

        entityManager.clear();

        Category categoryNew = entityManager.find(Category.class, category.getId());
        Assertions.assertFalse(categoryNew.getProducts().isEmpty());
    }



}
