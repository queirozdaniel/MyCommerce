package com.danielqueiroz.mycommerce.entitymanager;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Client;
import com.danielqueiroz.mycommerce.model.Order;
import com.danielqueiroz.mycommerce.model.OrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CallbacksTest extends EntityManagerTest {

    @Test
    public void testingUpdateDate(){

        Client client = entityManager.find(Client.class, 1L);

        Order order = new Order();
        order.setClient(client);
        order.setTotal(BigDecimal.TEN);
        order.setRequestDate(LocalDateTime.now());
        order.setStatus(OrderStatus.WAITING);
        entityManager.getTransaction().begin();

        entityManager.persist(order);
        entityManager.flush();

        order.setStatus(OrderStatus.PAID);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderNew = entityManager.find(Order.class, order.getId());
        Assertions.assertNotNull(orderNew.getRequestDate());
        Assertions.assertNotNull(orderNew.getUpdatedRequestDate());

    }

}
