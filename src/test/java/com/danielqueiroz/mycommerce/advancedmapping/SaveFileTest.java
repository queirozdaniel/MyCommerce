package com.danielqueiroz.mycommerce.advancedmapping;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Invoice;
import com.danielqueiroz.mycommerce.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

public class SaveFileTest extends EntityManagerTest {

    @Test
    public void saveXMLInvoice(){
        Order order = entityManager.find(Order.class, 1L);

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setIssuanceDate(new Date());
        invoice.setXml(loadInvoice());

        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();

        Invoice invoiceNew = entityManager.find(Invoice.class, invoice.getId());
        Assertions.assertNotNull(invoiceNew.getXml());
        Assertions.assertTrue(invoiceNew.getXml().length > 0);
    }

    private static byte[] loadInvoice(){
        try {
            return SaveFileTest.class.getResourceAsStream("/nota-fiscal.xml").readAllBytes();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
