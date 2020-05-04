package com.naat.nix.user.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.naat.nix.order.model.Takeout;

import lombok.Data;

@Data
@Entity
public class DeliveryMan {
  @Id
  private String correo;

  @Column(name="nombre")
  private String nombre;

  @OneToMany(mappedBy="repartidor")
  private List<Takeout> ordenes; 

  public DeliveryMan() {}

  public DeliveryMan(String correo, String nombre, List<Takeout> ordenes) {
    this.nombre = nombre;
    this.correo = correo;
    this.ordenes = ordenes;
  }
}