package com.danielqueiroz.mycommerce.advancedmapping;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Invoice;
import com.danielqueiroz.mycommerce.model.Order;
import com.danielqueiroz.mycommerce.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

public class SaveFileTest extends EntityManagerTest {

    @Test
    public void saveProductPhoto(){
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1L);
        product.setPhoto(new byte[]{01,011,101});

        entityManager.persist(product);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product productNew = entityManager.find(Product.class, 1L);
        Assertions.assertNotNull(productNew.getPhoto());
        Assertions.assertTrue(productNew.getPhoto().length > 0);
    }


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

        entityManager.clear();

        Invoice invoiceNew = entityManager.find(Invoice.class, invoice.getId());
        Assertions.assertNotNull(invoiceNew.getXml());
        Assertions.assertTrue(invoiceNew.getXml().length > 0);
    }

    private static byte[] loadPhoto(){
        return loadFile("/background.jpg");
    }

    private static byte[] loadInvoice(){
        return loadFile("/nota-fiscal.xml");
    }

    private static byte[] loadFile(String path){
        try {
            return SaveFileTest.class.getResourceAsStream(path).readAllBytes();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
