package com.naat.nix.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Client {
  @Id
  private String email;
}