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

	@MapsId("orderId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "order_id")
	private Order order;

	@MapsId("productId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "price_product")
	private BigDecimal priceProduct;
	
	private Integer amount;
	
}
