package com.naat.nix.menu.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import com.naat.nix.menu.model.Category;
import com.naat.nix.menu.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    ArrayList<Category> categorias;
    ArrayList<Food> platillos;

    public ModelAndView verMenu() {
		ModelAndView modelAndView = new ModelAndView("VerMenuIH");
		categorias = menuService.obtenCategorias();
		platillos = menuService.obtenPlatillos();
        modelAndView.addObject("menu", platillos);
        modelAndView.addObject("categorias", categorias);
		return modelAndView;
    }
    
    @RequestMapping( value = "/ver/{nombre}")
    public ModelAndView verCategoria(@PathVariable("nombre") String nombre) {
        ModelAndView modelAndView = new ModelAndView("VerMenuIH");
        Category categoria = menuService.obtenCategoria(nombre);
        platillos = platillosCategoria(categoria);
        modelAndView.addObject("menu", platillos);
        modelAndView.addObject("categorias", categorias);
		return modelAndView;        
    }

    private ArrayList<Food> platillosCategoria(Category categoria) {
        return (ArrayList<Food>) categoria.getFoods();
    }
}