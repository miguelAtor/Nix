package com.naat.nix.order.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import com.naat.nix.menu.model.Cart;
import com.naat.nix.menu.model.CartID;
import com.naat.nix.menu.model.Food;
import com.naat.nix.order.model.Takeout;
import com.naat.nix.user.controller.ClientService;
import com.naat.nix.user.model.Client;
import com.naat.nix.user.model.DeliveryMan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TakeoutController {

    @Autowired
    private TakeoutService takeoutService;

    @Autowired
    private ClientService clientService;

    private Cart carrito;
    private Client cliente;
    private ArrayList<Food> platillos;
    private Takeout orden;
    private double precio;
    
    ArrayList<Takeout> ordenes = new ArrayList<Takeout>();
    private DeliveryMan repartidor = new DeliveryMan("r@gmail.com", "Juan", ordenes);

    public ModelAndView confirmaOrden(Cart cart) {
        ModelAndView modelAndView = new ModelAndView("OrdenarIH");
        platillos = (ArrayList<Food>) carrito.getPlatillos();
        carrito = cart;
        cliente = carrito.getCliente();
        precio = calculaPrecio();
        orden = new Takeout();
        orden.setPlatillos(platillos);
        orden.setFechaEntrega(LocalDate.now());
        orden.setPrecio(precio);
        orden.setComprador(cliente);
        orden.setRepartidor(repartidor);
        takeoutService.guardar(orden);
        modelAndView.addObject("platillos", platillos);
        modelAndView.addObject("precio", precio);
        modelAndView.addObject("repartidor", repartidor);
        return modelAndView;
    }

    private double calculaPrecio() {
        double total = 0;
        for (Food f:this.platillos) {
            total+=f.getPrecio();
        }
        return total;
    }
}