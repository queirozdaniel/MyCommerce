package com.danielqueiroz.mycommerce.entitymanager;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import org.junit.jupiter.api.Test;

public class TransactionsTest extends EntityManagerTest {

    @Test
    public void checkTransaction(){
        // Init Transaction
        entityManager.getTransaction().begin();

        // Confirm Transaction
        entityManager.getTransaction().commit();

        // Cancel Transaction
        //entityManager.getTransaction().rollback();
    }

}
