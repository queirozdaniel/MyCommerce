package com.danielqueiroz.mycommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "payment_billet")
public class PaymentBillet {

	@EqualsAndHashCode.Include
	@Id
	private Long id;
	
	@Column(name = "order_id")
	private Long orderId;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	@Column(name = "bar_code")
	private String barCode;
	
}
