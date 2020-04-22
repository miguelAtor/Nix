package com.naat.nix.user.controller;

import com.naat.nix.user.model.Admin;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, String>{

}