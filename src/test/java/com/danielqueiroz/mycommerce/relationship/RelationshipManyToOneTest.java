package com.danielqueiroz.mycommerce.relationship;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelationshipManyToOneTest extends EntityManagerTest {

    @Test
    public void checkRelationship() {
        Client client = entityManager.find(Client.class, 1L);
        client.setCpf("978151354");
        client.setGender(Gender.MALE);

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


    @Test
    public void checkRelationshipOrderedItem() {
        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 1L);
        Product product = entityManager.find(Product.class, 1L);

        Order order = new Order();
        order.setStatus(OrderStatus.WAITING);
        order.setRequestDate(LocalDateTime.now());
        order.setTotal(BigDecimal.TEN);
        order.setClient(client);

        entityManager.persist(order);
        entityManager.flush();

        OrderedItem orderedItem = new OrderedItem();
        //orderedItem.setOrderId(order.getId());  Used for IdClass
        //orderedItem.setProductId(product.getId());
        orderedItem.setId(new OrderedItemID(order.getId(), product.getId()));
        orderedItem.setPriceProduct(product.getPrice());
        orderedItem.setAmount(1);
        orderedItem.setOrder(order);
        orderedItem.setProduct(product);

        entityManager.persist(orderedItem);
        entityManager.getTransaction().commit();

        entityManager.clear();

        OrderedItem orderItemNew = entityManager.find(OrderedItem.class, new OrderedItemID(order.getId(), product.getId()));
        Assertions.assertNotNull(orderItemNew.getProduct());
        Assertions.assertNotNull(orderItemNew.getOrder());

    }

}
