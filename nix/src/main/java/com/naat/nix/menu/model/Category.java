package com.naat.nix.menu.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Category {
  @Id
  private String name;
}