package com.danielqueiroz.mycommerce.model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("card")
@Table(name = "payment_card")
public class PaymentCard extends Payment{

	@Column(name = "card_number", length = 50)
	private String cardNumber;
	
}
