package com.danielqueiroz.mycommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PaymentBillet {

	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private Long orderId;
	private PaymentStatus status;
	private String barCode;
	
}
