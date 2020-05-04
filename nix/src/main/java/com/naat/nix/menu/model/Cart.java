package com.naat.nix.menu.model;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
public class Cart {
  
  @EmbeddedId
	private CartID cartId;

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

  public CartID getCartId() {
    return this.cartId;
  }
}