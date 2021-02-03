package com.danielqueiroz.mycommerce.relationship;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Client;
import com.danielqueiroz.mycommerce.model.Order;
import com.danielqueiroz.mycommerce.model.OrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelationshipManyToOneTest extends EntityManagerTest {

    @Test
    public void checkRelationship(){
        Client client = entityManager.find(Client.class, 1L);

        Order order = new Order();
        order.setStatus(OrderStatus.WAITING);
        order.setRequestDate(LocalDateTime.now());
        order.setTotal(BigDecimal.TEN);

        order.setClient(client);

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderNew = entityManager.find(Order.class, order.getId());
        Assertions.assertNotNull(orderNew.getClient());
    }

}
