package com.danielqueiroz.mycommerce.model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "payment_card")
public class PaymentCard {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(optional = false)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	@Column(name = "card_number")
	private String cardNumber;
	
}
