package com.example.demo.Models;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
    @Column(nullable = false, updatable = false)
	@CreatedDate
	private Date Date;
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="buyer")
    private User buyer;
    
    @OneToMany(mappedBy = "order")
    private Collection<OrderedItem> orderedItems;


    public Order() {
    }


    public Order(User buyer) {
        this.buyer = buyer;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return Date;
    }


    public void setDate(Date date) {
        Date = date;
    }


    public User getBuyer() {
        return buyer;
    }


    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Collection<OrderedItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Collection<OrderedItem> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
