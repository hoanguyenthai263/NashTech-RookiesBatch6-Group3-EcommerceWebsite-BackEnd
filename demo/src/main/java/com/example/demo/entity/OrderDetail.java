package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail_tbl")
public class OrderDetail {
	@Id
	@Type(type = "org.hibernate.type.UUIDCharType")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, unique = true, nullable = false)
	private UUID id;

	@Column(name = "product", columnDefinition = "VARCHAR(255)", insertable = true, updatable = true, unique = false, nullable = false)
	private String product;
	@Column(name = "price", columnDefinition = "INTEGER DEFAULT 0", insertable = true, updatable = true, unique = false, nullable = false)
	private Long price;
	@Column(name = "quantity", columnDefinition = "INTEGER DEFAULT 1", insertable = true, updatable = true, unique = false, nullable = false)
	private Integer quantity;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "id", insertable = true, updatable = true, unique = false, nullable = false)
	private Order order;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "id", insertable = true, updatable = true, unique = false, nullable = false)
	private Product product_id;
}
