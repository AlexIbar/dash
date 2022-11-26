package com.dashboard.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.back.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}
