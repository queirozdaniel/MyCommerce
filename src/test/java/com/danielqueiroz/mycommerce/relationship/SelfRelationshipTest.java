package com.danielqueiroz.mycommerce.relationship;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelfRelationshipTest extends EntityManagerTest {

    @Test
    public void checkRelationship(){
        Category categoryFather = new Category();
        categoryFather.setName("Eletronicos");

        Category category = new Category();
        category.setName("Smartphone");
        category.setCategoryFather(categoryFather);

        entityManager.getTransaction().begin();
        entityManager.persist(categoryFather);
        entityManager.persist(category);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Category categoryNew = entityManager.find(Category.class, category.getId());
        Assertions.assertNotNull(categoryNew.getCategoryFather());

        Category categoryFatherNew = entityManager.find(Category.class, categoryFather.getId());
        Assertions.assertFalse(categoryFatherNew.getCategories().isEmpty());

    }

}
