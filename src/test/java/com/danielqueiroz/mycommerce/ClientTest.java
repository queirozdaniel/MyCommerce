package com.danielqueiroz.mycommerce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.danielqueiroz.mycommerce.model.Client;

public class ClientTest extends EntityManagerTest{

	@Test
	public void createClient() {
		Client client = new Client();
		client.setId(2L);
		client.setName("Luana Silva");
		
		entityManager.persist(client);
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		Assertions.assertEquals("Luana Silva", client.getName());
	}
	
	@Test
	public void readClient() {
		Client client = entityManager.find(Client.class, 1L);

		Assertions.assertEquals("Daniel Queiroz", client.getName());
	}
	
	@Test
	public void updateClient() {
		Client client = entityManager.find(Client.class, 3L);
		client.setName("Luiz Ricardo da Silva");
		
		entityManager.merge(client);
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		Client checked = entityManager.find(Client.class, 3L);
		Assertions.assertEquals("Luiz Ricardo da Silva", checked.getName());
	}
	
	@Test
	public void deleteClient() {
		Client client = entityManager.find(Client.class, 4L);
		
		entityManager.getTransaction().begin();
		entityManager.remove(client);
		entityManager.getTransaction().commit();
		
		Client checked = entityManager.find(Client.class, client.getId());
		Assertions.assertNull(checked);
	}
	
}
