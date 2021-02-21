package com.danielqueiroz.mycommerce.advancedmapping;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CompositeKeyTest extends EntityManagerTest {

    @Test
    public void insertItem() {
        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 1L);
        Product product = entityManager.find(Product.class, 1L);

        Order order = new Order();
        order.setClient(client);
        order.setRequestDate(LocalDateTime.now());
        order.setStatus(OrderStatus.WAITING);
        order.setTotal(product.getPrice());

        entityManager.persist(order);

        entityManager.flush();

        OrderedItem orderedItem = new OrderedItem();
        orderedItem.setOrderId(order.getId());
        orderedItem.setProductId(product.getId());
        orderedItem.setOrder(order);
        orderedItem.setProduct(product);
        orderedItem.setPriceProduct(product.getPrice());
        orderedItem.setAmount(1);

        entityManager.persist(orderedItem);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderNew = entityManager.find(Order.class, order.getId());
        Assertions.assertNotNull(orderNew);
        Assertions.assertNotNull(orderNew.getOrderedItems());
    }

    @Test
    public void findItem() {
        OrderedItem orderedItem = entityManager.find(
                OrderedItem.class, new OrderedItemID(1L, 1L));

        Assertions.assertNotNull(orderedItem);
    }

}
