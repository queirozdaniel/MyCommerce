package com.danielqueiroz.mycommerce.model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "client",
		uniqueConstraints = {@UniqueConstraint(name = "unq_cpf", columnNames = {"cpf"})},
		indexes = {@Index(name = "idx_name", columnList = "name")})
public class Client {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 14, nullable = false)
	private String cpf;

	@ElementCollection
	@CollectionTable(name = "client_contact",
			joinColumns = @JoinColumn(name = "client_id"))
	@MapKeyColumn(name = "type")
	@Column(name = "description")
	private Map<String, String> contacts;

	@Column(length = 30, nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToMany(mappedBy = "client")
	private List<Order> orders;

}
