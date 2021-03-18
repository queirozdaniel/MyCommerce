package com.danielqueiroz.mycommerce.model;

import java.util.Date;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "invoice")
public class Invoice {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "order_id")
	private Long id;

	@MapsId
	@OneToOne
	@JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "fk_invoice_order"))
	private Order order;

	// Large Object
	@Lob
	@Column(nullable = false)
	private byte[] xml;
	
	@Column(name = "issuance_date", nullable = false)
	private Date issuanceDate;
	
}
