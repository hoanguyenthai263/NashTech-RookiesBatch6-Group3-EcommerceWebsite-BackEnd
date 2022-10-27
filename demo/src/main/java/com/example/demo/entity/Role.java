package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "role_tbl")
public class Role {
	@Id
	@Type(type = "org.hibernate.type.UUIDCharType")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, unique = true, nullable = false)
	private UUID id;

	@Column(name = "role", columnDefinition = "VARCHAR(255)", insertable = true, updatable = true, unique = true, nullable = false)
	private String role;
}
