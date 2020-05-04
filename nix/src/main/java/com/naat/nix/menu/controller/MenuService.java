package com.naat.nix.menu.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.naat.nix.menu.model.Category;
import com.naat.nix.menu.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Obtiene todos los platillos en la base de datos
     * 
     * @return Lista de platillos en la base de datos
     */
    public ArrayList<Food> obtenPlatillos() {
        final ArrayList<Food> platillos = (ArrayList<Food>) foodRepository.findAll();
        return platillos;
    }

    /**
     * Obtiene un platillo por su id
     * 
     * @param id llave del platillo en la base de datos
     * @return El platillo encontrado o null si no se encuentra
     */
    public Food obtenPlatillo(final int id) {
        final Optional<Food> platillo = foodRepository.findById((long) id);
        if (platillo.isPresent())
            return platillo.get();
        return null;
    }

    /**
     * Obtiene una lista de todas las categorías en la base de datos
     * 
     * @return Lista de categorías
     */
    public ArrayList<Category> obtenCategorias() {
        final ArrayList<Category> categorias = (ArrayList<Category>) categoryRepository.findAll();
        return categorias;
    }

    /**
     * Obtiene una categoria por su nombre
     * 
     * @param nombre Llave de la categoría en la base de datos
     * @return La categoría encontrada o null si no se encuentra
     */
    public Category obtenCategoria(String nombre) {
        Optional<Category> categoria = categoryRepository.findById(nombre);
        if (categoria.isPresent())
            return categoria.get();
        return null;
    }

}