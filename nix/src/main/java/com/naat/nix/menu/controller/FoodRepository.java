package com.naat.nix.menu.controller;

import com.naat.nix.menu.model.Food;

import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long>{

}