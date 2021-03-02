package com.danielqueiroz.mycommerce.advancedmapping;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class MapsIdTest extends EntityManagerTest {

    @Test
    public void insertPayment(){

        Order order = entityManager.find(Order.class, 1L);

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setXml(new byte[]{0001});
        invoice.setIssuanceDate(new Date());

        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Invoice invoiceNew = entityManager.find(Invoice.class, invoice.getId());
        Assertions.assertNotNull(invoiceNew);
        Assertions.assertEquals(order.getId(), invoice.getId());

    }

    @Test
    public void insertOrderedItem(){
        Client client = entityManager.find(Client.class, 1L);
        Product product = entityManager.find(Product.class, 1L);

        Order order = new Order();
        order.setClient(client);
        order.setStatus(OrderStatus.WAITING);
        order.setRequestDate(LocalDateTime.now());
        order.setTotal(product.getPrice());

        OrderedItem orderedItem = new OrderedItem();
        orderedItem.setId(new OrderedItemID());
        orderedItem.setOrder(order);
        orderedItem.setProduct(product);
        orderedItem.setPriceProduct(product.getPrice());
        orderedItem.setAmount(1);

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.persist(orderedItem);
        entityManager.getTransaction().commit();

        entityManager.clear();

        OrderedItem orderedItemNew = entityManager.find(OrderedItem.class, new OrderedItemID(order.getId(), product.getId()));
        Assertions.assertNotNull(orderedItemNew);
    }


}
