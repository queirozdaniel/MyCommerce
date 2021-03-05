package com.danielqueiroz.mycommerce.model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("card")
public class PaymentCard extends Payment{

	@Column(name = "card_number")
	private String cardNumber;
	
}
