package com.danielqueiroz.mycommerce.relationship;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.*;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class RelationshipOneToOneTest extends EntityManagerTest {

    @Test
    public void checkRelationship(){
        Order order = entityManager.find(Order.class, 1L);

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardNumber("12344");
        paymentCard.setStatus(PaymentStatus.PROCESSING);
        paymentCard.setOrder(order);

        entityManager.getTransaction().begin();
        entityManager.persist(paymentCard);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderNew = entityManager.find(Order.class, 1L);
        Assertions.assertNotNull(orderNew.getPaymentCard());
    }

    @Test
    public void checkRelationshipOrderIncoice(){
        Order order = entityManager.find(Order.class, 1L);

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setIssuanceDate(new Date());
        invoice.setXml("Test");

        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderNew = entityManager.find(Order.class, 1L);
        Assertions.assertNotNull(orderNew.getInvoice());
    }



}
