package com.naat.nix.menu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Food {
  @GeneratedValue
  @Id
  private Long id;
}