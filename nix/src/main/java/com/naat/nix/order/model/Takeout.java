package com.naat.nix.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Takeout {
  @GeneratedValue
  @Id
  private Long id;
}