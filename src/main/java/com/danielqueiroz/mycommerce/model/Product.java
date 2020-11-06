package com.danielqueiroz.mycommerce.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "product")
public class Product {

	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	
}
