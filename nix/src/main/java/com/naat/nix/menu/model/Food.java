package com.naat.nix.menu.model;

import com.naat.nix.menu.model.Category;
import com.naat.nix.menu.model.Cart;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name="Platillo")
public class Food {

	@Id
	@GeneratedValue
	@Column(name="id_platillo")
	private int idPlatillo;

	@Column(name="precio")
	private int precio;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="foto")
	private Blob foto;

	@Column(name="nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name="categoria")
	private Category categoria;

	@ManyToMany(mappedBy="platillos")
	private List<Cart> carritos;

	public Food (){
	}

	public Food (int idPlatillo,
				String nombre,
				String descripcion,
				int precio,
				Blob foto,
				Category categoria) {
	  this.idPlatillo = idPlatillo;
	  this.precio = precio;
	  this.descripcion = descripcion;
	  this.foto = foto;
	  this.nombre = nombre;
	  this.categoria = categoria;
  	}

	/* Copia el objeto de otro objeto */
  	public Food (Food f) {
  	  this.idPlatillo = f.idPlatillo;
  	  this.precio = f.precio;
  	  this.descripcion = f.descripcion;
  	  this.foto = f.foto;
  	  this.nombre = f.nombre;
  	  this.categoria = f.categoria;
  	}


		public int getIdPlatillo() {
			return this.idPlatillo;
		}

		public void setIdPlatillo (int idPlatillo) {
			this.idPlatillo = idPlatillo;
		}

  	public String getNombre() {
	  	return this.nombre;
  	}

	public int getIdCarrito() {
		return idPlatillo;
	}

	public void setIdCarrito(int idPlatillo) {
		this.idPlatillo = idPlatillo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public Category getCategoria() {
		return categoria;
	}

	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cart> getCarritos() {
		return this.carritos;
	}

	public void setCarritos (List<Cart> carritos) {
		this.carritos = carritos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + idPlatillo;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + precio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (idPlatillo != other.idPlatillo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio != other.precio)
			return false;
		return true;
	}



}
