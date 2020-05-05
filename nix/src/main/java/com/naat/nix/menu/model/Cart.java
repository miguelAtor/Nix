package com.naat.nix.menu.model;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.naat.nix.user.model.Client;

import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
public class Cart {
  /**
  @EmbeddedId
  private CartID cartId;*/
  
  @Id
  private int id;

  @OneToOne(mappedBy="carrito")
  private Client cliente;

  @ManyToMany
  @JoinTable(name="Platillos", 
            joinColumns=@JoinColumn(name="cart_id"),
            inverseJoinColumns=@JoinColumn(name="food_id")
  )
  private List<Food> platillos;
  
  public Cart() {}

  public Cart(List<Food> platillos) {
    this.platillos = platillos;
  }

  public List<Food> getPlatillos() {
    return this.platillos;
  }

  public int getId() {
    return this.id;
  }

public Client getCliente() {
	return this.cliente;
}
}