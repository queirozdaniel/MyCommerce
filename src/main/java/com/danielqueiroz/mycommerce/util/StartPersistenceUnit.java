package com.danielqueiroz.mycommerce.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.danielqueiroz.mycommerce.model.Product;

public class StartPersistenceUnit {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Product produto = entityManager.find(Product.class, 1L);
        System.out.println(produto.getName());

        entityManager.close();
        entityManagerFactory.close();
		
	}

}
