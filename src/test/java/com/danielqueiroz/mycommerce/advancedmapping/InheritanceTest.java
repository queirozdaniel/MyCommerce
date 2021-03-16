package com.danielqueiroz.mycommerce.advancedmapping;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InheritanceTest extends EntityManagerTest {

    @Test
    public void saveClient() {
        Client client = new Client();
        client.setName("Fernanda Morais");
        client.setCpf("123456789");
        client.setGender(Gender.FEMALE);

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientNew = entityManager.find(Client.class, client.getId());
        Assertions.assertNotNull(clientNew.getId());
    }

    @Test
    public void findPayment() {
        List payments = entityManager
                .createQuery("select p from Payment p")
                .getResultList();

        Assertions.assertFalse(payments.isEmpty());
    }

    @Test
    public void insertPaymentOrder() {
        Order order = entityManager.find(Order.class, 1L);

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setOrder(order);
        paymentCard.setStatus(PaymentStatus.PROCESSING);
        paymentCard.setCardNumber("123");

        entityManager.getTransaction().begin();
        entityManager.persist(paymentCard);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderNew = entityManager.find(Order.class, order.getId());
        Assertions.assertNotNull(orderNew.getPaymentCard());
    }

}
