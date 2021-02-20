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

	@ManyToOne(optional = false)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Column(name = "request_date")
	private LocalDateTime requestDate;

	@Column(name = "updated_request_date")
	private LocalDateTime updatedRequestDate;
	
	@Column(name = "completion_date")
	private LocalDateTime completionDate;
	
	@OneToOne(mappedBy = "order")
	private Invoice invoice;

	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Embedded
	private Address deliveryAddress;

	@OneToOne(mappedBy = "order")
	private PaymentCard paymentCard;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<OrderedItem> orderedItems;

	@PrePersist
	public void beingCreated(){
		requestDate = LocalDateTime.now();
		calculateTotal();
	}

	@PreUpdate
	public void updating(){
		updatedRequestDate = LocalDateTime.now();
		calculateTotal();
	}

	public void calculateTotal(){
		if (orderedItems != null){
			total = orderedItems.stream().map(OrderedItem::getPriceProduct).reduce(BigDecimal.ZERO, BigDecimal::add);
		}
	}


}
