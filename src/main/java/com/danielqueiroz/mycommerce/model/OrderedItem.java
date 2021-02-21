package com.danielqueiroz.mycommerce.model;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ordered_item")
public class OrderedItem {
	
	@EmbeddedId
	private OrderedItemID id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;

	@Column(name = "price_product")
	private BigDecimal priceProduct;
	
	private Integer amount;
	
}
