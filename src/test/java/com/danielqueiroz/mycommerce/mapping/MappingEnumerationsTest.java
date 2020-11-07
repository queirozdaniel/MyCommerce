package com.danielqueiroz.mycommerce.mapping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Client;
import com.danielqueiroz.mycommerce.model.Gender;

public class MappingEnumerationsTest extends EntityManagerTest {
	
	@Test
	public void testingEnum() {
		
		Client client = new Client();
//		client.setId(5L);
		client.setName("José da Silva");
		client.setGender(Gender.MALE);
		
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Client verified = entityManager.find(Client.class, client.getId());
		
		Assertions.assertNotNull(verified);
	}

}
