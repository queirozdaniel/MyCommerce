package com.danielqueiroz.mycommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "product",
		uniqueConstraints = {@UniqueConstraint(name = "unq_name", columnNames = {"name"})},
		indexes = {@Index(name = "idx_name", columnList = "name")})
public class Product {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "creation_date", updatable = false, nullable = false)
	private LocalDateTime creationDate;

	@Column(name = "updated_date", insertable = false)
	private LocalDateTime updatedDate;

	@Column(length = 150, nullable = false)
	private String name;

	@Lob
	private String description;

	@Column(precision = 15, scale = 2)
	private BigDecimal price;

	@Lob
	private byte[] photo;

	@ManyToMany
	@JoinTable(name = "product_category",
			joinColumns = @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_category_product")),
			inverseJoinColumns = @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_product_category_category"))
	)
	private List<Category> categories;

	@OneToOne(mappedBy = "product")
	private Stock stock;

	@ElementCollection
	@CollectionTable(name = "product_tag",
			joinColumns = @JoinColumn(name = "product_id"))
	@Column(name = "tag", length = 50, nullable = false)
	private List<String> tags;

	@ElementCollection
	@CollectionTable(name = "product_attribute",
			joinColumns = @JoinColumn(name = "product_id"))
	private List<Attribute> attributes;
	
}
