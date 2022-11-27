package com.dashboard.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.back.model.Venta_cuerpo;

@Repository
public interface IVentasCuerpo extends JpaRepository<Venta_cuerpo, Integer> {

}
