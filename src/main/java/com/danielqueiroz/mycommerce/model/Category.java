package com.danielqueiroz.mycommerce.model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "category",
		uniqueConstraints = {@UniqueConstraint(name = {"unq_name"}, columnNames = {"name"})},
		indexes = {@Index(name = "idx_name", columnList = "name")})
public class Category {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToOne
	@JoinColumn(name = "category_father_id")
	private Category categoryFather;

	@OneToMany(mappedBy = "categoryFather")
	private List<Category> categories;

	@ManyToMany(mappedBy = "categories")
	private List<Product> products;
}
