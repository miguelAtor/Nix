package com.naat.nix.order.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.naat.nix.menu.model.Food;
import com.naat.nix.user.model.Client;
import com.naat.nix.user.model.DeliveryMan;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

/**
 * Class representing a takeout food order.
 * @version 1.0
 */
@Data
@Entity
public class Takeout {
  /**
   * Generated key column.
   */
  @GeneratedValue
  @Id
  private Long id;

  /**
   * Order's date. Assuming a order is fullfillied in one day.
   */
  @CreationTimestamp
  private LocalDate delivery_date;

  /**
   * Order status.
   */
  @Enumerated(EnumType.STRING)
  private DeliveryStatus status = DeliveryStatus.READY;

  /**
   * Food in the order.
   */
  @ManyToMany
  @JoinTable(
    name="takeout_contains_food",
    joinColumns = @JoinColumn(name="takeout_id"),
    inverseJoinColumns = @JoinColumn(name="food_id")
  )
  private List<Food> foos_items;

  /**
   * Person who bought the order.
   */
  @ManyToOne
  @JoinColumn(name="cliend_id")
  private Client client;

  /**
   * Person in charge of the deliverying.
   */
  @ManyToOne
  @JoinColumn(name="delivery_man_id")
  private DeliveryMan deliveryMan;
}