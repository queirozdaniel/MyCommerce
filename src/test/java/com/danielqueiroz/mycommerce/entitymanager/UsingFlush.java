package com.danielqueiroz.mycommerce.entitymanager;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Order;
import com.danielqueiroz.mycommerce.model.OrderStatus;
import org.junit.Test;

public class UsingFlush extends EntityManagerTest {

    @Test(expected = Exception.class)
    public void callFlush(){
        try {
            entityManager.getTransaction().begin();

            Order order = entityManager.find(Order.class, 1L);
            order.setStatus(OrderStatus.PAID);

            // Force Sync, memory and DB
            entityManager.flush();

            if (order.getPaymentCard() == null){
                throw new RuntimeException("Order doesn't Unpaid Order");
            }

        } catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }

    }

}
