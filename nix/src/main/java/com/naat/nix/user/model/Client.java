package com.naat.nix.user.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.naat.nix.menu.model.Cart;
import com.naat.nix.order.model.Takeout;

import lombok.Data;

@Data
@Entity
public class Client {
  @Id
  private String correo;

  @Column(name="nombre")
  private String nombre;

  @OneToMany(mappedBy="comprador")
  private List<Takeout> ordenes;

  @OneToOne
  @JoinColumn(name="carrito")
  private Cart carrito;

  public Client() {}

  public Client(String correo, String nombre, List<Takeout> ordenes, Cart carrito) {
    this.correo = correo;
    this.nombre = nombre;
    this.ordenes = ordenes;
    this.carrito = carrito;
  }

}