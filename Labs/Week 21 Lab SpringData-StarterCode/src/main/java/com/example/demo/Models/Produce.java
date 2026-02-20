package com.example.demo.Models;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Produce")
public class Produce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "produce")
	private Collection<SellerProduce> sellerProduces;

	public Produce() {
		super();
	}

	public Produce(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<SellerProduce> getSellerProduces() {
		return sellerProduces;
	}

	public void setSellerProduces(Collection<SellerProduce> sellerProduces) {
		this.sellerProduces = sellerProduces;
	}
}
