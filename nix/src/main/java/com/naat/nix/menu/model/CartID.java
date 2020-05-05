package com.naat.nix.menu.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

@Embeddable
public class CartID implements Serializable {

    @GeneratedValue
    @Column(name="id_carrito")
    int idCarrito;

    @OneToOne(mappedBy="carrito")
    String correo;

    public CartID() {
    }

    public CartID (int idCarrito, String correo) {
      this.idCarrito = idCarrito;
      this.correo = correo;
    }

    public int getIdCarrito() {
      return this.idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
      this.idCarrito = idCarrito;
    }

    public String getCorreo () {
      return this.correo;
    }

    public void setCorreo (String correo) {
      this.correo = correo;
    }

}