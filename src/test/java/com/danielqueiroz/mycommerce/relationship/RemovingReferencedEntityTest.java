package com.danielqueiroz.mycommerce.relationship;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemovingReferencedEntityTest extends EntityManagerTest {

    @Test
    public void removingEreferencedEntity(){
        Order order = entityManager.find(Order.class, 1L);

        entityManager.getTransaction().begin();

        order.getOrderedItems().forEach(i -> entityManager.remove(i));
        entityManager.remove(order);

        entityManager.getTransaction().commit();
        entityManager.clear();

        Order orderNew = entityManager.find(Order.class, 1L);
        Assertions.assertNull(orderNew);

    }

}
