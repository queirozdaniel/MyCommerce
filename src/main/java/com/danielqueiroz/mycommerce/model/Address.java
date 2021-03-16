package com.danielqueiroz.mycommerce.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

	@Column(name = "zip_code", length = 9)
	private String zipCode;

	@Column(length = 50)
	private String city;

	@Column(length = 2)
	private String state;

	@Column(length = 100)
	private String place;
	
	@Column(name = "place_number")
	private String placeNumber;

	@Column(length = 50)
	private String neighborhood;

	@Column(length = 100)
	private String complement;
	
}
