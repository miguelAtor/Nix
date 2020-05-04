package com.naat.nix.menu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.naat.nix.order.model.Takeout;

import lombok.Data;

@Data
@Entity
public class Food {
  @GeneratedValue
  @Id
  private int id;

  @Column(name="precio")
	private double precio;

  @Column(name="descripcion")
	private String descripcion;

	@Column(name="nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name="categoria") 
  private Category categoria;

  @ManyToMany(mappedBy="platillos")
	private List<Cart> carritos;

  @ManyToMany(mappedBy="platillos")
  private List<Takeout> ordenes;

  public Food() {}

  public Food(int id, double precio, String descripcion, Category categoria) {
    this.id = id;
    this.precio = precio;
    this.descripcion = descripcion;
    this.categoria = categoria;
  }

public double getPrecio() {
	return this.precio;
}
}