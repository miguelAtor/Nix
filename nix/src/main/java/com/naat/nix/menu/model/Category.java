package com.naat.nix.menu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Category {
  @Id
  private String name;

  @OneToMany(mappedBy="categoria")
  private List<Food> foods;

  public Category() {}

  public Category(String name) {
    this.name = name;
  }

  public List<Food> getFoods() {
    return this.foods;
  }
}