package com.dashboard.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.back.model.Venta_encabezado;

@Repository
public interface IVentasEncabezado extends JpaRepository<Venta_encabezado, Integer>{

}
