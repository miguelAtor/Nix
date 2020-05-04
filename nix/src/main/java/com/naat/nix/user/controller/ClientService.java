package com.naat.nix.user.controller;

import java.util.Optional;

import com.naat.nix.user.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Obtiene un cliente de la base de datos con un id
     * @param correo Id del cliente
     * @return El cliente encontrado o null si no lo encuentra
     */
    public Client obtenClienteId(String correo) {
        Optional<Client> cliente = clientRepository.findById(correo);
        if (cliente.isPresent())
            return cliente.get();
        return null;
    }
    
}