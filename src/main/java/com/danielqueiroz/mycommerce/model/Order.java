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
@Table(name = "`order`")
public class Order {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Column(name = "request_date")
	private LocalDateTime requestDate;
	
	@Column(name = "completion_date")
	private LocalDateTime completionDate;
	
	@Column(name = "invoice_id")
	private Long invoiceId;
	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Embedded
	private Address deliveryAddress;

	@OneToMany(mappedBy = "product")
	private List<OrderedItem> orderedItems;

}
