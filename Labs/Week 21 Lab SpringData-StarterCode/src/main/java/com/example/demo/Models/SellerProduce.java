package com.example.demo.Models;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Seller_Produce")
public class SellerProduce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id", nullable = false)
	private User seller;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produce_id", nullable = false)
	private Produce produce;

	@Column(nullable = false)
	private Integer quantity;

	@Column(nullable = false)
	private Float price;

	@OneToMany(mappedBy = "sellerProduce")
	private Collection<OrderedItem> orderedItems;

	public SellerProduce() {
		super();
	}

	public SellerProduce(User seller, Produce produce, Integer quantity, Float price) {
		super();
		this.seller = seller;
		this.produce = produce;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Produce getProduce() {
		return produce;
	}

	public void setProduce(Produce produce) {
		this.produce = produce;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}


	public Collection<OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(Collection<OrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
}
