package com.danielqueiroz.mycommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "category")
public class Category {

	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private String name;
	
	@Column(name = "category_father_id")
	private Long fatherId;
}
