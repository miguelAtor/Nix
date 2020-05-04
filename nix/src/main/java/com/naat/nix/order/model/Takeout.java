package com.naat.nix.order.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.naat.nix.menu.model.Food;
import com.naat.nix.user.model.Client;
import com.naat.nix.user.model.DeliveryMan;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Takeout {
  @GeneratedValue
  @Id
  private int id;

  @Column(name="fecha_de_entrega")
  @UpdateTimestamp
  private LocalDate fechaEntrega;

  @Column(name="precio")
  private double precio;

  @Column(name="estado")
  private TakeoutState estado = TakeoutState.LISTA;

  @ManyToOne
  @JoinColumn(name="comprador") 
  private Client comprador;

  @ManyToMany
  @JoinTable(
    name="food_takeout",
    joinColumns=@JoinColumn(name="takeout_id"),
    inverseJoinColumns = @JoinColumn(name = "food_id")
  )
  private List<Food> platillos;

  @ManyToOne
  @JoinColumn(name="repartidor")
  private DeliveryMan repartidor;

  public Takeout(){}

  public Takeout(int id, LocalDate fecha, double precio, TakeoutState estado,
                 Client comprador, List<Food> platillos, DeliveryMan repartidor) {
    this.id = id;
    this.fechaEntrega = fecha;
    this.precio = precio;
    this.estado = estado;
    this.comprador = comprador;
    this.platillos = platillos;
    this.repartidor = repartidor;
  }

  public void setPlatillos(ArrayList<Food> platillos) {
    this.platillos = platillos;
  }

  public void setFechaEntrega(LocalDate fecha) {
    this.fechaEntrega = fecha;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public void setComprador(Client cliente) {
    this.comprador = cliente;
  }

  public void setRepartidor(DeliveryMan repartidor) {
    this.repartidor = repartidor;
  }
  
}