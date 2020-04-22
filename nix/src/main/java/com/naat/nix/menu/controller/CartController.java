package com.naat.nix.menu.controller;

import com.naat.nix.menu.controller.CartService;
import com.naat.nix.menu.model.Food;
import com.naat.nix.menu.model.Cart;
import com.naat.nix.menu.model.CartID;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
* Controlador encargado de la lectura, manipulacion de platillos del carrito
*/
@Controller
@RequestMapping(value = "/carrito")
public class CartController {

	/* El servicio */
	@Autowired
	CartService service;

	/* Referencia al carrito actual */
	Cart carrito;

	/* Identificador del usuario actual (Solo de prueba por el momento) */
	CartID carIdTest = new CartID (1, "m@ciencias.unam.mx");


	/**
	* Solicitud para ver el carrito.
	* Obtiene el carrito de la base de datos, lo referencia
	* a la variable 'carrito' y carga sus platillos.
	* en la vista VerCarritoIH.html.
	**/
	@RequestMapping( value = "/ver", method = RequestMethod.GET )
	public ModelAndView verCarrito() {
		ModelAndView modelAndView = new ModelAndView("VerCarritoIH");
		carrito = service.obtenerCarritoId(carIdTest);
		ArrayList<Food> platillos = new ArrayList<Food>(carrito.getPlatillos());
		modelAndView.addObject("carrito", platillos);
		return modelAndView;
	}


	/**
	* Solicitud para editar el carrito.
	* Carga los platillos del carrito en la vista EliminarCarritoIH
	*/
	@RequestMapping( value = "/editar", method = RequestMethod.GET)
	public ModelAndView editarCarrito() {
		ModelAndView modelAndView = new ModelAndView("EliminarCarritoIH");
		ArrayList<Food> platillos = new ArrayList<Food>(carrito.getPlatillos());
		modelAndView.addObject("carrito", platillos);
		return modelAndView;
	}

	/**
	* Solicitud para descartar un platillo.
	* Elimina el platillo del carrito.
	* @param nombre el nombre del platillo a descartar
	*/
	@RequestMapping( value = "/editar/{nombre}")
	public String descartar(@PathVariable("nombre") String nombre) {
		carrito.eliminar(nombre);
		return "redirect:/carrito/editar";
	}

	/**
	* Solicitud para eliminar los platillos descartados del carrito.
	* Actualiza en la base de datos el carrito actual.
	*/
	@RequestMapping( value = "/eliminar")
	public String eliminar() {
		service.actualizar(carrito);
		return "redirect:/carrito/ver";
	}

}
