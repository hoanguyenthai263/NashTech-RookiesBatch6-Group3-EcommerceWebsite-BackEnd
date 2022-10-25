package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "address_tbl")
public class Address {
	@Id
	@Type(type = "org.hibernate.type.UUIDCharType")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, unique = true, nullable = false)
	private UUID id;

	@Column(name = "street_Address", columnDefinition = "VARCHAR(255)", insertable = true, updatable = true, unique = false, nullable = false)
	private String streetAddress;
	@Column(name = "apt_Suite_Building", columnDefinition = "VARCHAR(255)", insertable = true, updatable = true, unique = false, nullable = true)
	private String aptSuiteBuilding;
	@Column(name = "city", columnDefinition = "VARCHAR(255)", insertable = true, updatable = true, unique = false, nullable = false)
	private String city;
	@Column(name = "district", columnDefinition = "VARCHAR(255)", insertable = true, updatable = true, unique = false, nullable = false)
	private String district;
	@Column(name = "ward", columnDefinition = "VARCHAR(255)", insertable = true, updatable = true, unique = false, nullable = false)
	private String ward;
	@Column(name = "status", columnDefinition = "INTEGER DEFAULT 1", insertable = false, updatable = true, unique = false, nullable = false)
	private Integer status;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = true, updatable = true, unique = false, nullable = false)
	private User userId;

}
