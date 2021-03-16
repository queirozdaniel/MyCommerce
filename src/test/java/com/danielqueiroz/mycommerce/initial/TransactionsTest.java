package com.danielqueiroz.mycommerce.initial;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.danielqueiroz.mycommerce.model.OrderedItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Product;

public class TransactionsTest extends EntityManagerTest{

	@Test
	public void insertObject() {
		Product product = new Product();
//		product.setId(2L);
		product.setName("Camêra Kanon");
		product.setCreationDate(LocalDateTime.now());
		product.setDescription("A melhor qualidade para registar seus melhores momentos");
		product.setPrice(BigDecimal.valueOf(200));
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(product);
		
		entityManager.getTransaction().commit();
		
//		entityManager.flush(); if you dont use getTransaction()
		entityManager.clear();
		
		Product checked = entityManager.find(Product.class, product.getId());
		Assertions.assertNotNull(checked);
	}

	@Test
	public void removeObject() {
		Product product = entityManager.find(Product.class, 3L);
		entityManager.getTransaction().begin();
		entityManager.remove(product);
		entityManager.getTransaction().commit();
		
		Product checked = entityManager.find(Product.class, product.getId());
		Assertions.assertNull(checked);
	}
	
	@Test
	public void updateObject() {
		Product product = new Product();
//		product.setId(1L);
		product.setName("Kindle Pro");
		product.setCreationDate(LocalDateTime.now());
		product.setDescription("Conheça o novo modelo do eReader mais completo");
		product.setPrice(BigDecimal.valueOf(400));
		
		// in this update all values are updated (if you not specify, the value is null)
		Product saved = entityManager.merge(product);

		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		Product checked = entityManager.find(Product.class, saved.getId());
		Assertions.assertNotNull(checked);
		Assertions.assertEquals("Kindle Pro", checked.getName());
	}
	
	@Test
	public void updateFieldsObject() {
		Product product = entityManager.find(Product.class, 1L);
		product.setName("Kindle PaperWhite");

		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		Product checked = entityManager.find(Product.class, product.getId());
		Assertions.assertNotNull(checked);
		Assertions.assertEquals("Kindle PaperWhite", checked.getName());
	}
	
	@Test
	public void insertObjectWithMerge() {
		Product product = new Product();
		//product.setId(3L);
		product.setName("Microfone Elgato");
		product.setCreationDate(LocalDateTime.now());
		product.setDescription("A melhor captuara e qualidade para sua voz");
		product.setPrice(BigDecimal.valueOf(600));
		
		entityManager.getTransaction().begin();
		Product saved = entityManager.merge(product);
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		Product checked = entityManager.find(Product.class, saved.getId());
		Assertions.assertNotNull(checked);
	}
	
}
