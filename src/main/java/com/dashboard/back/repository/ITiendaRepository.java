package com.dashboard.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.back.model.Tienda;

@Repository
public interface ITiendaRepository extends JpaRepository<Tienda, Integer> {

}
