package com.naat.nix.order.controller;

import com.naat.nix.order.model.Takeout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakeoutService {

    @Autowired
    private TakeoutRepository takeoutRepository;

    /**
     * Guarda una orden en la base de datos
     * @param orden Orden a guardar
     */
    public void guardar(Takeout orden) {
        takeoutRepository.save(orden);
    }
}