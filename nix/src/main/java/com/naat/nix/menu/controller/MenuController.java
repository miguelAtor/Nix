package com.naat.nix.menu.controller;

import java.util.ArrayList;

import com.naat.nix.menu.model.Category;
import com.naat.nix.menu.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/VerMenuIH")
public class MenuController {

    @Autowired
    MenuService menuService;

    ArrayList<Category> categorias;
    ArrayList<Food> platillos;

    @GetMapping
    public String obtenPlatillos(Model model) {
        platillos = menuService.obtenPlatillos();
        model.addAttribute("platillos", platillos);
        return "VerMenuIH";
    }

    @GetMapping
    public String obtenCategorias(Model model) {
        categorias = menuService.obtenCategorias();
        model.addAttribute("categorias", categorias);
        return "VerMenuIH";
    }
    
    @GetMapping
    public String verCategoria(Model model, @PathVariable("nombre") String nombre) {
        Category categoria = menuService.obtenCategoria(nombre);
        platillos = platillosCategoria(categoria);
        model.addAttribute("platillos", platillos);
		return "redirect:/VerMenuIH";        
    }

    private ArrayList<Food> platillosCategoria(Category categoria) {
        return (ArrayList<Food>) categoria.getFoods();
    }
}