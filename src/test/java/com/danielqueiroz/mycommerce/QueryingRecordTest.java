package com.danielqueiroz.mycommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.danielqueiroz.mycommerce.model.Product;

public class QueryingRecordTest {

	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@BeforeAll
	public static void setupBeforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
	}

	@AfterAll
	public static void tearDownAfterClass() {
		entityManagerFactory.close();
	}

	@BeforeEach
	public void setUp() {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@AfterEach
	public void tearDown() {
		entityManager.close();
	}
	
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
