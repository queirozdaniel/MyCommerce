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
@Table(name = "client")
public class Client {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ElementCollection
	@CollectionTable(name = "client_contact",
			joinColumns = @JoinColumn(name = "client_id"))
	@MapKeyColumn(name = "type")
	@Column(name = "description")
	private Map<String, String> contacts;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToMany(mappedBy = "client")
	private List<Order> orders;

}
