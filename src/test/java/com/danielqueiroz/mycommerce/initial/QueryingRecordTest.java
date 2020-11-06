package com.danielqueiroz.mycommerce.initial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Product;

public class QueryingRecordTest extends EntityManagerTest{

	@Test
	public void findProductById() {
		Product product = entityManager.find(Product.class, 1L);
//		Product product = entityManager.getReference(Product.class, 1L);

		Assertions.assertNotNull(product);
		Assertions.assertEquals("Kindle", product.getName());
	}
	
	@Test
	public void updateReference() {
		Product product = entityManager.find(Product.class, 1L);
		product.setName("Microfone");
		
		entityManager.refresh(product);
		Assertions.assertEquals("Kindle", product.getName());
	}
	
	
}
