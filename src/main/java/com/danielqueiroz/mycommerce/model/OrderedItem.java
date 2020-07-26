package com.danielqueiroz.mycommerce.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class OrderedItem {

	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private Long orderId;
	private Long productId;
	private BigDecimal priceProduct;
	private Integer amount;
	
}
