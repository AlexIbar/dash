package com.dashboard.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.back.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
