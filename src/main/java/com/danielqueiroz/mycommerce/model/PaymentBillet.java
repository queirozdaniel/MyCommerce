package com.danielqueiroz.mycommerce.model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("billet")
@Table(name = "payment_billet")
public class PaymentBillet extends Payment{

	@Column(name = "bar_code", length = 100, nullable = false)
	private String barCode;
	
}
