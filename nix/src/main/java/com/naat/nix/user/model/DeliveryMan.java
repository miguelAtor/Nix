package com.naat.nix.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DeliveryMan {
  @Id
  private String email;
}