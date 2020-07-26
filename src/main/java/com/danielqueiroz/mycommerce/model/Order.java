package com.danielqueiroz.mycommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Order {

	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private LocalDateTime  requestDate;
	private LocalDateTime  completionDate;
	private Long invoiceId;
	private BigDecimal total;
	private OrderStatus status;
	
}
