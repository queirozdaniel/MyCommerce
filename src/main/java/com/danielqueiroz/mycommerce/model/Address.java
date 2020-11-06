package com.danielqueiroz.mycommerce.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

	@Column(name = "zip_code")
	private String zipCode;
	
	private String city;
	
	private String state;
	
	private String place;
	
	@Column(name = "place_number")
	private String placeNumber;
	
	private String neighborhood;
	
	private String complement;
	
}
