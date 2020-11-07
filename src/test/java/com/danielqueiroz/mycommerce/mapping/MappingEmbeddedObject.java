package com.danielqueiroz.mycommerce.mapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.danielqueiroz.mycommerce.EntityManagerTest;
import com.danielqueiroz.mycommerce.model.Address;
import com.danielqueiroz.mycommerce.model.Order;
import com.danielqueiroz.mycommerce.model.OrderStatus;

public class MappingEmbeddedObject extends EntityManagerTest{

	@Test
	public void analyzingMappingEmbeddedObject() {
		
		Address address = new Address();
		address.setZipCode("00000-000");
		address.setCity("Londrina");
		address.setPlace("Rua 1");
		address.setPlaceNumber("12");
		address.setNeighborhood("Centro");
		address.setState("PR");
		address.setComplement("--");
		
		Order order = new Order();
//		order.setId(1L);
		order.setRequestDate(LocalDateTime.now());
		order.setStatus(OrderStatus.WAITING);
		order.setTotal(new BigDecimal(200));
		order.setDeliveryAddress(address);
		
		entityManager.getTransaction().begin();;
		entityManager.persist(order);
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		Order orderChecked = entityManager.find(Order.class, order.getId());
	
		Assertions.assertNotNull(orderChecked);
		Assertions.assertNotNull(orderChecked.getDeliveryAddress());
		
	}
	
	
}
